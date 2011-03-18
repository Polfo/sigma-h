/*
 * All Sigmah code is released under the GNU General Public License v3
 * See COPYRIGHT.txt and LICENSE.txt.
 */

package org.sigmah.client.page.table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sigmah.client.AppEvents;
import org.sigmah.client.EventBus;
import org.sigmah.client.event.PivotCellEvent;
import org.sigmah.client.i18n.I18N;
import org.sigmah.client.icon.IconUtil;
import org.sigmah.shared.report.content.EntityCategory;
import org.sigmah.shared.report.content.PivotTableData;
import org.sigmah.shared.report.model.Dimension;
import org.sigmah.shared.report.model.DimensionType;
import org.sigmah.shared.report.model.PivotElement;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.util.DelayedTask;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.HeaderGroupConfig;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.treegrid.EditorTreeGrid;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGridCellRenderer;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.HasValue;
import com.google.inject.Inject;

/**
 * 
 * Independent component to display and edited pivoted site / indicator results.
 * 
 * @author Alex Bertram
 */
public class PivotGridPanel extends ContentPanel implements HasValue<PivotElement> {

    protected EventBus eventBus;

    protected PivotElement element;
    protected EditorTreeGrid<PivotTableRow> grid;
    protected TreeStore<PivotTableRow> store;
    protected ColumnModel columnModel;
    protected Map<PivotTableData.Axis, String> propertyMap;
    protected Map<Integer, PivotTableData.Axis> columnMap;
    
    private boolean showIcons = true;

    @Inject
    public PivotGridPanel(EventBus eventBus) {
        this.eventBus = eventBus;
        setLayout(new FitLayout());
        
        PivotResources.INSTANCE.css().ensureInjected();
    }

    public class PivotTableRow extends BaseTreeModel {

        private PivotTableData.Axis rowAxis;

        public PivotTableRow(PivotTableData.Axis axis) {
            this.rowAxis = axis;
            set("header", decorateHeader(axis.getLabel()));

            for(Map.Entry<PivotTableData.Axis, PivotTableData.Cell> entry : axis.getCells().entrySet()) {
                set(propertyMap.get(entry.getKey()), entry.getValue().getValue());
            }

            for(PivotTableData.Axis child : axis.getChildren()) {
                add(new PivotTableRow(child));
            }
        }

        public PivotTableData.Axis getRowAxis() {
            return rowAxis;
        }
    }

    public void setData(final PivotElement element) {
        if(grid != null) {
            removeAll();
        }

        this.element = element;

        PivotTableData data = element.getContent().getData();

        propertyMap = new HashMap<PivotTableData.Axis, String>();
        columnMap = new HashMap<Integer, PivotTableData.Axis>();

        store = new TreeStore<PivotTableRow>();

        columnModel = createColumnModel(data);

        for(PivotTableData.Axis axis : data.getRootRow().getChildren()) {
            store.add(new PivotTableRow(axis), true);
        }

        grid = new EditorTreeGrid<PivotTableRow>(store, createColumnModel(data));
        grid.setView(new PivotGridPanelView());
        grid.getStyle().setNodeCloseIcon(null);
        grid.getStyle().setNodeOpenIcon(null);
        grid.setAutoExpandColumn("header");
        grid.setAutoExpandMin(150);
        grid.addListener(Events.CellDoubleClick, new Listener<GridEvent<PivotTableRow>>() {
            public void handleEvent(GridEvent<PivotTableRow> ge) {
                if(ge.getColIndex() != 0) {
                    eventBus.fireEvent(new PivotCellEvent(AppEvents.Drilldown,
                            element,
                            ge.getModel().getRowAxis(),
                            columnMap.get(ge.getColIndex())));
                }
            }
        });
        grid.addStyleName(PivotResources.INSTANCE.css().pivotTable());
        

        add(grid);

        layout();

        new DelayedTask(new Listener<BaseEvent>() {
            public void handleEvent(BaseEvent be) {
                for(PivotTableRow row : store.getRootItems()) {
                    grid.setExpanded(row, true, true);
                }

            }
        }).delay(1);

    }

    protected int findIndicatorId(PivotTableData.Axis axis) {
        while(axis != null) {
            if(axis.getDimension().getType() == DimensionType.Indicator) {
                return ((EntityCategory)axis.getCategory()).getId();
            }
            axis = axis.getParent();
        }
        return -1;
    }

    protected ColumnModel createColumnModel(PivotTableData data) {

        List<ColumnConfig> config = new ArrayList<ColumnConfig>();

        ColumnConfig rowHeader = new ColumnConfig("header", "", 150);
        rowHeader.setRenderer(new TreeGridCellRenderer() {

			@Override
			public Object render(ModelData model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore store, Grid grid) {
				Object result = super.render(model, property, config, rowIndex, colIndex, store, grid);
				config.css = config.css + " x-grid3-header";
				return result;
			}
        	
        });
        rowHeader.setSortable(false);
        rowHeader.setMenuDisabled(true);
        config.add(rowHeader);

        int colIndex = 1;

        List<PivotTableData.Axis> leaves = data.getRootColumn().getLeaves();
        for(PivotTableData.Axis axis : leaves) {


            String id = "col" + colIndex;

            String label = axis.getLabel();
            if(label == null) {
                label = I18N.CONSTANTS.value();
            }
            ColumnConfig column = new ColumnConfig(id, decorateHeader(label), 75);
            column.setNumberFormat(NumberFormat.getFormat("#,##0"));
            column.setAlignment(Style.HorizontalAlignment.RIGHT);
            column.setSortable(false);
            column.setMenuDisabled(true);
            
            NumberField valueField = new NumberField();            
            column.setEditor(new CellEditor(valueField));

            propertyMap.put(axis, id);
            columnMap.put(colIndex, axis);


            config.add(column);
            colIndex++;
        }

        ColumnModel columnModel = new ColumnModel(config);

        int depth = data.getRootColumn().getDepth();
        int row = 0;

        for(int d = 1; d<=depth; ++d) {

            List<PivotTableData.Axis> children = data.getRootColumn().getDescendantsAtDepth(d);

            // first add a group identifying the dimension

            Dimension dim = children.get(0).getDimension();

            // now add child columns

            if(d < depth) {

                int col = 1;
                for(PivotTableData.Axis child : children) {

                    int colSpan = child.getLeaves().size();
                    columnModel.addHeaderGroup(row, col, new HeaderGroupConfig(child.getLabel(), 1, colSpan) );

                    col += colSpan;

                }
                row++;

            }

        }
        return columnModel;
    }

    private String decorateHeader(String header) {
    	if(showIcons) {
    		return header + IconUtil.iconHtml(PivotResources.INSTANCE.css().zoomIcon()) +
    			IconUtil.iconHtml(PivotResources.INSTANCE.css().editIcon());
    	} else {
    		return header;
    	}
    }
    
	@Override
	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<PivotElement> handler) {
		return addHandler(handler, ValueChangeEvent.getType());
	}

	@Override
	public PivotElement getValue() {
		return element;
	}

	@Override
	public void setValue(PivotElement value) {
		setData(value);
	}

	@Override
	public void setValue(PivotElement value, boolean fireEvents) {
		setData(element);
		if(fireEvents) {
			ValueChangeEvent.fire(this, value);
		}
	}

}
