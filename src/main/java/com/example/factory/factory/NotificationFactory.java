package com.example.factory.factory;

import com.example.factory.service.NotificationService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class NotificationFactory {
    private final Map<String, NotificationService> services;

    public NotificationFactory(List<NotificationService> services) {
        this.services = services.stream()
                .collect(Collectors.toMap(NotificationService::getChannel, Function.identity()));
    }

    public NotificationService getService(String channel) {
        return Optional.ofNullable(services.get(channel.toUpperCase()))
                .orElseThrow(() -> new IllegalArgumentException("Canal inválido: " + channel));
    }
}
