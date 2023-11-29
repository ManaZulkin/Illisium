package com.illisium.config.repositories;

import com.illisium.models.abylities.Magick;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MagickRepository extends JpaRepository<Magick, Integer> {

    Optional<Magick> findBySpellNameAndElementAndLvl(String spellName, String element, int lvl);
}
