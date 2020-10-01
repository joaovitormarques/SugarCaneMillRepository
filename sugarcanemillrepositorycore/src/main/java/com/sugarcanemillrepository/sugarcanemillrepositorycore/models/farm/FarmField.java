package com.sugarcanemillrepository.sugarcanemillrepositorycore.models.farm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.AuditModel;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.field.Field;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "farm_field", schema = "public")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Getter
@Setter
public class FarmField extends AuditModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_farm")
    private Long idFarm;

    @Column(name = "id_field")
    private Long idField;

    public FarmField(Long idFarm, Long idField) {
        this.idFarm = idFarm;
        this.idField = idField;
    }
}
