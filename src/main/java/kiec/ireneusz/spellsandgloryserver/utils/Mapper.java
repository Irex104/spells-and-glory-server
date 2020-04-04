package kiec.ireneusz.spellsandgloryserver.utils;

import kiec.ireneusz.spellsandgloryserver.domain.user.dto.EquipmentDTO;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.HeroDTO;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.ItemDTO;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.UserDTO;
import kiec.ireneusz.spellsandgloryserver.domain.user.model.Equipment;
import kiec.ireneusz.spellsandgloryserver.domain.user.model.Hero;
import kiec.ireneusz.spellsandgloryserver.domain.user.model.Item;
import kiec.ireneusz.spellsandgloryserver.domain.user.model.User;

public class Mapper {

    //region USER
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
    //endregion

    //region HERO
        public static HeroDTO toHeroDTOSimple(Hero hero){
            return new HeroDTO().builder()
                    .id(hero.getId())
                    .name(hero.getName())
                    .description(hero.getDescription())
                    .profession(hero.getProfession())
                    .image(hero.getImage())
                    .level(hero.getLevel())
                    .build();
        }
    //endregion

    //region ITEM
    public static ItemDTO toItemDTOSimple(Item item){
        return new ItemDTO().builder()
                .id(item.getId())
                .name(item.getName())
                .image(item.getImage())
                .build();
    }
    //endregion

    //region EQUIPMENT
    public static EquipmentDTO toEquipmentDTOSimple(Equipment equipment){
        return new EquipmentDTO().builder()
                .id(equipment.getId())
                .heroId(equipment.getHero().getId())
                .heroName(equipment.getHero().getName())
                .build();
    }
    //endregion

}