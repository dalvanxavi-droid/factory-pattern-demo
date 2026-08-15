package com.example.factory.controller;

import com.example.factory.factory.NotificationFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationFactory factory;

    public NotificationController(NotificationFactory factory) {
        this.factory = factory;
    }

    @PostMapping("/{channel}")
    public ResponseEntity<String> sendNotification(@PathVariable String channel, @RequestBody String message) {
        factory.getService(channel).send(message);
        return ResponseEntity.ok("Notificação enviada com sucesso via " + channel);
    }
}
