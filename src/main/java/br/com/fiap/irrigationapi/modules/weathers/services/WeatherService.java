package br.com.fiap.irrigationapi.modules.weathers.services;

import br.com.fiap.irrigationapi.modules.weathers.models.Weather;
import br.com.fiap.irrigationapi.modules.weathers.repositories.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherService {
    @Autowired
    private WeatherRepository weatherRepository;

    public Weather save(Weather weather) {
        return weatherRepository.save(weather);
    }

    public Weather update(Weather weather) {
        return weatherRepository.save(weather);
    }

    public Optional<Weather> findById(Long id) {
        return weatherRepository.findById(id);
    }

    public Page<Weather> findAll(Pageable pageable) {
        return weatherRepository.findAll(pageable);
    }

    public void deleteById(Long id) {
        weatherRepository.deleteById(id);
    }
}
