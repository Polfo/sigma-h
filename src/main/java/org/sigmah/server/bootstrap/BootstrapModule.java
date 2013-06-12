/*
 * All Sigmah code is released under the GNU General Public License v3
 * See COPYRIGHT.txt and LICENSE.txt.
 */

package org.sigmah.server.bootstrap;

import org.sigmah.server.endpoint.healthcheck.HealthCheckServlet;

import com.google.inject.servlet.ServletModule;

/**
 * The Bootstrap module is responsible for the minimal static
 * html necessary to login, retrieve lost passwords, etc.
 */
public class BootstrapModule extends ServletModule {

    @Override
    protected void configureServlets() {
    	serve("/healthcheck").with(HealthCheckServlet.class);
        serve("/" + HostController.ENDPOINT).with(HostController.class);
        serve("/" + LoginController.ENDPOINT).with(LoginController.class);
        serve("/" + ConfirmInviteController.ENDPOINT).with(ConfirmInviteController.class);
        serve("/" + LogoutController.ENDPOINT).with(LogoutController.class);
       // serve("/ActivityInfo/ActivityInfo.nocache.js").with(BootstrapScriptServlet.class);
        //serve("/ActivityInfo/html5.manifest").with(BootstrapScriptServlet.class);
       // serve("/ActivityInfo/gears.manifest").with(BootstrapScriptServlet.class);
    }

}
