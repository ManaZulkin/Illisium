package com.illisium.config.services;

import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GlobalService {


    private SessionRegistry sessionRegistry ;

//    @Autowired
//    public GlobalService(SessionRegistry sessionRegistry) {
//        this.sessionRegistry = sessionRegistry;
//    }

    public List<String> loggedIn(){
        List<String> usersNames = new ArrayList<>();
        List<Object> principals = sessionRegistry.getAllPrincipals();

        for (Object principal:
                principals) {
            if (principal instanceof User){
                usersNames.add(((User)principal).getUsername());
            }
        }
    return usersNames;}
}
