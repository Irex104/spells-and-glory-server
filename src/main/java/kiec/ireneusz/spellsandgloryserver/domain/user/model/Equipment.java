package kiec.ireneusz.spellsandgloryserver.domain.user.model;

import kiec.ireneusz.spellsandgloryserver.enums.ItemType;
import kiec.ireneusz.spellsandgloryserver.utils.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(schema = "public", name = "equipments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Equipment extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "hero_id", nullable = false)
    private Hero hero;

    @ManyToMany
    @JoinTable(
        name="item2equipment",
        joinColumns={@JoinColumn(name="equipment_id", referencedColumnName="id")},
        inverseJoinColumns={@JoinColumn(name="item_id", referencedColumnName="id")})
    @MapKey(name = "id")
    private Map<ItemType, Item> items = new HashMap<>();
//TODO it might be better idea that that shit down

//    @ManyToOne
//    @JoinColumn(name = "helmet_id")
//    private Item helmet;
//    @ManyToOne
//    @JoinColumn(name = "armor_id")
//    private Item armor;
//    @ManyToOne
//    @JoinColumn(name = "gloves_id")
//    private Item gloves;
//    @ManyToOne
//    @JoinColumn(name = "legs_id")
//    private Item legs;
//    @ManyToOne
//    @JoinColumn(name = "shoes_id")
//    private Item shoes;
//
//    @ManyToOne
//    @JoinColumn(name = "ring_id")
//    private Item ring;
//    @ManyToOne
//    @JoinColumn(name = "necklace_id")
//    private Item necklace;
//
//    @ManyToOne
//    @JoinColumn(name = "weapon_id")
//    private Item weapon;
//    @ManyToOne
//    @JoinColumn(name = "shield_id")
//    private Item shield;

    public Equipment(Hero hero){
        this.hero = hero;
    }

}
