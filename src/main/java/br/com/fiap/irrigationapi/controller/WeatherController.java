package br.com.fiap.irrigationapi.controller;

import br.com.fiap.irrigationapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weathers")
public class WeatherController {

    @Autowired
    private WeatherService service;

    // TO DO: Implements routes

}
