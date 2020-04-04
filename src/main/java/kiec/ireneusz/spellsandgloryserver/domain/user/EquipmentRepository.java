package kiec.ireneusz.spellsandgloryserver.domain.user;

import kiec.ireneusz.spellsandgloryserver.domain.user.model.Equipment;
import kiec.ireneusz.spellsandgloryserver.domain.user.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    List<Equipment> findAllByDeletedAtIsNull();

    Optional<Equipment> findByHeroAndDeletedAtIsNull(Hero hero);
}
