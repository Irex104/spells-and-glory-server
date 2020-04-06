package kiec.ireneusz.spellsandgloryserver.domain.user;

import kiec.ireneusz.spellsandgloryserver.domain.user.model.Equipment;
import kiec.ireneusz.spellsandgloryserver.domain.user.model.Item;
import kiec.ireneusz.spellsandgloryserver.domain.user.model.Item2Equipment;
import kiec.ireneusz.spellsandgloryserver.enums.ItemType;
import kiec.ireneusz.spellsandgloryserver.exception.Item2EquipmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Item2EquipmentService {

    private final Item2EquipmentRepository repository;

    @Autowired
    public Item2EquipmentService(Item2EquipmentRepository repository) {
        this.repository = repository;
    }

    Item2Equipment getOne(Long equipmentId, ItemType itemType) throws Item2EquipmentNotFoundException {
//        Item2Equipment i2eList = repository.findByEquipmentIdAndItemTypeInAndDeletedAtIsNull(equipment.getId(), itemType);
//        Item2Equipment item2Equipment = (Item2Equipment) i2eList.stream().filter(e -> e.equals(itemType));
        return repository.findByEquipmentIdAndItemTypeAndDeletedAtIsNull(equipmentId, itemType)
                .orElseThrow(() -> new Item2EquipmentNotFoundException(equipmentId,itemType.name()));
    }

    List<Item2Equipment> createItemsSlots(Equipment equipment){
        List<Item2Equipment> items = new ArrayList<>();
        items.add(new Item2Equipment(equipment.getId(), null, ItemType.Helmet));
        items.add(new Item2Equipment(equipment.getId(),null, ItemType.Armor));
        items.add(new Item2Equipment(equipment.getId(),null, ItemType.Legs));
        items.add(new Item2Equipment(equipment.getId(),null, ItemType.Gloves));
        items.add(new Item2Equipment(equipment.getId(),null, ItemType.Shoes));
        items.add(new Item2Equipment(equipment.getId(),null, ItemType.Ring));
        items.add(new Item2Equipment(equipment.getId(),null, ItemType.Necklace));
        items.add(new Item2Equipment(equipment.getId(),null, ItemType.Shield));
        items.add(new Item2Equipment(equipment.getId(),null, ItemType.WEAPON));
        return repository.saveAll(items);
    }

    Long wearItem(Equipment equipment, Item item) throws Item2EquipmentNotFoundException {
        ItemType slotItemType;
        if(item.getItemType().equals(ItemType.Sword)
            ||item.getItemType().equals(ItemType.Bow)
            ||item.getItemType().equals(ItemType.Wand))
            slotItemType = ItemType.WEAPON;
        else
            slotItemType = item.getItemType();
        Item2Equipment i2e = this.getOne(equipment.getId(), slotItemType);
        Long oldItemId = i2e.getItemId();
        i2e.wear(item);
        repository.save(i2e);
        return oldItemId;
    }

    Item takeOfItem(Equipment equipment, Item item) throws Item2EquipmentNotFoundException {
        ItemType slotItemType;
        if(item.getItemType().equals(ItemType.Sword)
                ||item.getItemType().equals(ItemType.Bow)
                ||item.getItemType().equals(ItemType.Wand))
            slotItemType = ItemType.WEAPON;
        else
            slotItemType = item.getItemType();
        Item2Equipment i2e = this.getOne(equipment.getId(), slotItemType);
        i2e.takeOf();
        repository.save(i2e);
        return item;
    }
}
