package kiec.ireneusz.spellsandgloryserver.api;

import io.swagger.annotations.Api;
import kiec.ireneusz.spellsandgloryserver.domain.user.UserFacade;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.EquipmentDTO;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.ItemDTO;
import kiec.ireneusz.spellsandgloryserver.exception.EquipmentNotFoundException;
import kiec.ireneusz.spellsandgloryserver.exception.HeroNotFoudException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/equipments", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Equipment")
public class EquipmentController {

    private final UserFacade userFacade;

    @Autowired
    public EquipmentController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<EquipmentDTO>> getAll(){
        return ResponseEntity.ok(userFacade.getEquipments());
    }

    @GetMapping("/getByHero/{heroId}")
    public ResponseEntity<EquipmentDTO> getByHero(
            @PathVariable Long heroId
    ) throws HeroNotFoudException, EquipmentNotFoundException {
        return ResponseEntity.ok(userFacade.getEquipment(heroId));
    }

    @GetMapping("/wearItem/{heroId}/{itemId}")
    public ResponseEntity<ItemDTO> wearItem(
            @PathVariable Long heroId,
            @PathVariable Long itemId
    ){
        return ResponseEntity.ok(userFacade.wearItem(heroId, itemId));
    }

    //TODO WARNING it might be ERROR - Delete returns ResponseEntity
    @DeleteMapping("/takeOfItem/{heroId}/{itemId}")
    public ResponseEntity<ItemDTO> wearItem(
            @PathVariable Long heroId,
            @PathVariable Long itemId
    ){
        return ResponseEntity.ok(userFacade.takeOfItem(heroId, itemId));
    }

}
