package api.database.account.util;

import api.database.account.models.User;
import org.springframework.context.ApplicationEvent;
public class OnCreateUserEvent extends ApplicationEvent {
    private User user;
    private String appUrl;

    public OnCreateUserEvent(String appUrl, User user) {
        super(user);

        this.appUrl = appUrl;
        this.user = user;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
