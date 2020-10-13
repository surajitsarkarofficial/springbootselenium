package com.springbootselenium.springbootseleniumproject.core.Scope;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

import java.util.Objects;

public class BrowserScope extends SimpleThreadScope {
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {

        //we are getting the webDriver object
        Object o = super.get(name, objectFactory);

        //we are fetching the session id of the webdriver
        SessionId sessionId = ((RemoteWebDriver) o).getSessionId();

        //If webdriver is closed, sessionID will be null
        if(Objects.isNull(sessionId))
        {
            //If the session id is null, remove the webdriver instance
            super.remove(name);

            //create a new webDriver instance
            o =super.get(name,objectFactory);
        }
        //return the object
        return o;
    }

    //we override this method to remove the warning message it throws,
    // so we simple remove the super call form the method.
    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        //super.registerDestructionCallback(name, callback);
    }
}
