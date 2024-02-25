package com.illisium.session;

import com.illisium.config.services.AdminService;
import com.illisium.modelsDB.creature.Character;
import com.illisium.modelsDB.session.Session;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;

public class GameRoom {
    private AdminService adminService;
    private ArrayList<Character> characters;
    private final String GAME_MASTER = SecurityContextHolder.getContext().getAuthentication().getName();
    private Session session;

    public GameRoom(ArrayList<Character> characters, Session session) {
        this.characters = characters;

    }


}
