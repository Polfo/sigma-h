package org.activityinfo.client.page.report;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Store;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.*;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.inject.Inject;
import org.activityinfo.client.Application;
import org.activityinfo.client.dispatch.Dispatcher;
import org.activityinfo.client.dispatch.callback.Got;
import org.activityinfo.client.dispatch.monitor.MaskingAsyncMonitor;
import org.activityinfo.client.page.common.grid.AbstractEditorGridView;
import org.activityinfo.client.page.common.widget.MappingComboBox;
import org.activityinfo.shared.command.GetSchema;
import org.activityinfo.shared.dto.ReportTemplateDTO;
import org.activityinfo.shared.dto.Schema;
import org.activityinfo.shared.dto.UserDatabaseDTO;
import org.activityinfo.shared.report.model.ReportFrequency;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Bertram (akbertram@gmail.com)
 */
public class ReportGrid extends AbstractEditorGridView<ReportTemplateDTO, ReportHomePresenter>
        implements ReportHomePresenter.View {

    private MappingComboBox<Integer> dayCombo;
    private String[] weekdays;
    private NumberFormat numberFormat;
    private final Dispatcher service;

    @Inject
    public ReportGrid(Dispatcher service) {
        this.service = service;

        setLayout(new FitLayout());
        setHeaderVisible(false);
        weekdays = LocaleInfo.getCurrentLocale().getDateTimeConstants().weekdays();
        numberFormat = NumberFormat.getFormat("0");
    }

    public void init(ReportHomePresenter presenter, ListStore<ReportTemplateDTO> store) {
        super.init(presenter, store);
    }

    @Override
    protected Grid<ReportTemplateDTO> createGridAndAddToContainer(Store store) {

        EditorGrid<ReportTemplateDTO> grid = new EditorGrid<ReportTemplateDTO>((ListStore) store, createColumnModel());
        grid.addListener(Events.BeforeEdit, new Listener<GridEvent<ReportTemplateDTO>>() {
            public void handleEvent(GridEvent<ReportTemplateDTO> be) {
                ReportTemplateDTO report = be.getModel();
                be.setCancelled(!(report.getFrequency() == ReportFrequency.Monthly ||
                        report.getFrequency() == ReportFrequency.Weekly ||
                        report.getFrequency() == ReportFrequency.Daily));
            }
        });

        GroupingView view = new GroupingView();
        view.setShowGroupedColumn(false);
        view.setForceFit(true);
        view.setGroupRenderer(new GridGroupRenderer() {
            public String render(GroupColumnData data) {
                return data.group;
            }
        });
        grid.setView(view);

        grid.setAutoExpandColumn("title");
        grid.setAutoExpandMin(250);

        grid.addListener(Events.CellDoubleClick, new Listener<GridEvent<ReportTemplateDTO>>() {
            public void handleEvent(GridEvent<ReportTemplateDTO> event) {
                if (event.getColIndex() == 1)
                    presenter.onTemplateSelected(event.getModel());
            }
        });

        add(grid);

        return grid;
    }

    private ColumnModel createColumnModel() {
        List<ColumnConfig> columns = new ArrayList<ColumnConfig>();

        columns.add(new ColumnConfig("databaseName", Application.CONSTANTS.database(), 100));

        ColumnConfig name = new ColumnConfig("title", Application.CONSTANTS.name(), 250);
        name.setRenderer(new GridCellRenderer<ReportTemplateDTO>() {
            public Object render(ReportTemplateDTO model, String property, ColumnData config, int rowIndex, int colIndex, ListStore listStore, Grid grid) {
                return "<b>" + model.getTitle() + "</b><br>" + model.getDescription();
            }
        });
        columns.add(name);

        ColumnConfig frequency = new ColumnConfig("frequency", Application.CONSTANTS.reportingFrequency(), 100);
        frequency.setRenderer(new GridCellRenderer<ReportTemplateDTO>() {
            public Object render(ReportTemplateDTO model, String property, ColumnData config, int rowIndex, int colIndex, ListStore listStore, Grid grid) {
                if (model.getFrequency() == ReportFrequency.Monthly) {
                    return Application.CONSTANTS.monthly();
                } else if (model.getFrequency() == ReportFrequency.Weekly) {
                    return Application.CONSTANTS.weekly();
                } else if (model.getFrequency() == ReportFrequency.Daily) {
                    return Application.CONSTANTS.daily();
                } else if (model.getFrequency() == ReportFrequency.Adhoc) {
                    return "ad hoc";
                }
                return "-";
            }
        });
        columns.add(frequency);

        ColumnConfig day = new ColumnConfig("day", Application.CONSTANTS.day(), 100);
        day.setRenderer(new GridCellRenderer<ReportTemplateDTO>() {
            public Object render(ReportTemplateDTO model, String property, ColumnData config, int rowIndex, int colIndex, ListStore<ReportTemplateDTO> store, Grid<ReportTemplateDTO> grid) {
                if (model.getFrequency() == ReportFrequency.Weekly)
                    return model.getDay() < 7 ? weekdays[model.getDay()] :
                            weekdays[6];
                else if (model.getFrequency() == ReportFrequency.Monthly)
                    return Integer.toString(model.getDay());
                else
                    return "";
            }
        });
        columns.add(day);

        ColumnConfig subscribed = new ColumnConfig("subscribed", Application.CONSTANTS.subscribed(), 100);
        subscribed.setRenderer(new GridCellRenderer<ReportTemplateDTO>() {
            @Override
            public Object render(ReportTemplateDTO model, String property, ColumnData columnData, int rowIndex, int colIndex, ListStore<ReportTemplateDTO> store, Grid<ReportTemplateDTO> grid) {
                if (model.isSubscribed()) {
                    return Application.CONSTANTS.yes();
                } else {
                    return "";
                }
            }
        });

        final MappingComboBox<Boolean> subCombo = new MappingComboBox();
        subCombo.add(true, Application.CONSTANTS.yes());
        subCombo.add(false, Application.CONSTANTS.no());

        CellEditor subEditor = new CellEditor(subCombo) {
            @Override
            public Object preProcessValue(Object o) {
                return subCombo.wrap((Boolean) o);
            }

            @Override
            public Object postProcessValue(Object o) {
                return ((MappingComboBox.Wrapper) o).getWrappedValue();
            }
        };
        subscribed.setEditor(subEditor);
        columns.add(subscribed);

        return new ColumnModel(columns);
    }


    @Override
    protected void initToolBar() {
        toolBar.addSaveSplitButton();
        toolBar.add(new SeparatorToolItem());

        final Menu dbMenu = new Menu();
        dbMenu.addListener(Events.BeforeShow, new Listener<BaseEvent>() {
            @Override
            public void handleEvent(BaseEvent be) {
                if (dbMenu.getItemCount() == 0) {
                    service.execute(new GetSchema(), new MaskingAsyncMonitor(ReportGrid.this,
                            Application.CONSTANTS.loading()), new Got<Schema>() {

                        @Override
                        public void got(Schema result) {
                            for (final UserDatabaseDTO db : result.getDatabases()) {
                                MenuItem item = new MenuItem(db.getName());
                                item.setIcon(Application.ICONS.database());
                                item.addListener(Events.Select, new Listener<BaseEvent>() {
                                    @Override
                                    public void handleEvent(BaseEvent be) {
                                        presenter.onNewReport(db.getId());
                                    }
                                });
                                dbMenu.add(item);
                            }
                        }
                    });
                }
            }
        });

        Button newButton = new Button(Application.CONSTANTS.newText(), Application.ICONS.add());
        newButton.setMenu(dbMenu);
        toolBar.add(newButton);
    }


}