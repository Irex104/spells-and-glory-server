package kiec.ireneusz.spellsandgloryserver.domain.item.model;

import kiec.ireneusz.spellsandgloryserver.utils.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "public", name = "backpacks")
@Getter
@AllArgsConstructor
public class Backpack extends AbstractModel {

    private List<Item> items;

    public Backpack() {
        this.items = new ArrayList<>();
    }
}
