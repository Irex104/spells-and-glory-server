package kiec.ireneusz.spellsandgloryserver.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import kiec.ireneusz.spellsandgloryserver.domain.user.model.Item;
import kiec.ireneusz.spellsandgloryserver.enums.ItemType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemDTO {

    private Long id;
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

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.description = item.getDescription();
        this.itemType = item.getItemType();
        this.salePrice = item.getSalePrice();
        this.purchasePrice = item.getPurchasePrice();
        this.premiumCoinsPurchasePrice = item.getPremiumCoinsPurchasePrice();
        this.lowerCompartmentHit = item.getLowerCompartmentHit();
        this.upperCompartmentHit = item.getUpperCompartmentHit();
        this.armourStrength = item.getArmourStrength();
        this.maxHealthPoints = item.getMaxHealthPoints();
        this.strength = item.getStrength();
        this.dexterity = item.getDexterity();
        this.intelligence = item.getIntelligence();
        this.lucky = item.getLucky();
    }
}
