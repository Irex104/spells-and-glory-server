package kiec.ireneusz.spellsandgloryserver.domain.user.model;

import kiec.ireneusz.spellsandgloryserver.utils.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "item2backpack")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Item2Backpack extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "backpack_id", nullable = false)
    private Long backpackId;
    @Column(name = "item_id", nullable = false)
    private Long itemId;

    public Item2Backpack(@NotNull Long backpackId,@NotNull Long itemId) {
        this.backpackId = backpackId;
        this.itemId = itemId;
    }
}
