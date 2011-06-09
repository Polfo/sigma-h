/*
 * All Sigmah code is released under the GNU General Public License v3
 * See COPYRIGHT.txt and LICENSE.txt.
 */

package org.sigmah.client;

import com.extjs.gxt.ui.client.event.EventType;

public class AppEvents {

    public static final EventType Init = new EventBus.NamedEventType("Init");

    public static final EventType SchemaChanged = new EventBus.NamedEventType("SchemaChanged");
    public static final EventType Authenticated = new EventBus.NamedEventType("Authenticated");
    public static final EventType Deauthenticated = new EventBus.NamedEventType("Deauthenticated");
    public static final EventType ConnectionStatusChange = new EventBus.NamedEventType("ConnectionStatusChange");

    public static final EventType Bookmark = new EventBus.NamedEventType("Bookmark");

    public static final EventType LogoutRequested = new EventBus.NamedEventType("LogoutRequeseted");

    public static final EventType Drilldown = new EventBus.NamedEventType("Drilldown");
    public static final EventType GoOffline = new EventBus.NamedEventType("GoOffline");

    public static EventType ShowOfflineStatus = new EventBus.NamedEventType("ShowOfflineStatus");
    public static EventType DisableOfflineMode = new EventBus.NamedEventType("DisableOfflineMode");
}
