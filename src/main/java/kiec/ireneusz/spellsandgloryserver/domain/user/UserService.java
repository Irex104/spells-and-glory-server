package kiec.ireneusz.spellsandgloryserver.domain.user;

import kiec.ireneusz.spellsandgloryserver.domain.user.dto.UserApi;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.UserUpdateApi;
import kiec.ireneusz.spellsandgloryserver.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    List<User> getAll() {
        return repository.findAllByDeletedAtIsNull();
    }


    User getOne(Long userId) throws UserNotFoundException {
        return repository.findByIdAndDeletedAtIsNull(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    List<User> getByMail(String mail) {
        return repository.findByMailLikeAndDeletedAtIsNull("%"+mail+"%");
    }

    List<User> getByUsername(String username) {
        return repository.findByUsernameLikeAndDeletedAtIsNull("%"+username+"%");
    }

    User create(UserApi api) {
        User user = new User(api);
        return repository.save(user);
    }

    User update(Long userId, UserUpdateApi api) throws UserNotFoundException {
        User user = this.getOne(userId);
        user.update(api);
        return repository.save(user);
    }

    void delete(Long userId) throws UserNotFoundException {
        User user = this.getOne(userId);
        user.delete();
        repository.save(user);
    }
}
