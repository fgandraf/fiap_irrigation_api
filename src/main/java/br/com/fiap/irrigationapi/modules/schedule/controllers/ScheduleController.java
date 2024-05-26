package br.com.fiap.irrigationapi.modules.schedule.controllers;

import br.com.fiap.irrigationapi.modules.schedule.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    // TO DO: Implements routes

}
