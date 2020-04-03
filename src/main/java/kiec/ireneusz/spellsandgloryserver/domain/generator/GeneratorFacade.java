package kiec.ireneusz.spellsandgloryserver.domain.generator;

import kiec.ireneusz.spellsandgloryserver.domain.user.UserFacade;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.HeroApi;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.HeroDTO;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.UserApi;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.UserDTO;
import kiec.ireneusz.spellsandgloryserver.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeneratorFacade {

    private final UserFacade userFacade;
    private final GeneratorUserService generatorUserService;
    private final GeneratorHeroService generatorHeroService;

    @Autowired
    public GeneratorFacade(UserFacade userFacade, GeneratorUserService generatorUserService, GeneratorHeroService generatorHeroService) {
        this.userFacade = userFacade;
        this.generatorUserService = generatorUserService;
        this.generatorHeroService = generatorHeroService;
    }

    public List<UserDTO> generateUsers(){
        List<UserDTO> userDTOs = new ArrayList<>();
        for(UserApi userApi: generatorUserService.getUserApis())
            userDTOs.add(userFacade.createUser(userApi));
        return userDTOs;
    }

    public List<HeroDTO> generateHeroes() throws UserNotFoundException {
        List<HeroDTO> heroDTOs = new ArrayList<>();
        for(HeroApi heroApi: generatorHeroService.getHeroApis())
            heroDTOs.add(userFacade.createHero(heroApi));
        return heroDTOs;
    }


}
