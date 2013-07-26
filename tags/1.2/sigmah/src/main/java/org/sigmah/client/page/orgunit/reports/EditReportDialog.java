/*
 * All Sigmah code is released under the GNU General Public License v3 See COPYRIGHT.txt and LICENSE.txt.
 */

package org.sigmah.client.page.orgunit.reports;

import java.io.Serializable;
import java.util.Map;

import org.sigmah.client.EventBus;
import org.sigmah.client.dispatch.Dispatcher;
import org.sigmah.client.event.NavigationEvent;
import org.sigmah.client.i18n.I18N;
import org.sigmah.client.page.NavigationHandler;
import org.sigmah.client.page.orgunit.OrgUnitPresenter;
import org.sigmah.client.page.orgunit.OrgUnitState;
import org.sigmah.client.util.Notification;
import org.sigmah.shared.command.CreateEntity;
import org.sigmah.shared.command.UpdateEntity;
import org.sigmah.shared.command.result.CreateResult;
import org.sigmah.shared.command.result.VoidResult;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author Kristela Macaj (kmacaj@ideia.fr)
 */
public class EditReportDialog {

    private static Dialog editReportDialog;

    private static Dialog getDialog() {
        if (editReportDialog == null) {
            final Dialog dialog = new Dialog();
            dialog.setButtons(Dialog.OKCANCEL);
            dialog.setHeading(I18N.CONSTANTS.reportCreateReport());
            dialog.setModal(true);

            dialog.setResizable(false);
            dialog.setWidth("340px");

            dialog.setLayout(new FormLayout());

            // Report name
            final TextField<String> nameField = new TextField<String>();
            nameField.setFieldLabel(I18N.CONSTANTS.reportName());
            nameField.setAllowBlank(false);
            nameField.setName("name");
            dialog.add(nameField);

            // Cancel button
            dialog.getButtonById(Dialog.CANCEL).addSelectionListener(new SelectionListener<ButtonEvent>() {

                @Override
                public void componentSelected(ButtonEvent ce) {
                    dialog.hide();
                }
            });

            editReportDialog = dialog;
        }
        return editReportDialog;
    }

    /**
     * Dialog used to <b>create</b> a report from outside the "Report & Documents" page.
     * 
     * @param properties
     *            Base properties of the new report (should contain the report model id).
     * @param reportButton
     * @param eventBus
     * @param dispatcher
     * @return The create report dialog.
     */
    public static Dialog getDialog(final Map<String, Serializable> properties,
            final com.google.gwt.user.client.ui.Button reportButton, final HandlerRegistration[] registrations,
            final EventBus eventBus, final Dispatcher dispatcher) {
        final Dialog dialog = getDialog();

        // OK Button
        final Button okButton = dialog.getButtonById(Dialog.OK);

        okButton.removeAllListeners();
        okButton.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                final String name = ((TextField<String>) dialog.getWidget(0)).getValue();

                properties.put("name", name);

                final CreateEntity createEntity = new CreateEntity("ProjectReport", properties);
                dispatcher.execute(createEntity, null, new AsyncCallback<CreateResult>() {

                    @Override
                    public void onFailure(Throwable caught) {
                        MessageBox.alert(I18N.CONSTANTS.projectTabReports(), I18N.CONSTANTS.reportCreateError(), null);
                    }

                    @Override
                    public void onSuccess(final CreateResult result) {
                        reportButton.setText(I18N.MESSAGES.reportOpenReport(name));
                        registrations[0].removeHandler();

                        reportButton.addClickHandler(new ClickHandler() {

                            @Override
                            public void onClick(ClickEvent event) {
                                final OrgUnitState targetState =
                                        new OrgUnitState((Integer) properties.get("orgUnitId"));
                                targetState.setCurrentSection(OrgUnitPresenter.REPORT_TAB_INDEX);
                                targetState.setArgument(Integer.toString(result.getNewId()));

                                eventBus.fireEvent(new NavigationEvent(NavigationHandler.NavigationRequested,
                                    targetState, null));
                            }
                        });

                        Notification.show(I18N.CONSTANTS.projectTabReports(), I18N.CONSTANTS.reportCreateSuccess());
                    }
                });

                dialog.hide();
            }

        });

        return dialog;
    }

    /**
     * Dialog used to <b>rename</b> a report from the "Report & Documents" page.
     * 
     * @param properties
     *            Base properties of the report (may be empty but not null).
     * @param dispatcher
     * @return The rename report dialog.
     */
    public static Dialog getDialog(final Map<String, Serializable> properties, final Integer reportId,
            final Dispatcher dispatcher, final AsyncCallback<VoidResult> callback) {
        final Dialog dialog = getDialog();

        // OK Button
        final Button okButton = dialog.getButtonById(Dialog.OK);

        okButton.removeAllListeners();
        okButton.addSelectionListener(new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                final String name = ((TextField<String>) dialog.getWidget(0)).getValue();

                properties.put("name", name);

                final UpdateEntity updateEntity =
                        new UpdateEntity("ProjectReport", reportId, (Map<String, Object>) (Map<String, ?>) properties);
                dispatcher.execute(updateEntity, null, callback);

                dialog.hide();
            }

        });

        return dialog;
    }
}
