package kiec.ireneusz.spellsandgloryserver.domain.user;

import kiec.ireneusz.spellsandgloryserver.domain.user.model.Backpack;
import kiec.ireneusz.spellsandgloryserver.domain.user.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BackpackRepository extends JpaRepository<Backpack, Long> {
    Optional<Backpack> findByHeroAndDeletedAtIsNull(Hero hero);
}
