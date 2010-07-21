/*
 * All Sigmah code is released under the GNU General Public License v3
 * See COPYRIGHT.txt and LICENSE.txt.
 */

package org.sigmah.client;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.util.Theme;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import org.sigmah.client.event.NavigationEvent;
import org.sigmah.client.page.NavigationHandler;
import org.sigmah.client.page.project.ProjectListState;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SigmahEntryPoint implements EntryPoint {

    /**
	 * This is the entry point method.
	 */
    @Override
	public void onModuleLoad() {

        Log.info("Application: onModuleLoad starting");

        if(!GWT.isScript()) {
            Log.setCurrentLogLevel(Log.LOG_LEVEL_TRACE);
        }
        if(Log.isErrorEnabled()) {
            GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {
                @Override
                public void onUncaughtException(Throwable e) {
                    Log.error("Uncaught exception", e);
                }
            });
        }

        GXT.setDefaultTheme(Theme.GRAY, true);

        Log.trace("Application: GXT theme set");

        SigmahInjector injector = GWT.create(SigmahInjector.class);

        injector.getEventBus();
        injector.getNavigationHandler();
        injector.getProjectListPresenter();
        injector.getProjectPageLoader();

        Log.info("Application: everyone plugged, firing Init event");

        injector.getEventBus().fireEvent(AppEvents.Init);
        injector.getEventBus().fireEvent(new NavigationEvent(NavigationHandler.NavigationRequested, new ProjectListState()));
    }

}
