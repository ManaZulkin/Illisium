package com.illisium.config.repositories;

import com.illisium.modelsDB.session.OpenRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpenRoomRepository extends JpaRepository<OpenRoom, Integer> {

}
