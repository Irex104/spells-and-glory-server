package kiec.ireneusz.spellsandgloryserver.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import kiec.ireneusz.spellsandgloryserver.domain.user.model.Hero;
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
    private Long userId;
    private String userName;
    private String description;
    private Profession profession;
    private String image;

    private Long level;
    private Long currentExperience;
    private Long toNextLevelExperience;

    private Long lowerCompartmentHit;
    private Long upperCompartmentHit;

    private Long maxHealthPoints;
    private Long healthPoints;
    private Long strength;
    private Long dexterity;
    private Long intelligence;
    private Long lucky;
    private Long armourStrength;

    public HeroDTO(Hero hero) {
        this.id = hero.getId();
        this.name = hero.getName();
        this.userId = hero.getUser().getId();
        this.userName = hero.getUser().getUsername();
        this.description = hero.getDescription();
        this.profession = hero.getProfession();
        this.image = hero.getImage();
        this.level = hero.getLevel();
        this.currentExperience = hero.getCurrentExperience();
        this.toNextLevelExperience = hero.getToNextLevelExperience();
        this.lowerCompartmentHit = hero.getLowerCompartmentHit();
        this.upperCompartmentHit = hero.getUpperCompartmentHit();
        this.maxHealthPoints = hero.getMaxHealthPoints();
        this.healthPoints = hero.getHealthPoints();
        this.strength = hero.getStrength();
        this.dexterity = hero.getDexterity();
        this.intelligence = hero.getIntelligence();
        this.lucky = hero.getLucky();
        this.armourStrength = hero.getArmourStrength();
    }
}
