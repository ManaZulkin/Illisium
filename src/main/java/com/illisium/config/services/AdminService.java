package com.illisium.config.services;

import com.illisium.config.repositories.*;
import com.illisium.modelsDB.abylities.Magick;
import com.illisium.modelsDB.abylities.Skills;
import com.illisium.modelsDB.creature.Monster;
import com.illisium.modelsDB.equpment.Armor;
import com.illisium.modelsDB.equpment.Item;
import com.illisium.modelsDB.equpment.Weapon;
import com.illisium.modelsDB.session.OpenRoom;
import com.illisium.modelsDB.session.Session;
import com.illisium.resources.utilit.DataUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    private final ItemRepository itemRepository;
    private final ArmorRepository armorRepository;
    private final WeaponRepository weaponRepository;
    private final SkillsRepository skillsRepository;
    private final MagickRepository magickRepository;
    private final SessionRepository sessionRepository;
    private final MonsterRepository monsterRepository;
    private final OpenRoomRepository openRoomRepository;

    @Autowired
    public AdminService(ItemRepository itemRepository, ArmorRepository armorRepository, WeaponRepository weaponRepository, SkillsRepository skillsRepository, MagickRepository magickRepository, SessionRepository sessionRepository, MonsterRepository monsterRepository, OpenRoomRepository openRoomRepository) {
        this.itemRepository = itemRepository;
        this.armorRepository = armorRepository;
        this.weaponRepository = weaponRepository;
        this.skillsRepository = skillsRepository;
        this.magickRepository = magickRepository;
        this.sessionRepository = sessionRepository;
        this.monsterRepository = monsterRepository;
        this.openRoomRepository = openRoomRepository;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public void saveWeapon(Weapon weapon){
        weaponRepository.save(weapon);
        DataUtility.save(weapon);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public void saveArmor(Armor armor){
        armorRepository.save(armor);
        DataUtility.save(armor);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public void saveMagick(Magick magick){
        magickRepository.save(magick);
        DataUtility.save(magick);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public void saveSkill(Skills skills){
        skillsRepository.save(skills);
        DataUtility.save(skills);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
        DataUtility.save(item);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public ArrayList<Session> getAllSessionListForGameMaster(){
        return  sessionRepository.findAllByGameMaster(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public Session getSessionBySessionName(String name){
        return  sessionRepository.findBySessionName(name);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public void saveSession(Session session){
         if (session.getSessionName().isEmpty()){
             throw new RuntimeException("Name can not be empty");
         }else {
             sessionRepository.save(session);
         }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public List<OpenRoom> getOpenRoomSet(Session session){

        return openRoomRepository.findAllBySession(session);
    }

    @Transactional
    public void saveMonster(Monster monster){
        monsterRepository.save(monster);
        DataUtility.save(monster);
    }
}
