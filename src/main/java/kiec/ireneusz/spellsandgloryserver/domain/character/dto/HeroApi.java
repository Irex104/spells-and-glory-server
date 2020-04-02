package kiec.ireneusz.spellsandgloryserver.domain.character.dto;

import kiec.ireneusz.spellsandgloryserver.enums.Profession;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HeroApi{

    private String name;
    private String description;
    private Profession profession;
    private String image;

}
