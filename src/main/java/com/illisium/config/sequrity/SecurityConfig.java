package com.illisium.config.sequrity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public SessionRegistry sessionRegistry(){
        return new SessionRegistry() {
            @Override
            public List<Object> getAllPrincipals() {
                return null;
            }

            @Override
            public List<SessionInformation> getAllSessions(Object principal, boolean includeExpiredSessions) {
                return null;
            }

            @Override
            public SessionInformation getSessionInformation(String sessionId) {
                return null;
            }

            @Override
            public void refreshLastRequest(String sessionId) {

            }

            @Override
            public void registerNewSession(String sessionId, Object principal) {

            }

            @Override
            public void removeSessionInformation(String sessionId) {

            }
        };
    }
}
