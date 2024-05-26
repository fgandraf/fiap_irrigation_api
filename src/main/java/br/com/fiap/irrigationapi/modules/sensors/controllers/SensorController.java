package br.com.fiap.irrigationapi.modules.sensors.controllers;

import br.com.fiap.irrigationapi.modules.sensors.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    @Autowired
    private SensorService service;

    // TO DO: Implements routes

}
