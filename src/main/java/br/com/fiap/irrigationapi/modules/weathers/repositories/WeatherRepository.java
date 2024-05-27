package br.com.fiap.irrigationapi.modules.weathers.repositories;

import br.com.fiap.irrigationapi.modules.weathers.models.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {

}
