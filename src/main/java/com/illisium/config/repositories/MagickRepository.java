package com.illisium.config.repositories;

import com.illisium.modelsDB.abylities.Magick;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MagickRepository extends JpaRepository<Magick, Integer> {

    Optional<Magick> findByNameAndElementAndLvl(String spellName, String element, int lvl);
}
