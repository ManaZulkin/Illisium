package com.illisium.config.repositories;

import com.illisium.modelsDB.session.OpenRoom;
import com.illisium.modelsDB.session.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpenRoomRepository extends JpaRepository<OpenRoom, Integer> {

    List<OpenRoom> findByCharacterName(String characterName);

    List<OpenRoom> findAllBySession(Session session);
}

