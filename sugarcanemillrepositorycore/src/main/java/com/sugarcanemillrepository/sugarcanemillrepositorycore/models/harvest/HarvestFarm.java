package com.sugarcanemillrepository.sugarcanemillrepositorycore.models.harvest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.AuditModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "harvest_farm", schema = "public")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Getter
@Setter
public class HarvestFarm extends AuditModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_harvest")
    private Long idHarvest;

    @Column(name = "id_farm")
    private Long idFarm;

    public HarvestFarm(Long idHarvest, Long idFarm) {
        this.idHarvest = idHarvest;
        this.idFarm = idFarm;
    }
}
