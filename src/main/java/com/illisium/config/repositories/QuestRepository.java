package com.illisium.config.repositories;

import com.illisium.modelsDB.others.Quest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestRepository extends JpaRepository<Quest, Long> {
}
