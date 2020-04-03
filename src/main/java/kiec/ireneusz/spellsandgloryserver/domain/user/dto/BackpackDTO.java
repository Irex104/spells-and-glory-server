package kiec.ireneusz.spellsandgloryserver.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BackpackDTO {

    private List<ItemDTO> itemsDTOs;

    public BackpackDTO(List<ItemDTO> itemsDTOs) {
        this.itemsDTOs = itemsDTOs;
    }
}
