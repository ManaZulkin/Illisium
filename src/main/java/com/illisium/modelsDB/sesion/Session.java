package com.illisium.modelsDB.sesion;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * This class take information about session
 */

@Entity
@Table(name = "Session")
public class Session {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "session_name")
    private String session_Name;

    @Column(name = "password")
    private String password;

    @Column(name = "game_master")
    private String game_master;

    public Session() {
    }

    public Session(String session_Name, String password, String game_master) {
        this.session_Name = session_Name;
        this.password = password;
        this.game_master = game_master;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", session_Name='" + session_Name + '\'' +
                ", password='" + password + '\'' +
                ", game_master='" + game_master + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(id, session.id) && Objects.equals(session_Name, session.session_Name) && Objects.equals(password, session.password) && Objects.equals(game_master, session.game_master);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, session_Name, password, game_master);
    }

    public String getSession_Name() {
        return session_Name;
    }

    public void setSession_Name(String session_Name) {
        this.session_Name = session_Name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGame_master() {
        return game_master;
    }

    public void setGame_master(String game_master) {
        this.game_master = game_master;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
