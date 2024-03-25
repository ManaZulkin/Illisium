package com.illisium.modelsDB.session;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * This class take information about session
 */

@Entity
@Table(name = "Session")
@Component
public class Session {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "session_Name")
    private String sessionName;

    @Column(name = "password")
    private String password;

    @Column(name = "game_Master")
    private String gameMaster;

    private boolean activeSession = false;

    @OneToMany(mappedBy = "session")
    private List<OpenRoom> openRoom;

    public Session(String sessionName, String password, String gameMaster, List<OpenRoom> openRoom) {
        this.sessionName = sessionName;
        this.password = password;
        this.gameMaster = gameMaster;
        this.openRoom = openRoom;
    }

    public Session() {

    }

    @Override
    public String toString() {
        return "newSession{" +
                "id=" + id +
                ", session_Name='" + sessionName + '\'' +
                ", password='" + password + '\'' +
                ", game_master='" + gameMaster + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(id, session.id) && Objects.equals(sessionName, session.sessionName) && Objects.equals(password, session.password) && Objects.equals(gameMaster, session.gameMaster);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sessionName, password, gameMaster);
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String session_Name) {
        this.sessionName = session_Name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGameMaster() {
        return gameMaster;
    }

    public void setGameMaster(String game_master) {
        this.gameMaster = game_master;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public boolean isActiveSession() {
        return activeSession;
    }

    public void setActiveSession(boolean activeSession) {
        this.activeSession = activeSession;
    }

    public List<OpenRoom> getOpenRoom() {
        return openRoom;
    }

    public void setOpenRoom(List<OpenRoom> openRoom) {
        this.openRoom = openRoom;
    }
}
