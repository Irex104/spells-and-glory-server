package kiec.ireneusz.spellsandgloryserver.domain.user;

import kiec.ireneusz.spellsandgloryserver.domain.user.model.Hero;
import kiec.ireneusz.spellsandgloryserver.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {
    List<Hero> findAllByDeletedAtIsNull();

    Optional<Hero> findByIdAndDeletedAtIsNull(Long heroId);

    List<Hero> findByNameLikeAndDeletedAtIsNull(String name);

    List<Hero> findByUserAndDeletedAtIsNull(User user);
}
