package kiec.ireneusz.spellsandgloryserver.api;

import io.swagger.annotations.Api;
import kiec.ireneusz.spellsandgloryserver.domain.generator.GeneratorFacade;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.HeroDTO;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.ItemDTO;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.UserDTO;
import kiec.ireneusz.spellsandgloryserver.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/generators", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Generator")
public class GeneratorController {

    public final GeneratorFacade generatorFacade;

    @Autowired
    public GeneratorController(GeneratorFacade generatorFacade) {
        this.generatorFacade = generatorFacade;
    }

    @GetMapping("/generateUsers")
    public ResponseEntity<List<UserDTO>> generateUsers(){
        return ResponseEntity.status(HttpStatus.CREATED).body(generatorFacade.generateUsers());
    }

    @GetMapping("/generateHeroes")
    public ResponseEntity<List<HeroDTO>> generateHeroes() throws UserNotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(generatorFacade.generateHeroes());
    }

    @GetMapping("/generateItems")
    public ResponseEntity<List<ItemDTO>> generateItems() {
        return ResponseEntity.status(HttpStatus.CREATED).body(generatorFacade.generateItems());
    }

}
