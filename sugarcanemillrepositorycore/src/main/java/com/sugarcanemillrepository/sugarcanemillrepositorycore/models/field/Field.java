package com.sugarcanemillrepository.sugarcanemillrepositorycore.models.field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sugarcanemillrepository.sugarcanemillrepositorycore.models.AuditModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "field", schema = "public")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Getter
@Setter
@NoArgsConstructor
public class Field extends AuditModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "latitude", columnDefinition = "numeric")
    private double latitude;

    @Column(name = "longitude", columnDefinition = "numeric")
    private double longitude;
}
