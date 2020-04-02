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
public class MonsterDTO{

    protected String name;
    protected String description;
    protected Profession character;
    protected String image;

}
