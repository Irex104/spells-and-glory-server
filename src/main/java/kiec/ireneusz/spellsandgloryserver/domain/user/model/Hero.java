package kiec.ireneusz.spellsandgloryserver.domain.user.model;

import kiec.ireneusz.spellsandgloryserver.domain.user.dto.HeroApi;
import kiec.ireneusz.spellsandgloryserver.domain.user.dto.HeroUpdateApi;
import kiec.ireneusz.spellsandgloryserver.enums.Profession;
import kiec.ireneusz.spellsandgloryserver.utils.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Random;

@Entity
@Table(schema = "public", name = "heroes")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Hero extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @NotNull
    private String name;
    private String description;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Profession profession;
    @NotNull
    private String image;

    @NotNull
    private Long level;
    @Column(name = "current_experience",nullable = false)
    private Long currentExperience;
    @Column(name = "to_next_level_experience",nullable = false)
    private Long toNextLevelExperience;

    @Column(name = "lower_compartment_hit", nullable = false)
    private Long lowerCompartmentHit;
    @Column(name = "upper_compartment_hit", nullable = false)
    private Long upperCompartmentHit;

    @Column(name="max_health_points", nullable = false)
    private Long maxHealthPoints;
    @Column(name="health_points", nullable = false)
    private Long healthPoints;
    @NotNull
    private Long strength;
    @NotNull
    private Long dexterity;
    @NotNull
    private Long intelligence;
    @NotNull
    private Long lucky;
    @Column(name = "armour_strength", nullable = false)
    private Long armourStrength;


    //TODO refactor backpack and equipment to JoinColumn because of machine hash code in database, reset DB and delete all rows
    private Equipment equipment;
    private Backpack backpack;
    //TODO think about another attributes

    public Hero(User user, HeroApi api){
        this.user = user;
        this.name = api.getName();
        this.description = api.getDescription();
        this.profession = api.getProfession();
        this.image = api.getImage();

        this.level = 1L;
        this.currentExperience = 0L;
        this.toNextLevelExperience = 1000L;
        this.lowerCompartmentHit = 3L;
        this.upperCompartmentHit = 6L;
        this.maxHealthPoints = 50L;
        this.healthPoints = 50L;
        if (api.getProfession().name().equals("Warrior")){
            this.strength = 50L;
            this.dexterity = 25L;
            this.intelligence = 25L;
        }else  if (api.getProfession().name().equals("Hunter")){
            this.strength = 25L;
            this.dexterity = 50L;
            this.intelligence = 25L;
        }else  if (api.getProfession().name().equals("Wizard")){
            this.strength = 25L;
            this.dexterity = 25L;
            this.intelligence = 50L;
        }
        this.lucky = 25L;
        this.armourStrength = 0L;
        this.equipment = new Equipment(api.getProfession());
        this.backpack = new Backpack();
    }

    public Long attack(){
        Long hit = (long)(Math.random() * (this.upperCompartmentHit - this.lowerCompartmentHit) + this.lowerCompartmentHit);
        if(new Random().nextInt((int) (100 - this.lucky + 1)) < this.lucky){
            return hit*2;
        }else{
            return hit;
        }
    }

    protected void defend(Long opponentHitStrength){
        Long block = (long)(Math.random() * this.armourStrength);
        if(new Random().nextInt((int) (100 - this.lucky + 1)) < this.lucky){
            if (opponentHitStrength>block*2)
                this.healthPoints -= opponentHitStrength - block*2;
        }else{
            if (opponentHitStrength>block)
                this.healthPoints -= opponentHitStrength - block;
        }
    }


    public void update(HeroUpdateApi api) {
        this.name = api.getName();
        this.description = api.getDescription();
        this.image = api.getImage();
    }
}
