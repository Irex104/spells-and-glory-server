package kiec.ireneusz.spellsandgloryserver.domain.user;

import kiec.ireneusz.spellsandgloryserver.domain.user.model.Item2Equipment;
import kiec.ireneusz.spellsandgloryserver.enums.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Item2EquipmentRepository extends JpaRepository<Item2Equipment, Long> {
//    List<Item2Equipment> findByEquipmentIdAndDeletedAtIsNull(Long equipmentId);

    Optional<Item2Equipment> findByEquipmentIdAndItemTypeAndDeletedAtIsNull(Long id, ItemType itemType);
//    Optional<Item2Equipment> findByEquipmentAndItemTypeInAndDeletedAtIsNull(Equipment equipment, ItemType itemType);
}
