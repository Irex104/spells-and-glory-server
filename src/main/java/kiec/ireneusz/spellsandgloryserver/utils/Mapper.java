package kiec.ireneusz.spellsandgloryserver.utils;

import kiec.ireneusz.spellsandgloryserver.domain.user.User;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.UserDTO;

public class Mapper {

    public static UserDTO toUserDTO(User user/*, List<HeroDTO> heroDTOs, List<CampDTO> campDTOs*/){
        return new UserDTO().builder()
                .id(user.getId())
//                .role(user.getRole())
                .gender(user.getGender())
                .mail(user.getMail())
                .username(user.getUsername())
                .description(user.getDescription())
                .image(user.getImage())
                .level(user.getLevel())
                .rang(user.getRang())
                .currentExperience(user.getCurrentExperience())
                .toNextLevelExperience(user.getToNextLevelExperience())
                .gold(user.getGold())
                .premiumCoins(user.getPremiumCoins())
//                .heroes(heroDTOs)
//                .camps(campDTOs)
                .build();
    }

    public static UserDTO toUserDTOSimple(User user){
        return new UserDTO().builder()
                .id(user.getId())
                .gender(user.getGender())
                .mail(user.getMail())
                .username(user.getUsername())
                .image(user.getImage())
                .level(user.getLevel())
                .build();
    }

}
