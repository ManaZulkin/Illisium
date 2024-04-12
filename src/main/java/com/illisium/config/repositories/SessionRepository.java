package com.illisium.config.repositories;

import com.illisium.modelsDB.session.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {

    ArrayList<Session> findAllByGameMaster(String gameMaster);

    Session findBySessionName(String sessionName);

    List<Session> findAllByActiveSessionIsTrue();

    Session findByGameMasterAndActiveSession(String gameMaster, boolean activeSession);
}
