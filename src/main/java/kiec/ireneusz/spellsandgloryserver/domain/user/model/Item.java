package kiec.ireneusz.spellsandgloryserver.domain.user.model;

import kiec.ireneusz.spellsandgloryserver.domain.user.dto.ItemApi;
import kiec.ireneusz.spellsandgloryserver.enums.ItemType;
import kiec.ireneusz.spellsandgloryserver.utils.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "public", name = "items")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Item extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    private String description;
    @Column(name = "item_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ItemType itemType;
    @Column(name = "sale_price", nullable = false)
    private Long salePrice;
    @Column(name = "purchase_price", nullable = false)
    private Long purchasePrice;
    @Column(name = "premium_coins_purchase_price", nullable = false)
    private Long premiumCoinsPurchasePrice;

    @Column(name = "lower_compartment_hit", nullable = false)
    private Long lowerCompartmentHit;
    @Column(name = "upper_compartment_hit", nullable = false)
    private Long upperCompartmentHit;
    @Column(name = "armour_strength", nullable = false)
    private Long armourStrength;
    @Column(name="max_health_points", nullable = false)
    private Long maxHealthPoints;
    @NotNull
    private Long strength;
    @NotNull
    private Long dexterity;
    @NotNull
    private Long intelligence;
    @NotNull
    private Long lucky;

    public Item(ItemApi api) {
        this.name = api.getName();
        this.description = api.getDescription();
        this.itemType = api.getItemType();
        this.salePrice = api.getSalePrice();
        this.purchasePrice = api.getPurchasePrice();
        this.premiumCoinsPurchasePrice = api.getPremiumCoinsPurchasePrice();
        this.lowerCompartmentHit = api.getLowerCompartmentHit();
        this.upperCompartmentHit = api.getUpperCompartmentHit();
        this.armourStrength = api.getArmourStrength();
        this.maxHealthPoints = api.getMaxHealthPoints();
        this.strength = api.getStrength();
        this.dexterity = api.getDexterity();
        this.intelligence = api.getIntelligence();
        this.lucky = api.getLucky();
    }
}
