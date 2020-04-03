package kiec.ireneusz.spellsandgloryserver.api;

import io.swagger.annotations.Api;
import kiec.ireneusz.spellsandgloryserver.domain.user.UserFacade;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.UserApi;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.UserDTO;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.UserUpdateApi;
import kiec.ireneusz.spellsandgloryserver.exception.HeroNotFoudException;
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
        return ResponseEntity.ok(userFacade.getUsers());
    }

    @GetMapping("/getOne/{userId}")
    public ResponseEntity<UserDTO> getOne(
            @PathVariable Long userId
    ) throws UserNotFoundException {
        return ResponseEntity.ok(userFacade.getUser(userId));
    }

    @GetMapping("/getByMail/{mail}")
    public ResponseEntity<List<UserDTO>> getByMail(
            @PathVariable String mail
    ){
        return ResponseEntity.ok(userFacade.getUsersByMail(mail));
    }

    @GetMapping("/getByUsername/{username}")
    public ResponseEntity<List<UserDTO>> getByUsername(
            @PathVariable String username
    ){
        return ResponseEntity.ok(userFacade.getUsersByUsername(username));
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> create(
            @RequestBody UserApi api
    ){
        return ResponseEntity.status(HttpStatus.CREATED).body(userFacade.createUser(api));
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserDTO> update(
            @PathVariable Long userId,
            @RequestBody UserUpdateApi api
    ) throws UserNotFoundException {
        return ResponseEntity.ok(userFacade.updateUser(userId, api));
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<UserDTO> delete(
            @PathVariable Long userId
    ) throws UserNotFoundException, HeroNotFoudException {
        userFacade.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

}
