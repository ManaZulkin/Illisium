package com.illisium.config.services;

import com.illisium.config.repositories.OpenRoomRepository;
import com.illisium.config.repositories.SessionRepository;
import com.illisium.config.util.CreationRepositoryHolder;
import com.illisium.modelsDB.abylities.Magick;
import com.illisium.modelsDB.abylities.Skills;
import com.illisium.modelsDB.creature.Monster;
import com.illisium.modelsDB.equpment.Armor;
import com.illisium.modelsDB.equpment.Item;
import com.illisium.modelsDB.equpment.Weapon;
import com.illisium.modelsDB.others.Quest;
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

@PreAuthorize("hasRole('ROLE_ADMIN')")
@Service
public class AdminService {

    private final CreationRepositoryHolder creationRepositoryHolder;

    private final SessionRepository sessionRepository;

    private final OpenRoomRepository openRoomRepository;

    @Autowired
    public AdminService(CreationRepositoryHolder creationRepositoryHolder, SessionRepository sessionRepository, OpenRoomRepository openRoomRepository) {
        this.creationRepositoryHolder = creationRepositoryHolder;

        this.sessionRepository = sessionRepository;
        this.openRoomRepository = openRoomRepository;
    }

    @Transactional
    public void saveWeapon(Weapon weapon){
        creationRepositoryHolder.getWeaponRepository().save(weapon);
        DataUtility.save(weapon);
    }


    @Transactional
    public void saveArmor(Armor armor){
        creationRepositoryHolder.getArmorRepository().save(armor);
        DataUtility.save(armor);
    }

    @Transactional
    public void saveMagick(Magick magick){
        creationRepositoryHolder.getMagickRepository().save(magick);
        DataUtility.save(magick);
    }

    @Transactional
    public void saveSkill(Skills skills){
        creationRepositoryHolder.getSkillsRepository().save(skills);
        DataUtility.save(skills);
    }

    @Transactional
    public void saveItem(Item item){
        creationRepositoryHolder.getItemRepository().save(item);
        DataUtility.save(item);
    }

    @Transactional
    public ArrayList<Session> getAllSessionListForGameMaster(){
        return  sessionRepository.findAllByGameMaster(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @Transactional
    public Session getSessionBySessionName(String name){
        return  sessionRepository.findBySessionName(name);
    }


    @Transactional
    public void saveSession(Session session){
         if (session.getSessionName().isEmpty()){
             throw new RuntimeException("Name can not be empty");
         }else {
             sessionRepository.save(session);
         }
    }

    @Transactional
    public List<OpenRoom> getOpenRoomSet(Session session){

        return openRoomRepository.findAllBySession(session);
    }


    @Transactional
    public void saveMonster(Monster monster){
        creationRepositoryHolder.getMonsterRepository().save(monster);
        DataUtility.save(monster);
    }

    @Transactional
    public void saveQuest(Quest quest){

        creationRepositoryHolder.getQuestRepository().save(quest);
    }
}
