package kiec.ireneusz.spellsandgloryserver.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import kiec.ireneusz.spellsandgloryserver.domain.user.model.User;
import kiec.ireneusz.spellsandgloryserver.enums.Gender;
import kiec.ireneusz.spellsandgloryserver.enums.Rang;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Long id;
//    private Role role;
    private Gender gender;
    private String mail;
    private String username;
//    private String password;
    private String description;
    private String image;

    private Long level;
    private Rang rang;
    private Long currentExperience;
    private Long toNextLevelExperience;
    private Long gold;
    private Long premiumCoins;

    public UserDTO(User user) {
        this.id = user.getId();
//        this.role = user.getRole();
        this.gender = user.getGender();
        this.mail = user.getMail();
        this.username = user.getUsername();
//        this.password = user.getPassword();
        this.description = user.getDescription();
        this.image = user.getImage();
        this.level = user.getLevel();
        this.rang = user.getRang();
        this.currentExperience = user.getCurrentExperience();
        this.toNextLevelExperience = user.getToNextLevelExperience();
        this.gold = user.getGold();
        this.premiumCoins = user.getPremiumCoins();
    }
}
