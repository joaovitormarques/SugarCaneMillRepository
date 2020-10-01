package com.sugarcanemillrepository.sugarcanemillrepositorycore.models.farm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.AuditModel;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.field.Field;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "farm", schema = "public")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Getter
@Setter
public class Farm extends AuditModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Transient
    List<Field> fields;

}
