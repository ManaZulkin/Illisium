package com.illisium.config.util;

import com.illisium.modelsDB.creature.Character;
import com.illisium.modelsDB.session.Session;
import org.springframework.stereotype.Component;

@Component
public class CharacterUtil {

    private Session session = new Session();
    private Character character = new Character();



    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
        try{

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
