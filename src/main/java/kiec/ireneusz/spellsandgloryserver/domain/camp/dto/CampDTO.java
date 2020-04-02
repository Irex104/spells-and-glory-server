package kiec.ireneusz.spellsandgloryserver.domain.camp.dto;

import kiec.ireneusz.spellsandgloryserver.domain.camp.Camp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CampDTO {

    public CampDTO(Camp camp) {
    }
}
