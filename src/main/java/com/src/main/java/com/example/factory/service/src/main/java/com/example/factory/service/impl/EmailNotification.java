package com.example.factory.service.impl;

import com.example.factory.service.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class EmailNotification implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Enviando E-mail: " + message);
    }

    @Override
    public String getChannel() {
        return "EMAIL";
    }
}
