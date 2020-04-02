package kiec.ireneusz.spellsandgloryserver.domain.item.model;

import kiec.ireneusz.spellsandgloryserver.domain.item.dto.ItemApi;
import kiec.ireneusz.spellsandgloryserver.enums.ItemType;
import kiec.ireneusz.spellsandgloryserver.enums.Profession;
import kiec.ireneusz.spellsandgloryserver.utils.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "helmet_id")
    private Item helmet;
    @ManyToOne
    @JoinColumn(name = "armor_id")
    private Item armor;
    @ManyToOne
    @JoinColumn(name = "gloves_id")
    private Item gloves;
    @ManyToOne
    @JoinColumn(name = "legs_id")
    private Item legs;
    @ManyToOne
    @JoinColumn(name = "shoes_id")
    private Item shoes;

    @ManyToOne
    @JoinColumn(name = "ring_id")
    private Item ring;
    @ManyToOne
    @JoinColumn(name = "necklace_id")
    private Item necklace;

    @ManyToOne
    @JoinColumn(name = "weapon_id")
    private Item weapon;
    @ManyToOne
    @JoinColumn(name = "shield_id")
    private Item shield;

    public Equipment(Profession profession){
        if (profession.name().equals("Warrior")){
            this.weapon = new Item(new ItemApi(
                    "First Sword",
                    "The worst sword",
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
        }else  if (profession.name().equals("Hunter")){
            this.weapon = new Item(new ItemApi(
                    "First Bow",
                    "The worst bow",
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
        }else  if (profession.name().equals("Wizard")){
            this.weapon = new Item(new ItemApi(
                    "First Wand",
                    "The worst wand",
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
                    0L
            ));
        }
    }

}
