package org.activityinfo.client.page.common.filter;

import com.extjs.gxt.ui.client.data.DataProxy;
import com.extjs.gxt.ui.client.data.DataReader;
import com.google.gwt.user.client.rpc.AsyncCallback;
import org.activityinfo.client.command.CommandService;
import org.activityinfo.shared.command.GetSchema;
import org.activityinfo.shared.dto.AdminLevelModel;
import org.activityinfo.shared.dto.Schema;

import java.util.ArrayList;
/*
 * @author Alex Bertram
 */

public class AdminLevelProxy implements DataProxy {

    private final CommandService service;

    public AdminLevelProxy(CommandService service) {
        this.service = service;
    }

    public void load(DataReader dataReader, Object loadConfig, final AsyncCallback callback) {

        service.execute(new GetSchema(), null, new AsyncCallback<Schema>(){
            public void onFailure(Throwable caught) {
                callback.onFailure(caught);
            }

            public void onSuccess(Schema schema) {
                callback.onSuccess(new ArrayList<AdminLevelModel>(schema.getCommonCountry().getAdminLevels()));
            }
        });

    }
}