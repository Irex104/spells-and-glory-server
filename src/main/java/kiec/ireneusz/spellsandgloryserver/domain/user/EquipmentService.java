package kiec.ireneusz.spellsandgloryserver.domain.user;

import kiec.ireneusz.spellsandgloryserver.domain.user.model.Equipment;
import kiec.ireneusz.spellsandgloryserver.domain.user.model.Hero;
import kiec.ireneusz.spellsandgloryserver.domain.user.model.Item;
import kiec.ireneusz.spellsandgloryserver.enums.ItemType;
import kiec.ireneusz.spellsandgloryserver.exception.EquipmentNotFoundException;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    private final EquipmentRepository repository;

    @Autowired
    public EquipmentService(EquipmentRepository repository) {
        this.repository = repository;
    }

    List<Equipment> getAll() {
        return repository.findAllByDeletedAtIsNull();
    }

    Equipment create(Hero hero) {
        Equipment equipment = new Equipment(hero);
        return repository.save(equipment);
    }

    Equipment getByHero(Hero hero) throws EquipmentNotFoundException {
        return repository.findByHeroAndDeletedAtIsNull(hero)
                .orElseThrow(() -> new EquipmentNotFoundException());
    }

    Equipment wearItem(Hero hero, Item item) throws EquipmentNotFoundException {
        Equipment equipment = this.getByHero(hero);
        ItemType itemType = this.typeEquipmentItem(item);
//        if(equipment.items.get(itemTypem).equals(NULL)) //TODO do hashmap, replace items under itemType, return old item if exist ald put it to backpack
//            equipment.items.replace(itemType, item)
        repository.save(equipment);
    }

    private ItemType typeEquipmentItem(Item item) {
        if (item.getItemType().equals(ItemType.Helmet))
//            equipment.setHelmet(item);
            return ItemType.Helmet;
        if (item.getItemType().equals(ItemType.Armor))
//            equipment.setArmor(item);
            return ItemType.Armor;
        if (item.getItemType().equals(ItemType.Legs))
//            equipment.setLegs(item);
            return ItemType.Legs;
        if (item.getItemType().equals(ItemType.Gloves))
//            equipment.setGloves(item);
            return ItemType.Gloves;
        if (item.getItemType().equals(ItemType.Shoes))
//            equipment.setShoes(item);
            return ItemType.Shoes;
        if (item.getItemType().equals(ItemType.Shield))
//            equipment.setWeapon(item);
            return ItemType.Shield;
        if (item.getItemType().equals(ItemType.Ring))
//            equipment.setRing(item);
            return ItemType.Ring;
        if (item.getItemType().equals(ItemType.Necklace))
//            equipment.setNecklace(item);
            return ItemType.Necklace;
        else
            return ItemType.WEAPON;     //TODO here I can protect against giving the wrong item by profession of hero
    }
}
