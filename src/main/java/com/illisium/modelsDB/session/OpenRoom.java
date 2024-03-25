package com.illisium.modelsDB.session;

import jakarta.persistence.*;

@Entity
@Table(name = "OpenRoom")
public class OpenRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;

    @Column(name = "character_name")
    private String characterName;

    public OpenRoom() {
    }

    public OpenRoom( String characterName) {
        this.characterName = characterName;
    }

    public OpenRoom(Session session, String characterName) {
        this.session = session;
        this.characterName = characterName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    @Override
    public String toString() {
        return "OpenRoom{" +
                "id=" + id +
                ", session=" + session +
                ", characterName='" + characterName + '\'' +
                '}';
    }
}
