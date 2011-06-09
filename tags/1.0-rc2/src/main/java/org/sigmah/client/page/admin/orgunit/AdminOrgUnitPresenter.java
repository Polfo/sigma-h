package org.sigmah.client.page.admin.orgunit;

import org.sigmah.client.cache.UserLocalCache;
import org.sigmah.client.dispatch.Dispatcher;
import org.sigmah.client.dispatch.remote.Authentication;
import org.sigmah.client.i18n.I18N;
import org.sigmah.client.page.admin.AdminPageState;
import org.sigmah.client.page.admin.AdminSubPresenter;
import org.sigmah.shared.command.RemoveOrgUnit;
import org.sigmah.shared.command.result.VoidResult;
import org.sigmah.shared.dto.OrgUnitDTOLight;

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class AdminOrgUnitPresenter implements AdminSubPresenter {

    private final View view;
    private final Dispatcher dispatcher;
    private final UserLocalCache cache;

    public static abstract class View extends ContentPanel {

        public abstract TreeGrid<OrgUnitDTOLight> getTree();

        public abstract TreeStore<OrgUnitDTOLight> getStore();

        public abstract Button getAddButton();

        public abstract Button getMoveButton();

        public abstract Button getRemoveButton();

        public abstract ContentPanel getMainPanel();
    }

    public AdminOrgUnitPresenter(Dispatcher dispatcher, UserLocalCache cache, Authentication authentication) {
        this.view = new AdminOrgUnitView();
        this.dispatcher = dispatcher;
        this.cache = cache;
    }

    @Override
    public Component getView() {

        // Add.
        view.getAddButton().addListener(Events.OnClick, new Listener<ButtonEvent>() {

            @Override
            public void handleEvent(ButtonEvent be) {

                final OrgUnitDTOLight parent = view.getTree().getSelectionModel().getSelectedItem();
                if (parent != null) {

                    final AddOrgUnitWindow window = new AddOrgUnitWindow(dispatcher, cache);
                    window.addListener(new AddOrgUnitWindow.CreateOrgUnitListener() {

                        @Override
                        public void orgUnitCreated() {
                            refreshCache();
                        }
                    });

                    window.show(parent.getId());
                }
            }
        });

        // Remove.
        view.getRemoveButton().addListener(Events.OnClick, new Listener<ButtonEvent>() {

            @Override
            public void handleEvent(ButtonEvent be) {

                final OrgUnitDTOLight removed = view.getTree().getSelectionModel().getSelectedItem();
                if (removed != null) {

                    MessageBox.confirm(I18N.CONSTANTS.adminOrgUnitRemove(),
                            I18N.MESSAGES.adminOrgUnitRemoveConfirm(removed.getName()),
                            new Listener<MessageBoxEvent>() {

                                @Override
                                public void handleEvent(MessageBoxEvent be) {

                                    if (Dialog.YES.equals(be.getButtonClicked().getItemId())) {

                                        if (removed.getChildCount() != 0) {
                                            MessageBox.alert(I18N.CONSTANTS.adminOrgUnitRemoveUnavailable(),
                                                    I18N.CONSTANTS.adminOrgUnitRemoveHasChildren(), null);
                                        } else {

                                            dispatcher.execute(new RemoveOrgUnit(removed.getId()), null,
                                                    new AsyncCallback<VoidResult>() {

                                                        @Override
                                                        public void onFailure(Throwable caught) {
                                                            MessageBox.alert(I18N.CONSTANTS
                                                                    .adminOrgUnitRemoveUnavailable(), I18N.CONSTANTS
                                                                    .adminOrgUnitRemoveHasChildrenOrProjects(), null);
                                                            refreshCache();
                                                        }

                                                        @Override
                                                        public void onSuccess(VoidResult result) {
                                                            refreshCache();
                                                        }
                                                    });
                                        }
                                    }
                                }
                            });
                }
            }
        });

        // Move.
        view.getMoveButton().addListener(Events.OnClick, new Listener<ButtonEvent>() {

            @Override
            public void handleEvent(ButtonEvent be) {

                final OrgUnitDTOLight moved = view.getTree().getSelectionModel().getSelectedItem();
                if (moved != null) {

                    final MoveOrgUnitWindow window = new MoveOrgUnitWindow(dispatcher, cache);
                    window.addListener(new MoveOrgUnitWindow.MoveOrgUnitListener() {

                        @Override
                        public void orgUnitMoved() {
                            refreshCache();
                        }
                    });

                    window.show(moved.getId());
                }
            }
        });

        view.getTree().getSelectionModel().addSelectionChangedListener(new SelectionChangedListener<OrgUnitDTOLight>() {

            @Override
            public void selectionChanged(SelectionChangedEvent<OrgUnitDTOLight> se) {

                final OrgUnitDTOLight selection = view.getTree().getSelectionModel().getSelectedItem();
                final boolean enabled = selection != null;

                view.getAddButton().setEnabled(enabled);
                view.getMoveButton().setEnabled(enabled);
                view.getRemoveButton().setEnabled(enabled);
            }
        });

        view.getTree().addListener(Events.Attach, new Listener<BaseEvent>() {

            @Override
            public void handleEvent(BaseEvent be) {
                view.getTree().setExpanded(view.getStore().getRootItems().get(0), true, false);
            }
        });

        view.getAddButton().setEnabled(false);
        view.getMoveButton().setEnabled(false);
        view.getRemoveButton().setEnabled(false);

        refreshTree();

        return view.getMainPanel();
    }

    @Override
    public void discardView() {
    }

    @Override
    public void viewDidAppear() {
    }

    @Override
    public void setCurrentState(AdminPageState currentState) {
    }

    private void refreshCache() {
        cache.refreshOrganization(new AsyncCallback<Void>() {

            @Override
            public void onFailure(Throwable caught) {
                refreshTree();
            }

            @Override
            public void onSuccess(Void result) {
                refreshTree();
            }
        });
    }

    private void refreshTree() {

        // Gets user's organization.
        cache.getOrganizationCache().get(new AsyncCallback<OrgUnitDTOLight>() {

            @Override
            public void onFailure(Throwable e) {
                // nothing
            }

            @Override
            public void onSuccess(OrgUnitDTOLight result) {

                if (result != null) {
                    view.getStore().removeAll();
                    view.getStore().add(result, true);
                    view.getTree().setExpanded(result, true, false);
                }
            }
        });
    }
}
