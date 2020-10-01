package com.sugarcanemillrepository.sugarcanemillrepositorycore.models.harvest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.AuditModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "harvest", schema = "public")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Getter
@Setter
public class Harvest extends AuditModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date")
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date")
    private Date endDate;

    @Transient
    List<Long> farmIds;
}
