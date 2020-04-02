package kiec.ireneusz.spellsandgloryserver.domain.character.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import kiec.ireneusz.spellsandgloryserver.enums.Profession;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HeroDTO{

    private Long id;
    private String name;
    private String description;
    private Profession character;
    private String image;

    private Long level;
    private Long currentExperience;
    private Long toNextLevelExperience;

    private Long lowerCompartmentHit;
    private Long upperCompartmentHit;
    private Long hit;
    private Long criticalHit;

    private Long healthPoints;
    private Long strength;
    private Long dexterity;
    private Long intelligence;
    private Long lucky;
    private Long armour;

}
