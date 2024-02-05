package com.illisium.config.repositories;

import com.illisium.modelsDB.sesion.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {

    ArrayList<Session> findAllByGameMaster(String gameMaster);
}
