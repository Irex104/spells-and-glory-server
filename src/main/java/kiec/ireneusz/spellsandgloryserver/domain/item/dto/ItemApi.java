package kiec.ireneusz.spellsandgloryserver.domain.item.dto;

import kiec.ireneusz.spellsandgloryserver.enums.ItemType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemApi {

    private String name;
    private String description;
    private ItemType itemType;
    private Long salePrice;
    private Long purchasePrice;
    private Long premiumCoinsPurchasePrice;

    private Long lowerCompartmentHit;
    private Long upperCompartmentHit;
    private Long armourStrength;
    private Long maxHealthPoints;
    private Long strength;
    private Long dexterity;
    private Long intelligence;
    private Long lucky;

}
