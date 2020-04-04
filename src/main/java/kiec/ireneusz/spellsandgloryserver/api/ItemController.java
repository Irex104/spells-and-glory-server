package kiec.ireneusz.spellsandgloryserver.api;

import io.swagger.annotations.Api;
import kiec.ireneusz.spellsandgloryserver.domain.user.UserFacade;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.ItemApi;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.ItemDTO;
import kiec.ireneusz.spellsandgloryserver.enums.ItemType;
import kiec.ireneusz.spellsandgloryserver.exception.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Item")
public class ItemController {

    private final UserFacade userFacade;

    @Autowired
    public ItemController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ItemDTO>> getAll(){
        return ResponseEntity.ok(userFacade.getItems());
    }

    @GetMapping("/getOne/{itemId}")
    public ResponseEntity<ItemDTO> getOne(
            @PathVariable Long itemId
    ) throws ItemNotFoundException {
        return ResponseEntity.ok(userFacade.getItem(itemId));
    }

    @PostMapping("/getByType")
    public ResponseEntity<List<ItemDTO>> getByType(
            @RequestBody ItemType itemType
    ){
        return ResponseEntity.ok(userFacade.getItemsByType(itemType));
    }

//    @GetMapping("/getByPrice/{lowestPrice}/{highestPrice}")
//    public ResponseEntity<List<ItemDTO>> getByPrice(
//            @PathVariable Long lowestPrice,
//            @PathVariable Long highestPrice
//    ){
//        return ResponseEntity.ok(userFacade.getItemsByPrice(lowestPrice, highestPrice));
//    }
//TODO only in shop

    @PostMapping("/create")
    public ResponseEntity<ItemDTO> create(
            @RequestBody ItemApi api
    ){
        return ResponseEntity.status(HttpStatus.CREATED).body(userFacade.createItem(api));
    }

    @PutMapping("/update/{itemId}")
    public ResponseEntity<ItemDTO> update(
            @PathVariable Long itemId,
            @RequestBody ItemApi api
    ) throws ItemNotFoundException {
        return ResponseEntity.ok(userFacade.updateItem(itemId, api));
    }

    @DeleteMapping("/delete/{itemId}")
    public ResponseEntity<Void> getByPrice(
            @PathVariable Long itemId
    ) throws ItemNotFoundException {
        userFacade.deleteItem(itemId);
        return ResponseEntity.noContent().build();
    }

}
