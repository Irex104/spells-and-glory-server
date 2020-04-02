package kiec.ireneusz.spellsandgloryserver.domain.user;

import kiec.ireneusz.spellsandgloryserver.domain.user.dto.UserApi;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.UserDTO;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.UserUpdateApi;
import kiec.ireneusz.spellsandgloryserver.exception.UserNotFoundException;
import kiec.ireneusz.spellsandgloryserver.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserFacade {

    private final UserService userService;

    @Autowired
    public UserFacade(UserService userService) {
        this.userService = userService;
    }

    //region USER
    public List<UserDTO> getAll() {
        return userService.getAll().stream()
                .map(Mapper::toUserDTOSimple).collect(Collectors.toList());
    }

    public UserDTO getOne(Long userId) throws UserNotFoundException {
        return Mapper.toUserDTO(userService.getOne(userId));
    }

    public List<UserDTO> getByMail(String mail) {
        return userService.getByMail(mail).stream()
                .map(Mapper::toUserDTOSimple).collect(Collectors.toList());
    }

    public List<UserDTO> getByUsername(String username) {
        return userService.getByMail(username).stream()
                .map(Mapper::toUserDTOSimple).collect(Collectors.toList());
    }

    public UserDTO create(UserApi api) {
        return Mapper.toUserDTO(userService.create(api));
    }

    public UserDTO update(Long userId, UserUpdateApi api) throws UserNotFoundException {
        return Mapper.toUserDTO(userService.update(userId, api));
    }

    public void delete(Long userId) throws UserNotFoundException {
        userService.delete(userId);
        //TODO split heroService and CampService, delete both rows for player (heroes, camps)
    }
    //endregion
}
