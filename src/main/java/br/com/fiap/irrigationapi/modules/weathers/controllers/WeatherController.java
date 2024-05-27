package br.com.fiap.irrigationapi.modules.weathers.controllers;

import br.com.fiap.irrigationapi.modules.weathers.models.Weather;
import br.com.fiap.irrigationapi.modules.weathers.services.WeatherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/weathers")
public class WeatherController {

    @Autowired
    private WeatherService service;
    @PostMapping
    public ResponseEntity<Weather> create(@RequestBody @Valid Weather weather) {
        Weather savedWeather = service.save(weather);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedWeather.getId()).toUri();
        return ResponseEntity.created(location).body(savedWeather);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Weather> getById(@PathVariable Long id) {
        Optional<Weather> weather = service.findById(id);
        return weather.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Weather>> getAll(Pageable pageable) {
        Page<Weather> weathers = service.findAll(pageable);
        return ResponseEntity.ok(weathers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Weather> update(@PathVariable Long id, @RequestBody @Valid Weather weather) {
        if (!service.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        weather.setId(id);
        return ResponseEntity.ok(service.update(weather));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!service.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
