package org.activityinfo.shared.domain;

/**
* @author Alex Bertram (akbertram@gmail.com)
*/
public enum SiteColumn {

    id(0, "site.id"),
    activity_id(1, "activity.id"),
    activity_name(2, "activity.name"),
    database_id(3, "database.id"),
    database_name(4, "database.name"),
    date1(5, "site.date1"),
    date2(6, "site.date2"),
    status(7, "site.status"),
    partner_id(8, "partner.id"),
    partner_name(9, "partner.name"),
    location_name(10, "location.name"),
    location_axe(11, "location.axe"),
    location_type(12, "locationType.name"),
    comments(13, "site.comments"),
    x(14, "location.x"),
    y(15, "location.y");

    private String property;
    private int index;

    SiteColumn(int index, String property) {
        this.index = index;
        this.property = property;
    }

    public int index() {
        return index;
    }

    public String alias() {
        return toString();
    }

    public String property() {
        return property;
    }
}
