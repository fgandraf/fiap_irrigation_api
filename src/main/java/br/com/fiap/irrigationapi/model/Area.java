//package br.com.fiap.irrigationapi.model;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import java.util.List;
//import java.util.Objects;
//
//@Entity
//@Table(name = "tbl_area")
//@Getter
//@Setter
//public class Area {
//
//
//    @Id
//    @Column(name = "area_id")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AREA")
//    @SequenceGenerator(name = "SEQ_AREA", sequenceName = "SEQ_AREA", allocationSize = 1)
//    private Long id;
//
//    private String description;
//
//    private String location;
//
//    private String size;
//
//    @OneToMany(mappedBy = "area")
//    private List<Sensor> sensor;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Area area = (Area) o;
//        return Objects.equals(id, area.id) && Objects.equals(description, area.description) && Objects.equals(location, area.location) && Objects.equals(size, area.size) && Objects.equals(sensor, area.sensor);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, description, location, size, sensor);
//    }
//}