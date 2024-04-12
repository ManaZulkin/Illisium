package com.illisium.config.sequrity;

import jakarta.servlet.http.HttpSessionBindingListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for getting list of authenticated users
 */

@Component
public class LoggedUser implements HttpSessionBindingListener, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final SessionRegistry sessionRegistry;

    @Autowired
    public LoggedUser( SessionRegistry sessionRegistry) {

        this.sessionRegistry = sessionRegistry;
    }

    public List<String> getAllActiveUsersNames(){
        List<String> activeUsersNames = new ArrayList<>();

        List<Object> allPrincipals = sessionRegistry.getAllPrincipals();

        for (Object principal : allPrincipals) {
            if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
                List<SessionInformation> activeUserSession = sessionRegistry.getAllSessions(principal, false);
                if (!activeUserSession.isEmpty()) {
                    activeUsersNames.add(userDetails.getUsername());
                }
            }
        }


        return activeUsersNames;
    }

}
