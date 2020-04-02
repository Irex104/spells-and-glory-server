package kiec.ireneusz.spellsandgloryserver.domain.user.dto;

import kiec.ireneusz.spellsandgloryserver.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserApi {

//    private Role role;
    private Gender gender;
    private String mail;
    private String username;
//    private String password;
    private String description;
    private String image;

}
