package br.com.fiap.irrigationapi.modules.weathers.controllers;

import br.com.fiap.irrigationapi.modules.weathers.services.WeatherService;
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
