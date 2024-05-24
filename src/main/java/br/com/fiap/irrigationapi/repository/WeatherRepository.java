package br.com.fiap.irrigationapi.repository;

import br.com.fiap.irrigationapi.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Long> {

    // TO DO: Implements

}
