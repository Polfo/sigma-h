/*
 * All Sigmah code is released under the GNU General Public License v3
 * See COPYRIGHT.txt and LICENSE.txt.
 */

package org.sigmah.server.bootstrap;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import freemarker.template.Configuration;
import org.sigmah.server.Cookies;
import org.sigmah.server.bootstrap.exception.NoValidAuthentication;
import org.sigmah.server.bootstrap.model.HostPageModel;
import org.sigmah.server.dao.AuthenticationDAO;
import org.sigmah.server.dao.Transactional;
import org.sigmah.server.domain.Authentication;
import org.sigmah.server.util.logging.LogException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

import static org.sigmah.server.util.StringUtil.isEmpty;

@Singleton
public class HostController extends AbstractController {
    public static final String ENDPOINT = "";

    private final Properties config;

    @Inject
    public HostController(Injector injector, Configuration templateCfg, Properties config) {
        super(injector, templateCfg);
        this.config = config;
    }

    @Override
    @LogException(emailAlert = true)
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if("Sigmah".equals(config.getProperty("default.interface"))) {
            resp.sendRedirect("Sigmah/");
            return;
        }

        if (requestIsFromIE6OnPort80(req)) {
            redirectToPort(req, resp, 8080);
            return;
        }

        try {
            Authentication auth = getAuthentication(req);
            if("true".equals(req.getParameter("redirect"))) {
                Cookies.addAuthCookie(resp, auth, false);
                resp.sendRedirect(HostController.ENDPOINT);
            } else {
                writeView(resp, new HostPageModel(auth, computeAppUrl(req)));
            }
        } catch (NoValidAuthentication noValidAuthentication) {
            resp.sendRedirect(LoginController.ENDPOINT + parseUrlSuffix(req));
        }
    }

    @Transactional
    protected Authentication getAuthentication(HttpServletRequest request) throws NoValidAuthentication {
        String authToken = request.getParameter("auth");
        if(isEmpty(authToken)) {
            authToken = getCookie(request, Cookies.AUTH_TOKEN_COOKIE);
        }
        if (isEmpty(authToken)) {
            throw new NoValidAuthentication();
        }

        AuthenticationDAO authDAO = injector.getInstance(AuthenticationDAO.class);
        Authentication auth = authDAO.findById(authToken);

        if (auth == null) {
            throw new NoValidAuthentication();
        }

        return auth;
    }

    private boolean requestIsFromIE6OnPort80(HttpServletRequest request) {
        return request.getServerPort() == 80 &&
                request.getServerName() != null &&
                request.getServerName().endsWith("activityinfo.org") &&
                !"80".equals(request.getParameter("port")) &&
                request.getHeader("User-Agent") != null &&
                request.getHeader("User-Agent").indexOf("MSIE 6.0") != -1;
    }

    private void redirectToPort(HttpServletRequest request, HttpServletResponse response, int port) throws IOException {
        // there is some sort of enormous problem with IE6 and something
        // to do with the tomcat isapi redirector.
        // When *some* IE6 users access the page through the tomcat redirect,
        // IE6 hangs when images are dynamically added to the page
        // This does not happen when accessed directly through the tomcat server.
        //
        // Until we can figure out what the heck is going on and "fix" the redirector,
        // we are just going to redirect all IE6 users to port 8080


        StringBuilder directUrl = new StringBuilder();
        directUrl.append("http://");
        directUrl.append(request.getServerName()).append(":8080");
        directUrl.append(request.getRequestURI());
        if (request.getQueryString() != null && request.getQueryString().length() != 0) {
            directUrl.append("?").append(request.getQueryString());
        }

        String bookmark = parseUrlSuffix(request);
        if (bookmark != null && bookmark.length() != 0) {
            directUrl.append("#").append(bookmark);
        }

        response.sendRedirect(directUrl.toString());
    }

    /**
     * @return  The url used for the desktop shortcut
     */
    private String computeAppUrl(HttpServletRequest request) {
        StringBuilder url = new StringBuilder();
        url.append("http://");
        url.append(request.getServerName());
        if(request.getServerPort() != 80) {
           url.append(":").append(request.getServerPort());
        }
        url.append(request.getRequestURI());
        return url.toString();
    }
}
