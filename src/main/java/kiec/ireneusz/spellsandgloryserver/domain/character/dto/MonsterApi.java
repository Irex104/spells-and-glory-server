package kiec.ireneusz.spellsandgloryserver.domain.character.dto;

import kiec.ireneusz.spellsandgloryserver.enums.Profession;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MonsterApi{

    private String name;
    private String description;
    private Profession character;
    private String image;

}
