package kiec.ireneusz.spellsandgloryserver.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import kiec.ireneusz.spellsandgloryserver.domain.user.model.Equipment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EquipmentDTO {

    private Long id;

    private Long heroId;
    private String heroName;

    private /*Map<ItemType, Item>*/List<ItemDTO> itemDTOs;

    public EquipmentDTO(Equipment equipment,  /*Map<ItemType, Item>*/List<ItemDTO> itemDTOs) {
        this.id = equipment.getId();
        this.heroId = equipment.getHero().getId();
        this.heroName = equipment.getHero().getName();
        this.itemDTOs = itemDTOs;
    }
}
