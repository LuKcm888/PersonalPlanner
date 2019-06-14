package com.lukcm888.dataaccess.service;


import com.lukcm888.dataaccess.service.AppSession;

public class SessionHandler {

    private static AppSession appSession = new AppSession();

    public AppSession getAppSession() {
        return appSession;
    }

    public void setAppSession(AppSession appSession) {
        this.appSession = appSession;
    }
}
