package kiec.ireneusz.spellsandgloryserver.domain.character.model;

import kiec.ireneusz.spellsandgloryserver.enums.Profession;
import kiec.ireneusz.spellsandgloryserver.utils.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "public", name = "monsters")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Monster extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    private String description;
    @NotNull
    private Profession character;
    @NotNull
    private String image;

//    @NotNull
//    private Long level;
//    @Column(name = "current_experience",nullable = false)
//    private Long currentExperience;
//    @Column(name = "to_next_level_experience",nullable = false)
//    private Long toNextLevelExperience;
//

//    @NotNull
//    private Long hit;
//    @Column(name="critical_hit", nullable = false)
//    private Long criticalHit = 2 * this.hit;
//
//    @Column(name="health_points", nullable = false)
//    private Long healthPoints;
//    @NotNull
//    private Long strength;
//    @NotNull
//    private Long dexterity;
//    @NotNull
//    private Long intelligence;
//    @NotNull
//    private Long lucky;
//    @NotNull
//    private Long armour;
    //TODO think about another attributes


    protected void attack(){
        //TODO make a method of attack
    }

    protected void defend(){
        //TODO make a method of defend
    }
}
