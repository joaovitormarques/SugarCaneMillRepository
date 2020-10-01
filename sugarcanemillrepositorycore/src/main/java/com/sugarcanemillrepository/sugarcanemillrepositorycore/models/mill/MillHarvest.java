package com.sugarcanemillrepository.sugarcanemillrepositorycore.models.mill;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.AuditModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mill_harvest", schema = "public")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Getter
@Setter
public class MillHarvest extends AuditModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_mill")
    private Long idMill;

    @Column(name = "id_harvest")
    private Long idHarvest;

    public MillHarvest(Long idMill, Long idHarvest) {
        this.idMill = idMill;
        this.idHarvest = idHarvest;
    }
}
