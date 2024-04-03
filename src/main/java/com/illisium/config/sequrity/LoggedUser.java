package com.illisium.config.sequrity;

import jakarta.servlet.http.HttpSessionBindingListener;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class LoggedUser implements HttpSessionBindingListener, Serializable {

    private final SessionRegistry sessionRegistry;

    public LoggedUser(SessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }

    public List<String> getAllLoggedInUsers(){
        List<String> loggedInUsers = new ArrayList<>();
        List<Object> principals = sessionRegistry.getAllPrincipals();
        System.out.println(Arrays.toString(principals.toArray()));
        for (Object principal: principals) {
            System.out.println("Get principals....");
            List<SessionInformation> informationList = sessionRegistry.getAllSessions(principal, false);
            for (SessionInformation information: informationList) {
                System.out.println("Get users...");
                loggedInUsers.add(information.getPrincipal().toString());
            }
        }

        return loggedInUsers;
    }

//    @Serial
//    private static final long serialVersionUID = 12332413L;
//
//    @Autowired
//    SessionRegistry sessionRegistry;
//
//    private String username;
//    private ActiveUsersStore activeUsersStore;
//
//    @Autowired
//    public LoggedUser(String username, ActiveUsersStore activeUsersStore) {
//        this.username = username;
//        this.activeUsersStore = activeUsersStore;
//    }
//
//    @Autowired
//
//
//    @Override
//    public void valueBound(HttpSessionBindingEvent event) {
//
//        LoggedUser loggedUser = (LoggedUser) event.getValue();
//        if (!activeUsersStore.getUsers().contains(loggedUser.getUsername())){
//            activeUsersStore.getUsers().add(loggedUser.getUsername());
//        }
//
//    }
//
//    @Override
//    public void valueUnbound(HttpSessionBindingEvent event) {
//        List<String> users = activeUsersStore.getUsers();
//        LoggedUser loggedUser = (LoggedUser) event.getValue();
//        if (users.contains(loggedUser.getUsername())){
//            users.remove(loggedUser.getUsername());
//        }
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public ActiveUsersStore getActiveUsersStore() {
//        return activeUsersStore;
//    }
//
//    public void setActiveUsersStore(ActiveUsersStore activeUsersStore) {
//        this.activeUsersStore = activeUsersStore;
//    }


}
