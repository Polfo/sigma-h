/*
 * All Sigmah code is released under the GNU General Public License v3 See COPYRIGHT.txt and LICENSE.txt.
 */

package org.sigmah.client.page.config;

import org.sigmah.client.event.NavigationEvent.NavigationError;
import org.sigmah.client.page.NavigationCallback;
import org.sigmah.client.page.Page;
import org.sigmah.client.page.PageId;
import org.sigmah.client.page.PageState;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

public class AccountEditor implements Page {

    public static final PageId Account = new PageId("account");

    @ImplementedBy(AccountPanel.class)
    public interface View {

    }

    private final View view;

    @Inject
    public AccountEditor(View view) {
        this.view = view;
    }

    @Override
    public PageId getPageId() {
        return Account;
    }

    @Override
    public Object getWidget() {
        return view;
    }

    @Override
    public void requestToNavigateAway(PageState place, final NavigationCallback callback) {
        callback.onDecided(NavigationError.NONE);
    }

    @Override
    public String beforeWindowCloses() {
        return null;
    }

    public void shutdown() {

    }

    public boolean navigate(PageState place) {
        return false;
    }
}
