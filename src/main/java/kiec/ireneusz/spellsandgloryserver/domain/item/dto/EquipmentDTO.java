package kiec.ireneusz.spellsandgloryserver.domain.item.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import kiec.ireneusz.spellsandgloryserver.domain.item.model.Equipment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EquipmentDTO {

    private Long id;

    private Long helmetId;
    private String helmetName;
    private Long armorId;
    private String armorName;
    private Long glovesId;
    private String glovesName;
    private Long legsId;
    private String legsName;
    private Long shoesId;
    private String shoesName;

    private Long ringId;
    private String ringName;
    private Long necklaceId;
    private String necklaceName;

    private Long weaponId;
    private String weaponName;
    private Long shieldId;
    private String shieldName;

    public EquipmentDTO(Equipment equipment) {
        this.id = equipment.getId();
        this.helmetId = equipment.getHelmet().getId();
        this.helmetName = equipment.getHelmet().getName();
        this.armorId = equipment.getArmor().getId();
        this.armorName = equipment.getArmor().getName();
        this.glovesId = equipment.getGloves().getId();
        this.glovesName = equipment.getGloves().getName();
        this.legsId = equipment.getLegs().getId();
        this.legsName = equipment.getLegs().getName();
        this.shoesId = equipment.getShoes().getId();
        this.shoesName = equipment.getShoes().getName();
        this.ringId = equipment.getRing().getId();
        this.ringName = equipment.getRing().getName();
        this.necklaceId = equipment.getNecklace().getId();
        this.necklaceName = equipment.getNecklace().getName();
        this.weaponId = equipment.getWeapon().getId();
        this.weaponName = equipment.getWeapon().getName();
        this.shieldId = equipment.getShield().getId();
        this.shieldName = equipment.getShield().getName();
    }
}
