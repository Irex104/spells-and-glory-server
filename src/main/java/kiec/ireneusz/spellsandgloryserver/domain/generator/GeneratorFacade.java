package kiec.ireneusz.spellsandgloryserver.domain.generator;

import kiec.ireneusz.spellsandgloryserver.domain.user.UserFacade;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.*;
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
    private final GeneratorItemService generatorItemService;

    @Autowired
    public GeneratorFacade(UserFacade userFacade,
                           GeneratorUserService generatorUserService,
                           GeneratorHeroService generatorHeroService,
                           GeneratorItemService generatorItemService
    ) {
        this.userFacade = userFacade;
        this.generatorUserService = generatorUserService;
        this.generatorHeroService = generatorHeroService;
        this.generatorItemService = generatorItemService;
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

    public List<ItemDTO> generateItems() {
        List<ItemDTO> itemDTOs = new ArrayList<>();
        for(ItemApi itemApi: generatorItemService.getItemApis())
            itemDTOs.add(userFacade.createItem(itemApi));
        return itemDTOs;
    }

}
