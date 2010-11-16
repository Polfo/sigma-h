/*
 * All Sigmah code is released under the GNU General Public License v3
 * See COPYRIGHT.txt and LICENSE.txt.
 */

package org.sigmah.client.page.dashboard;

import java.util.Arrays;
import java.util.HashMap;

import org.sigmah.client.EventBus;
import org.sigmah.client.dispatch.Dispatcher;
import org.sigmah.client.dispatch.remote.Authentication;
import org.sigmah.client.event.NavigationEvent;
import org.sigmah.client.i18n.I18N;
import org.sigmah.client.icon.IconImageBundle;
import org.sigmah.client.page.NavigationHandler;
import org.sigmah.client.page.PageState;
import org.sigmah.client.page.charts.ChartPageState;
import org.sigmah.client.page.common.toolbar.ActionListener;
import org.sigmah.client.page.common.toolbar.ActionToolBar;
import org.sigmah.client.page.common.toolbar.UIActions;
import org.sigmah.client.page.config.DbListPageState;
import org.sigmah.client.page.dashboard.CreateProjectWindow.CreateProjectListener;
import org.sigmah.client.page.entry.SiteGridPageState;
import org.sigmah.client.page.map.MapPageState;
import org.sigmah.client.page.project.ProjectPresenter;
import org.sigmah.client.page.report.ReportListPageState;
import org.sigmah.client.page.table.PivotPageState;
import org.sigmah.client.ui.StylableVBoxLayout;
import org.sigmah.client.util.Notification;
import org.sigmah.shared.command.GetCountries;
import org.sigmah.shared.command.GetProjects;
import org.sigmah.shared.command.result.CountryResult;
import org.sigmah.shared.command.result.ProjectListResult;
import org.sigmah.shared.dto.CountryDTO;
import org.sigmah.shared.dto.ProjectDTOLight;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.store.StoreSorter;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.util.Padding;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.CheckBoxSelectionModel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayoutData;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;
import com.extjs.gxt.ui.client.widget.treegrid.WidgetTreeGridCellRenderer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

/**
 * Displays the dashboard.
 * 
 * @author Raphaël Calabro (rcalabro@ideia.fr)
 */
public class DashboardView extends ContentPanel {
    private final static int BORDER = 8;
    private final static String STYLE_MAIN_BACKGROUND = "main-background";

    public DashboardView(final EventBus eventBus, final Dispatcher dispatcher, final Authentication authentication,
            final TreeStore<ProjectDTOLight> projectStore, final ListStore<CountryDTO> countryStore) {
        // The dashboard itself
        final BorderLayout borderLayout = new BorderLayout();
        borderLayout.setContainerStyle("x-border-layout-ct " + STYLE_MAIN_BACKGROUND);
        setLayout(borderLayout);
        setHeaderVisible(false);
        setBorders(false);

        // Left bar
        final ContentPanel leftPanel = new ContentPanel();
        final VBoxLayout leftPanelLayout = new StylableVBoxLayout(STYLE_MAIN_BACKGROUND);
        leftPanelLayout.setVBoxLayoutAlign(VBoxLayout.VBoxLayoutAlign.STRETCH);
        leftPanelLayout.setPadding(new Padding(0));
        leftPanel.setLayout(leftPanelLayout);
        leftPanel.setHeaderVisible(false);
        leftPanel.setBorders(false);
        leftPanel.setBodyBorder(false);

        // Left bar content
        final VBoxLayoutData vBoxLayoutData = new VBoxLayoutData();
        vBoxLayoutData.setFlex(1.0);
        vBoxLayoutData.setMargins(new Margins(0, 0, BORDER, 0));

        final ContentPanel remindersPanel = new ContentPanel(new FitLayout());
        remindersPanel.setHeading(I18N.CONSTANTS.reminders());
        leftPanel.add(remindersPanel, vBoxLayoutData);

        final ContentPanel importantPointsPanel = new ContentPanel(new FitLayout());
        importantPointsPanel.setHeading(I18N.CONSTANTS.importantPoints());
        leftPanel.add(importantPointsPanel, vBoxLayoutData);

        final ContentPanel menuPanel = new ContentPanel();
        final VBoxLayout menuPanelLayout = new VBoxLayout();
        menuPanelLayout.setVBoxLayoutAlign(VBoxLayout.VBoxLayoutAlign.STRETCH);
        menuPanel.setLayout(menuPanelLayout);
        menuPanel.setHeading(I18N.CONSTANTS.menu());

        // Menu
        addNavLink(eventBus, menuPanel, I18N.CONSTANTS.createProjectNewProject(), IconImageBundle.ICONS.add(),
                new Listener<ButtonEvent>() {

                    private final CreateProjectWindow window = new CreateProjectWindow(dispatcher, authentication);

                    {
                        window.addListener(new CreateProjectListener() {

                            @Override
                            public void projectCreated(ProjectDTOLight project) {

                                // Show notification.
                                Notification.show(I18N.CONSTANTS.createProjectSucceeded(),
                                        I18N.CONSTANTS.createProjectSucceededDetails());

                                // Refreshes the countries list if needed.
                                dispatcher.execute(new GetCountries(true), null, new AsyncCallback<CountryResult>() {

                                    @Override
                                    public void onFailure(Throwable throwable) {
                                        // Nothing to do, need hard refreshing.
                                    }

                                    @Override
                                    public void onSuccess(CountryResult countryResult) {

                                        if (countryResult == null || countryResult.getData() == null
                                                || countryResult.getData().isEmpty()) {
                                            return;
                                        }

                                        if (Log.isDebugEnabled()) {
                                            Log.debug("Refreshes the countries list.");
                                        }

                                        // Checks if some new countries have
                                        // projects.
                                        if (countryStore.getCount() != countryResult.getData().size()) {

                                            if (Log.isDebugEnabled()) {
                                                Log.debug("Some new countries have been added.");
                                            }

                                            // Temporally stores the actual
                                            // displayed countries.
                                            final HashMap<Integer, CountryDTO> refreshedCountries = new HashMap<Integer, CountryDTO>();
                                            for (final CountryDTO country : countryStore.getModels()) {
                                                refreshedCountries.put(country.getId(), country);
                                            }

                                            // The widget needs to be refreshed.
                                            for (final CountryDTO country : countryResult.getData()) {
                                                // New country.
                                                if (refreshedCountries.get(country.getId()) == null) {
                                                    countryStore.add(country);
                                                    if (Log.isDebugEnabled()) {
                                                        Log.debug("Adds the country: " + country.getName() + ".");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                });
                            }

                            @Override
                            public void projectCreatedAsFunded(ProjectDTOLight project, double percentage) {
                                // nothing to do (must not be called).
                            }

                            @Override
                            public void projectCreatedAsFunding(ProjectDTOLight project, double percentage) {
                                // nothing to do (must not be called).
                            }
                        });
                    }

                    @Override
                    public void handleEvent(ButtonEvent be) {
                        window.show();
                    }
                });

        // Temporary code to hide/show activityInfo menus
        Dictionary sigmahParams;
        boolean showActivityInfoMenus = false;
        try {
            sigmahParams = Dictionary.getDictionary("SigmahParams");
            showActivityInfoMenus = Boolean.parseBoolean(sigmahParams.get("showActivityInfoMenus"));
            if (Log.isDebugEnabled()) {
                Log.debug("[DashboardView] Show activityInfo menus ? " + showActivityInfoMenus);
            }
        } catch (Exception e) {
            Log.fatal("DictionaryAuthenticationProvider: exception retrieving dictionary 'SigmahParams' from page", e);
            throw new Error();
        }
        if (showActivityInfoMenus) {
            addNavLink(eventBus, menuPanel, I18N.CONSTANTS.dataEntry(), IconImageBundle.ICONS.dataEntry(),
                    new SiteGridPageState());
            addNavLink(eventBus, menuPanel, I18N.CONSTANTS.reports(), IconImageBundle.ICONS.report(),
                    new ReportListPageState());
            addNavLink(eventBus, menuPanel, I18N.CONSTANTS.charts(), IconImageBundle.ICONS.barChart(),
                    new ChartPageState());
            addNavLink(eventBus, menuPanel, I18N.CONSTANTS.maps(), IconImageBundle.ICONS.map(), new MapPageState());
            addNavLink(eventBus, menuPanel, I18N.CONSTANTS.tables(), IconImageBundle.ICONS.table(),
                    new PivotPageState());
            addNavLink(eventBus, menuPanel, I18N.CONSTANTS.setup(), IconImageBundle.ICONS.setup(),
                    new DbListPageState());
        }

        final VBoxLayoutData bottomVBoxLayoutData = new VBoxLayoutData();
        bottomVBoxLayoutData.setFlex(1.0);
        bottomVBoxLayoutData.setMargins(new Margins(0, 0, 0, 0));
        leftPanel.add(menuPanel, bottomVBoxLayoutData);

        final BorderLayoutData leftLayoutData = new BorderLayoutData(LayoutRegion.WEST, 250);
        leftLayoutData.setMargins(new Margins(0, BORDER / 2, 0, 0));
        // leftLayoutData.setSplit(true);
        add(leftPanel, leftLayoutData);

        // Main panel
        final ContentPanel mainPanel = new ContentPanel();
        final VBoxLayout mainPanelLayout = new StylableVBoxLayout(STYLE_MAIN_BACKGROUND);
        mainPanelLayout.setVBoxLayoutAlign(VBoxLayout.VBoxLayoutAlign.STRETCH);
        mainPanel.setLayout(mainPanelLayout);
        mainPanel.setHeaderVisible(false);
        mainPanel.setBorders(false);
        mainPanel.setBodyBorder(false);

        // Country list panel
        final ContentPanel missionTreePanel = new ContentPanel(new FitLayout());
        missionTreePanel.setHeading(I18N.CONSTANTS.location());
        final VBoxLayoutData smallVBoxLayoutData = new VBoxLayoutData();
        smallVBoxLayoutData.setFlex(1.0);
        smallVBoxLayoutData.setMargins(new Margins(0, 0, BORDER, 0));
        mainPanel.add(missionTreePanel, smallVBoxLayoutData);

        // Country list
        final CheckBoxSelectionModel<CountryDTO> selectionModel = new CheckBoxSelectionModel<CountryDTO>();

        final ColumnConfig countryName = new ColumnConfig("completeName", I18N.CONSTANTS.name(), 200);
        final ColumnModel countryColumnModel = new ColumnModel(Arrays.asList(selectionModel.getColumn(), countryName));

        final Grid<CountryDTO> countryGrid = new Grid<CountryDTO>(countryStore, countryColumnModel);
        countryGrid.setAutoExpandColumn("completeName");
        countryGrid.setSelectionModel(selectionModel);
        countryGrid.addPlugin(selectionModel);

        missionTreePanel.add(countryGrid);

        // Refresh button
        final ActionToolBar countryToolbar = new ActionToolBar(new ActionListener() {
            @Override
            public void onUIAction(String actionId) {
                if (UIActions.refresh.equals(actionId)) {
                    if (Log.isDebugEnabled()) {
                        Log.debug("Launching the gets projects command.");
                    }
                    dispatcher.execute(new GetProjects(selectionModel.getSelectedItems()), null,
                            new AsyncCallback<ProjectListResult>() {
                                @Override
                                public void onFailure(Throwable throwable) {
                                    Log.error("Gets projects command failed.", throwable);
                                    // TODO: Handle the failure
                                }

                                @Override
                                public void onSuccess(ProjectListResult projectList) {
                                    projectStore.removeAll();
                                    projectStore.add(projectList.getList(), true);
                                }
                            });
                }
            }
        });

        countryToolbar.addRefreshButton();

        missionTreePanel.setTopComponent(countryToolbar);

        // Project tree panel
        final ContentPanel projectTreePanel = new ContentPanel(new FitLayout());
        projectTreePanel.setHeading(I18N.CONSTANTS.projects());
        final VBoxLayoutData largeVBoxLayoutData = new VBoxLayoutData();
        largeVBoxLayoutData.setFlex(2.0);
        mainPanel.add(projectTreePanel, largeVBoxLayoutData);

        // Project list
        final ColumnConfig icon = new ColumnConfig("favorite", "-", 24);
        icon.setRenderer(new GridCellRenderer<ProjectDTOLight>() {
            private final DashboardImageBundle imageBundle = GWT.create(DashboardImageBundle.class);

            @Override
            public Object render(final ProjectDTOLight model, String property, ColumnData config, int rowIndex,
                    int colIndex, final ListStore<ProjectDTOLight> store, final Grid<ProjectDTOLight> grid) {
                final Image icon;

                if (model.isFavorite())
                    icon = imageBundle.star().createImage();
                else
                    icon = imageBundle.emptyStar().createImage();

                icon.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        model.setFavorite(!model.isFavorite());
                        // TODO: Save the changes
                    }
                });

                return icon;
            }
        });

        final ColumnConfig name = new ColumnConfig("name", I18N.CONSTANTS.projectName(), 200);
        name.setRenderer(new WidgetTreeGridCellRenderer<ProjectDTOLight>() {
            @Override
            public Widget getWidget(ProjectDTOLight model, String property, ColumnData config, int rowIndex,
                    int colIndex, ListStore<ProjectDTOLight> store, Grid<ProjectDTOLight> grid) {
                return new Hyperlink((String) model.get(property), true, ProjectPresenter.PAGE_ID.toString() + '!'
                        + model.get("id").toString());
            }
        });

        final ColumnConfig phase = new ColumnConfig("phase", I18N.CONSTANTS.projectActivePhase(), 100);
        phase.setRenderer(new GridCellRenderer<ProjectDTOLight>() {
            @Override
            public Object render(ProjectDTOLight model, String property, ColumnData config, int rowIndex, int colIndex,
                    ListStore<ProjectDTOLight> store, Grid<ProjectDTOLight> grid) {
                return model.getCurrentPhaseDTO().getPhaseModelDTO().getName();
            }
        });

        final ColumnModel columnModel = new ColumnModel(Arrays.asList(icon, name, phase));

        final TreeGrid<ProjectDTOLight> projectTreeGrid = new TreeGrid<ProjectDTOLight>(projectStore, columnModel);

        projectStore.setStoreSorter(new StoreSorter<ProjectDTOLight>() {
            @Override
            public int compare(Store<ProjectDTOLight> store, ProjectDTOLight m1, ProjectDTOLight m2, String property) {

                if ("name".equals(property)) {
                    return m1.getName().compareToIgnoreCase(m2.getName());
                } else if ("phase".equals(property)) {
                    return m1.getCurrentPhaseDTO().getPhaseModelDTO().getName()
                            .compareToIgnoreCase(m2.getCurrentPhaseDTO().getPhaseModelDTO().getName());
                } else {
                    return super.compare(store, m1, m2, property);
                }
            }
        });

        projectTreePanel.add(projectTreeGrid);

        final BorderLayoutData mainLayoutData = new BorderLayoutData(LayoutRegion.CENTER);
        mainLayoutData.setMargins(new Margins(0, 0, 0, BORDER / 2));
        add(mainPanel, mainLayoutData);
    }

    /**
     * Creates a navigation button in the given panel.
     * 
     * @param eventBus
     *            Event bus of the application
     * @param panel
     *            Placeholder of the button
     * @param text
     *            Label of the button
     * @param icon
     *            Icon displayed next to the label
     * @param place
     *            The user will be redirected there when the button is clicked
     */
    private void addNavLink(final EventBus eventBus, final ContentPanel panel, final String text,
            final AbstractImagePrototype icon, final PageState place) {
        final Button button = new Button(text, icon, new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
                eventBus.fireEvent(new NavigationEvent(NavigationHandler.NavigationRequested, place));
            }
        });

        final VBoxLayoutData vBoxLayoutData = new VBoxLayoutData();
        vBoxLayoutData.setFlex(1.0);
        panel.add(button, vBoxLayoutData);
    }

    /**
     * Creates a navigation button in the given panel.
     * 
     * @param eventBus
     *            Event bus of the application
     * @param panel
     *            Placeholder of the button
     * @param text
     *            Label of the button
     * @param icon
     *            Icon displayed next to the label
     * @param clickHandler
     *            The action executed when the button is clicked
     */
    private void addNavLink(final EventBus eventBus, final ContentPanel panel, final String text,
            final AbstractImagePrototype icon, final Listener<ButtonEvent> clickHandler) {

        final Button button = new Button(text, icon);
        button.addListener(Events.OnClick, clickHandler);

        final VBoxLayoutData vBoxLayoutData = new VBoxLayoutData();
        vBoxLayoutData.setFlex(1.0);
        panel.add(button, vBoxLayoutData);
    }
}