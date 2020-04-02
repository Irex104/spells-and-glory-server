package kiec.ireneusz.spellsandgloryserver.api;

import io.swagger.annotations.Api;
import kiec.ireneusz.spellsandgloryserver.domain.user.UserFacade;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.UserApi;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.UserDTO;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.UserUpdateApi;
import kiec.ireneusz.spellsandgloryserver.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "User")
public class UserController {

    private final UserFacade userFacade;

    @Autowired
    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> getAll(){
        return ResponseEntity.ok(userFacade.getAll());
    }

    @GetMapping("/getOne/{userId}")
    public ResponseEntity<UserDTO> getOne(
            @PathVariable Long userId
    ) throws UserNotFoundException {
        return ResponseEntity.ok(userFacade.getOne(userId));
    }

    @GetMapping("/getByMail/{mail}")
    public ResponseEntity<List<UserDTO>> getByMail(
            @PathVariable String mail
    ){
        return ResponseEntity.ok(userFacade.getByMail(mail));
    }

    @GetMapping("/getByUsername/{username}")
    public ResponseEntity<List<UserDTO>> getByUsername(
            @PathVariable String username
    ){
        return ResponseEntity.ok(userFacade.getByUsername(username));
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> create(
            @RequestBody UserApi api
    ){
        return ResponseEntity.status(HttpStatus.CREATED).body(userFacade.create(api));
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserDTO> create(
            @PathVariable Long userId,
            @RequestBody UserUpdateApi api
    ) throws UserNotFoundException {
        return ResponseEntity.ok(userFacade.update(userId, api));
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<UserDTO> create(
            @PathVariable Long userId
    ) throws UserNotFoundException {
        userFacade.delete(userId);
        return ResponseEntity.noContent().build();
    }

}
