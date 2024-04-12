package com.illisium.config.sequrity.myImplemantation;

import com.illisium.config.repositories.SessionRepository;
import com.illisium.modelsDB.session.Session;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

@Component
public class MyLogOutHendler implements LogoutHandler {

    private final SessionRepository sessionRepository;

    public MyLogOutHendler( SessionRepository sessionRepository) {

        this.sessionRepository = sessionRepository;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        Session session =
        sessionRepository.findByGameMasterAndActiveSession(
                SecurityContextHolder.getContext().getAuthentication().getName(), true);
        session.setActiveSession(false);
        sessionRepository.save(session);
    }
}
