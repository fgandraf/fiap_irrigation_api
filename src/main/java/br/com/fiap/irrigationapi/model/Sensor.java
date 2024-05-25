package br.com.fiap.irrigationapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tbl_sensor")
@Getter
@Setter
public class Sensor {

    @Id
    @Column(name = "sensor_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SENSOR")
    @SequenceGenerator(name = "SEQ_SENSOR", sequenceName = "SEQ_SENSOR", allocationSize = 1)
    private Long id;

    private String type;

    private String location;

//    @ManyToOne
//    @JoinColumn(name = "area_id")
//    private Area area;

    @OneToMany(mappedBy = "sensor")
    private List<Weather> weathers;

    @OneToMany(mappedBy = "sensor")
    private List<Notification> notifications;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sensor sensor = (Sensor) o;
        return Objects.equals(id, sensor.id) && Objects.equals(type, sensor.type) && Objects.equals(location, sensor.location) && Objects.equals(weathers, sensor.weathers) && Objects.equals(notifications, sensor.notifications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, location, weathers, notifications);
    }
}