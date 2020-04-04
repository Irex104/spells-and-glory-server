package kiec.ireneusz.spellsandgloryserver.domain.user;

import kiec.ireneusz.spellsandgloryserver.domain.user.dto.ItemApi;
import kiec.ireneusz.spellsandgloryserver.domain.user.model.Hero;
import kiec.ireneusz.spellsandgloryserver.domain.user.model.Item;
import kiec.ireneusz.spellsandgloryserver.enums.ItemType;
import kiec.ireneusz.spellsandgloryserver.exception.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ItemRepository repository;

    @Autowired
    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    List<Item> getAll() {
        return repository.findAllByDeletedAtIsNull().stream()
                .sorted(Comparator.comparing(Item::getName))
                .collect(Collectors.toList());
    }

    Item getOne(Long itemId) throws ItemNotFoundException {
        return repository.findByIdAndDeletedAtIsNull(itemId)
                .orElseThrow(() -> new ItemNotFoundException(itemId));
    }

    //TODO im may be useful in ItemController, think it over
    Item getByName(String name) throws ItemNotFoundException {
        return repository.findByNameAndDeletedAtIsNull(name)
                .orElseThrow(() -> new ItemNotFoundException());
    }

    List<Item> getByType(ItemType itemType) {
        return repository.findByItemTypeLikeAndDeletedAtIsNull(itemType).stream()
                .sorted(Comparator.comparing(Item::getName))
                .collect(Collectors.toList());
    }

    Item create(ItemApi api) {
        Item item = new Item(api);
        return repository.save(item);
    }

    Item update(Long itemId, ItemApi api) throws ItemNotFoundException {
        Item item = this.getOne(itemId);
        item.update(api);
        return repository.save(item);
    }

    void delete(Long itemId) throws ItemNotFoundException {
        Item item = this.getOne(itemId);
        item.delete();
        repository.save(item);
    }

    Item getFirstItem(Hero hero) throws ItemNotFoundException {
        Item firstItem;
        if (hero.getProfession().name().equals("Warrior")){
            firstItem = getByName("First Sword");
        }else  if (hero.getProfession().name().equals("Hunter")){
            firstItem = getByName("First Bow");
        }else  /*if (hero.getProfession().name().equals("Wizard"))*/{
            firstItem = getByName("First Wand");
        }
        return firstItem;
    }
}
