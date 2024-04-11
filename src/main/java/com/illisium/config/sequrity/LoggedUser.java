package com.illisium.config.sequrity;

import com.illisium.config.sequrity.entety.PersonDetails;
import jakarta.servlet.http.HttpSessionBindingListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Component
public class LoggedUser implements HttpSessionBindingListener, Serializable {

    @Serial
    private static final long serialVersionUID = 12332413L;

    private final SessionRegistry sessionRegistry;


    @Autowired
    public LoggedUser(SessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;

    }


    public List<Object> getAllPrincipals(){
        return sessionRegistry.getAllPrincipals();
    }

    public List<PersonDetails> getAllPersonDetails(){
        List<Object> principals = sessionRegistry.getAllPrincipals();

        return principals.stream()
                .filter(pricipal -> pricipal instanceof  PersonDetails)
                .map(principal -> (PersonDetails)principal)
                .toList();
    }

}
