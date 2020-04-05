package kiec.ireneusz.spellsandgloryserver.api;

import io.swagger.annotations.Api;
import kiec.ireneusz.spellsandgloryserver.domain.user.UserFacade;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.HeroApi;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.HeroDTO;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.HeroUpdateApi;
import kiec.ireneusz.spellsandgloryserver.exception.HeroNotFoudException;
import kiec.ireneusz.spellsandgloryserver.exception.ItemNotFoundException;
import kiec.ireneusz.spellsandgloryserver.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/heroes", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Hero")
public class HeroController {

    private final UserFacade userFacade;

    @Autowired
    public HeroController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<HeroDTO>> getAll(){
        return ResponseEntity.ok(userFacade.getHeroes());
    }

    @GetMapping("/getOne/{heroId}")
    public ResponseEntity<HeroDTO> getOne(
            @PathVariable Long heroId
    ) throws HeroNotFoudException {
        return ResponseEntity.ok(userFacade.getHero(heroId));
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<List<HeroDTO>> getByName(
            @PathVariable String name
    ){
        return ResponseEntity.ok(userFacade.getHeroesByName(name));
    }

    @GetMapping("/getByUser/{userId}")
    public ResponseEntity<List<HeroDTO>> getByUser(
            @PathVariable Long userId
    ) throws UserNotFoundException {
        return ResponseEntity.ok(userFacade.getHeroesByUser(userId));
    }

    @PostMapping("/create")
    public ResponseEntity<HeroDTO> create(
            @RequestBody HeroApi api
    ) throws UserNotFoundException, ItemNotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(userFacade.createHero(api));
    }

    @PutMapping("/update/{heroId}")
    public ResponseEntity<HeroDTO> update(
            @PathVariable Long heroId,
            @RequestBody HeroUpdateApi api
    ) throws HeroNotFoudException {
        return ResponseEntity.ok(userFacade.updateHero(heroId, api));
    }

    @DeleteMapping("/delete/{heroId}")
    public ResponseEntity<HeroDTO> delete(
            @PathVariable Long heroId
    ) throws HeroNotFoudException {
        userFacade.deleteHero(heroId);
        return ResponseEntity.noContent().build();
    }

}
