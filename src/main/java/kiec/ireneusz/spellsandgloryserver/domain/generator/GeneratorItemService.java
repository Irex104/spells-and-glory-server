package kiec.ireneusz.spellsandgloryserver.domain.generator;

import kiec.ireneusz.spellsandgloryserver.domain.user.dto.ItemApi;
import kiec.ireneusz.spellsandgloryserver.enums.ItemType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeneratorItemService {

    private List<ItemApi> itemApis = new ArrayList<>();

    public List<ItemApi> getItemApis() {
        itemApis.add(new ItemApi(
                "First Sword",
                "The worst sword",
                "first_sword.png",
                ItemType.Sword,
                10L,
                30L,
                1L,
                3L,
                6L,
                0L,
                0L,
                5L,
                0L,
                0L,
                0L
        ));
        itemApis.add(new ItemApi(
                "First Bow",
                "The worst bow",
                "first_bow.png",
                ItemType.Bow,
                10L,
                30L,
                1L,
                3L,
                6L,
                0L,
                0L,
                0L,
                5L,
                0L,
                0L
        ));
        itemApis.add(new ItemApi(
                "First Wand",
                "The worst wand",
                "first_wand.png",
                ItemType.Wand,
                10L,
                30L,
                1L,
                3L,
                6L,
                0L,
                0L,
                0L,
                0L,
                5L,
                0L));
        return itemApis;
    }
}
