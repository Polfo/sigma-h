/*
 * All Sigmah code is released under the GNU General Public License v3 See COPYRIGHT.txt and LICENSE.txt.
 */

package org.sigmah.client.page.project;

import com.extjs.gxt.ui.client.widget.Component;

/**
 * Describes a sub-presenter of the Project page.
 * 
 * @author Raphaël Calabro (rcalabro@ideia.fr)
 */
public interface SubPresenter {

    /**
     * Retrieves the view of the presenter.
     * 
     * @return The current view.
     */
    public Component getView();

    /**
     * Free the current view.
     */
    public void discardView();

    /**
     * Allows the component to perform custom initialization just after it has been rendered.
     */
    public void viewDidAppear();

    /**
     * Indicates if the presenter has its values changed
     */
    public boolean hasValueChanged();

    /**
     * Empty the list of changed values
     */
    public void forgetAllChangedValues();
}
