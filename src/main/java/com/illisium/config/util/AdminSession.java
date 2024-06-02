package com.illisium.config.util;

import com.illisium.modelsDB.session.Battle;
import com.illisium.modelsDB.session.Session;
import org.springframework.stereotype.Component;

@Component
public class AdminSession {
    private Session session;
    private Battle activeBattle;

    public AdminSession(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Battle getActiveBattle() {
        return activeBattle;
    }

    public void setActiveBattle(Battle activeBattle) {
        this.activeBattle = activeBattle;
    }
}
