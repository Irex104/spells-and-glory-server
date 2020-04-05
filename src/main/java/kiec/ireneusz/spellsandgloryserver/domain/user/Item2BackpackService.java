package kiec.ireneusz.spellsandgloryserver.domain.user;

import kiec.ireneusz.spellsandgloryserver.domain.user.model.Backpack;
import kiec.ireneusz.spellsandgloryserver.domain.user.model.Item;
import kiec.ireneusz.spellsandgloryserver.domain.user.model.Item2Backpack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Item2BackpackService {

    private final Item2BackpackRepository repository;

    @Autowired
    public Item2BackpackService(Item2BackpackRepository repository) {
        this.repository = repository;
    }

    void addItemToBackpack(Backpack backpack, Item item) {
        Item2Backpack item2Backpack = new Item2Backpack(backpack.getId(), item.getId());
        System.out.println(item2Backpack);
        repository.save(item2Backpack);
    }
}
