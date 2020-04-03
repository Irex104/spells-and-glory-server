package kiec.ireneusz.spellsandgloryserver.domain.user;

import kiec.ireneusz.spellsandgloryserver.domain.user.dto.*;
import kiec.ireneusz.spellsandgloryserver.domain.user.model.User;
import kiec.ireneusz.spellsandgloryserver.exception.HeroNotFoudException;
import kiec.ireneusz.spellsandgloryserver.exception.UserNotFoundException;
import kiec.ireneusz.spellsandgloryserver.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserFacade {

    private final UserService userService;
    private final HeroService heroService;

    @Autowired
    public UserFacade(UserService userService, HeroService heroService) {
        this.userService = userService;
        this.heroService = heroService;
    }

    //region USER
    public List<UserDTO> getUsers() {
        return userService.getAll().stream()
                .map(Mapper::toUserDTOSimple).collect(Collectors.toList());
    }

    public UserDTO getUser(Long userId) throws UserNotFoundException {
        return Mapper.toUserDTO(userService.getOne(userId));
    }

    public List<UserDTO> getUsersByMail(String mail) {
        return userService.getByMail(mail).stream()
                .map(Mapper::toUserDTOSimple).collect(Collectors.toList());
    }

    public List<UserDTO> getUsersByUsername(String username) {
        return userService.getByUsername(username).stream()
                .map(Mapper::toUserDTOSimple).collect(Collectors.toList());
    }

    public UserDTO createUser(UserApi api) {
        return Mapper.toUserDTO(userService.create(api));
    }

    public UserDTO updateUser(Long userId, UserUpdateApi api) throws UserNotFoundException {
        return Mapper.toUserDTO(userService.update(userId, api));
    }

    public void deleteUser(Long userId) throws UserNotFoundException {
        User user = userService.getOne(userId);
        heroService.deleteByUser(user);
        userService.delete(userId);
        //TODO split heroService and CampService, delete both rows for player (heroes, camps)
    }

    //endregion

    //region HERO
    public List<HeroDTO> getHeroes() {
        return heroService.getAll().stream().map(Mapper::toHeroDTOSimple)
                .collect(Collectors.toList());
    }

    public HeroDTO getHero(Long heroId) throws HeroNotFoudException {
        return new HeroDTO(heroService.getOne(heroId));
    }

    public List<HeroDTO> getHeroesByName(String name) {
        return heroService.getByName(name).stream().map(Mapper::toHeroDTOSimple)
                .collect(Collectors.toList());
    }

    public List<HeroDTO> getHeroesByUser(Long userId) throws UserNotFoundException {
        User user = userService.getOne(userId);
        return heroService.getByUser(user).stream().map(Mapper::toHeroDTOSimple)
                .collect(Collectors.toList());
    }

    public HeroDTO createHero(HeroApi api) throws UserNotFoundException {
        User user = userService.getOne(api.getUserId());
        return new HeroDTO(heroService.create(user, api));
    }

    public HeroDTO updateHero(Long heroId, HeroUpdateApi api) throws HeroNotFoudException {
        return new HeroDTO(heroService.update(heroId, api));
    }

    public void deleteHero(Long heroId) throws HeroNotFoudException {
        heroService.delete(heroId);
    }
    //endregion

}
