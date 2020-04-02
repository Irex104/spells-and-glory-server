package kiec.ireneusz.spellsandgloryserver.domain.camp;

import kiec.ireneusz.spellsandgloryserver.domain.camp.dto.CampApi;
import kiec.ireneusz.spellsandgloryserver.utils.AbstractModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "camps")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Camp extends AbstractModel {

    public Camp(CampApi api) {
    }
}
