package kiec.ireneusz.spellsandgloryserver.domain.user;

import kiec.ireneusz.spellsandgloryserver.domain.user.model.Item;
import kiec.ireneusz.spellsandgloryserver.enums.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByDeletedAtIsNull();

    Optional<Item> findByIdAndDeletedAtIsNull(Long itemId);

    List<Item> findByItemTypeLikeAndDeletedAtIsNull(ItemType itemType);

    Optional<Item> findByNameAndDeletedAtIsNull(String name);
}
