package kiec.ireneusz.spellsandgloryserver.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByDeletedAtIsNull();

    Optional<User> findByIdAndDeletedAtIsNull(Long userId);

    List<User> findByMailLikeAndDeletedAtIsNull(String s);

    List<User> findByUsernameLikeAndDeletedAtIsNull(String s);
}
