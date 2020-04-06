package kiec.ireneusz.spellsandgloryserver.domain.user.model;

import kiec.ireneusz.spellsandgloryserver.enums.ItemType;
import kiec.ireneusz.spellsandgloryserver.utils.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "public", name = "item2equipment")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item2Equipment extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "equipment_id", nullable = false)
    private Long equipmentId;
    @Column(name = "item_id"/*, nullable = false*/)
    private Long itemId;
    @Enumerated(EnumType.STRING)
    @Column(name = "item_type", nullable = false)
    private ItemType itemType;

    public Item2Equipment(@NotNull Long equipmentId, /*@NotNull*/ Long itemId, @NotNull ItemType itemType) {
        this.equipmentId = equipmentId;
        this.itemType = itemType;
        this.itemId = itemId;
    }

    public void wear(Item item) {
        this.itemId = item.getId();
    }
    public void takeOf() {
        this.itemId = null;
    }
}
