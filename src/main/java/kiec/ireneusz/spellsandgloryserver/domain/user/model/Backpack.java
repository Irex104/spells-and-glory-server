package kiec.ireneusz.spellsandgloryserver.domain.user.model;

import kiec.ireneusz.spellsandgloryserver.utils.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(schema = "public", name = "backpacks")
@Getter
@AllArgsConstructor
@ToString
public class Backpack extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            schema = "public", name = "item2backpack",
            joinColumns = @JoinColumn(name = "backpack_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items;

    @OneToOne
    @JoinColumn(name = "hero_id", nullable = false)
    private Hero hero;

    public Backpack(Hero hero) {
        this.hero = hero;
    }

    public void addTo(Item item){
        this.items.add(item);
    }

    public Item removeFrom(Item item){
        this.items.remove(item);
        return item;
    }

    public void sortItems(){
        this.items = this.items.stream().sorted(Comparator.comparing(Item::getItemType))
                .collect(Collectors.toList());
    }
}

