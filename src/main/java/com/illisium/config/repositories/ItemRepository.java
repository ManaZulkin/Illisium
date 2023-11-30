package com.illisium.config.repositories;

import com.illisium.models.equpment.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Optional<Item> findByItemNameAndItemType(String itemName, String itemType);
}
