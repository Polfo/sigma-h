package org.sigmah.client.page.project.logframe.grid;

import org.sigmah.client.EventBus;
import org.sigmah.client.dispatch.Dispatcher;
import org.sigmah.client.event.IndicatorEvent;
import org.sigmah.client.i18n.I18N;
import org.sigmah.client.page.common.dialog.FormDialogCallback;
import org.sigmah.client.page.common.dialog.FormDialogImpl;
import org.sigmah.client.page.common.dialog.FormDialogTether;
import org.sigmah.client.page.config.design.IndicatorForm;
import org.sigmah.shared.dto.IndicatorDTO;
import org.sigmah.shared.dto.logframe.LogFrameElementDTO;

import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.dnd.ListViewDragSource;
import com.extjs.gxt.ui.client.dnd.ListViewDropTarget;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.ListViewEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ListView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class IndicatorListWidget extends Composite  {

	private static final String DRAG_AND_DROP_GROUP = "logframeIndicators";
	private static IndicatorListWidgetUiBinder uiBinder = GWT
			.create(IndicatorListWidgetUiBinder.class);

	interface IndicatorListWidgetUiBinder extends
			UiBinder<Widget, IndicatorListWidget> {
	}
	
	interface Style extends CssResource {
		String indicator();
		String indicatorLabel();
		String indicatorOver();
		String indicatorSelected();
		String sourceOfVerification();
	}
		
	private int databaseId;
	private LogFrameElementDTO element;
	
	private final Dispatcher dispatcher;

	@UiField
	Label newIndicatorLink;

	@UiField()
	ListView<IndicatorDTO> indicatorList;
	
	@UiField Style style;
	private ListStore<IndicatorDTO> store;

		
	public IndicatorListWidget(EventBus eventBus, Dispatcher dispatcher, int databaseId, LogFrameElementDTO element) {
		this.dispatcher = dispatcher;
		this.databaseId = databaseId;
		this.element = element;

		initWidget(uiBinder.createAndBindUi(this));
		
		store = new ListStore<IndicatorDTO>();
		store.add(element.getIndicators());
		
		indicatorList.setTemplate("<tpl for=\".\"><div class=" + style.indicator() + ">" +
				"<div><span class=" + style.indicatorLabel() + ">{name}</span></div>" + 
				"<tpl if=\"values.sourceOfVerification\">" +
				"<div class=" + style.sourceOfVerification() + ">" + 
					I18N.CONSTANTS.sourceOfVerification() + ": " + "{sourceOfVerification}</div>" +
				"</tpl></div></tpl>");
		indicatorList.setStore(store);
		indicatorList.setBorders(false);
		indicatorList.setOverStyle(style.indicatorOver());
		indicatorList.setSelectStyle(style.indicatorSelected());
		indicatorList.setItemSelector("." + style.indicator());
		
		indicatorList.addListener(Events.Select, new Listener<ListViewEvent<IndicatorDTO>>() {
			@Override
			public void handleEvent(ListViewEvent<IndicatorDTO> be) {
				onIndicatorClicked(be.getModel());
			}
		});

		new ListViewDragSource(indicatorList)
			.setGroup(DRAG_AND_DROP_GROUP);
		new ListViewDropTarget(indicatorList)
			.setGroup(DRAG_AND_DROP_GROUP);
		
		eventBus.addListener(IndicatorEvent.INDICATOR_CHANGED, new Listener<IndicatorEvent>() {

			@Override
			public void handleEvent(IndicatorEvent event) {
				onIndicatorChanged(event);			
			}
		});

	}

	@UiHandler("newIndicatorLink")
	void onClick(ClickEvent e) {
		final IndicatorDTO newIndicator = new IndicatorDTO();
		newIndicator.setCollectIntervention(true);
		newIndicator.setAggregation(IndicatorDTO.AGGREGATE_SUM);
		newIndicator.setDatabaseId(databaseId);
		newIndicator.setCategory( (element.getFormattedCode() + " " + element.getDescription()).trim() );
		
		showDialog(newIndicator, new FormDialogCallback() {

			@Override
			public void onValidated(FormDialogTether dlg) {
				dlg.hide();
				element.getIndicators().add(newIndicator);
				indicatorList.getStore().add(newIndicator);			
			}
		});
	}
	
	private void onIndicatorClicked(IndicatorDTO model) {
		showDialog(model, new FormDialogCallback() {

			@Override
			public void onValidated(FormDialogTether dlg) {
				dlg.hide();
				indicatorList.refresh();
			}
		});
	}
	
	private void showDialog(IndicatorDTO indicator, FormDialogCallback callback) {
		final IndicatorForm form = new IndicatorForm(dispatcher);
		form.getBinding().bind(indicator);
		form.setIdVisible(false);
		form.setCategoryVisible(false);
		
		final FormDialogImpl<IndicatorForm> dialog = new FormDialogImpl<IndicatorForm>(form);
		dialog.setHeading(indicator.getName() == null ? 
				I18N.CONSTANTS.newIndicator() : indicator.getName());
		dialog.setWidth(form.getPreferredDialogWidth());
		dialog.setHeight(form.getPreferredDialogHeight());
		dialog.setScrollMode(Scroll.AUTOY);
		dialog.show(callback);
	}


	private void onIndicatorChanged(IndicatorEvent event) {
		IndicatorDTO indicator = store.findModel("id", event.getEntityId());
		if(indicator != null) {
			switch(event.getChangeType()) {
			case DELETED:
				store.remove(indicator);
				break;
			case UPDATED:
				if(event.getChanges() != null) {
					event.applyChanges(indicator);
					store.update(indicator);
				}
			}
		}
		
	}

}
