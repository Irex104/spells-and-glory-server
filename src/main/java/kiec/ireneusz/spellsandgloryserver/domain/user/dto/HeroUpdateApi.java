package kiec.ireneusz.spellsandgloryserver.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HeroUpdateApi {

    private String name;
    private String description;
    private String image;
    
}
