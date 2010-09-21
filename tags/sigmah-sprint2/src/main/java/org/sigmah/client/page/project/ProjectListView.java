/*
 * All Sigmah code is released under the GNU General Public License v3
 * See COPYRIGHT.txt and LICENSE.txt.
 */

package org.sigmah.client.page.project;

import com.extjs.gxt.ui.client.event.Observable;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import org.sigmah.shared.dto.ProjectDTO;

import java.util.Arrays;

/**
 * Display the list of all the projects available to the user.
 * @author rca
 */
public class ProjectListView extends ContentPanel implements ProjectListPresenter.View  {

    private Grid<ProjectDTO> grid;
    private ListStore<ProjectDTO> store;

    /**
     * Create a new ProjectListView object.
     */
    public ProjectListView() {
        setLayout(new FitLayout());
        setHeading("Projects");
        store = new ListStore<ProjectDTO>();
        grid = new Grid<ProjectDTO>(store, createColumnModel());
        add(grid);
    }

    /**
     * Initialize the columns shown by the grid.
     * @return A new {@link ColumnModel} configured to display the id, name and owner of the projects.
     */
    private ColumnModel createColumnModel() {
        ColumnConfig id = new ColumnConfig("id", "ID", 100);
        ColumnConfig name = new ColumnConfig("name", "Name", 200);
        ColumnConfig owner = new ColumnConfig("owner", "Owner", 100);

        return new ColumnModel(Arrays.asList(id, name, owner));
    }

    @Override
    public Observable getGrid() {
        return grid;
    }

    @Override
    public ListStore getStore() {
        return store;
    }
}