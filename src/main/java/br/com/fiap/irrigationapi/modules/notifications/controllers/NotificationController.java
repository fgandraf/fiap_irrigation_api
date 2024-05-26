package br.com.fiap.irrigationapi.modules.notifications.controllers;

import br.com.fiap.irrigationapi.modules.notifications.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService service;

    // TO DO: Implements routes

}
