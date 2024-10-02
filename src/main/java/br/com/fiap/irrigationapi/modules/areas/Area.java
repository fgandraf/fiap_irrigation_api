package br.com.fiap.irrigationapi.modules.areas;

import br.com.fiap.irrigationapi.modules.sensors.Sensor;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tbl_area")
@Getter
@Setter
@EqualsAndHashCode
public class Area {

    @Id
    @Column(name = "area_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String location;

    @Column(name = "area_size")
    private String size;

    @OneToMany(mappedBy = "area")
    private List<Sensor> sensor;
}