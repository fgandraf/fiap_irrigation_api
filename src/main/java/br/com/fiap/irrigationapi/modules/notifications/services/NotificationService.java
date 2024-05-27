package br.com.fiap.irrigationapi.modules.notifications.services;

import br.com.fiap.irrigationapi.exceptions.NotFoundException;
import br.com.fiap.irrigationapi.modules.notifications.dtos.CreateNotification;
import br.com.fiap.irrigationapi.modules.notifications.dtos.OutputNotification;
import br.com.fiap.irrigationapi.modules.notifications.dtos.UpdateNotification;
import br.com.fiap.irrigationapi.modules.notifications.models.Notification;
import br.com.fiap.irrigationapi.modules.notifications.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public OutputNotification create(CreateNotification createNotification) {
        var notification = new Notification();
        notification.setDescription(createNotification.getDescription());
        notification.setTimestamp(createNotification.getTimestamp());

        return new OutputNotification(notificationRepository.save(notification));
    }

    public OutputNotification update(UpdateNotification updateNotification) {
        Notification notification = findById(updateNotification.getId());
        notification.setDescription(updateNotification.getDescription());
        notification.setTimestamp(updateNotification.getTimestamp());

        return new OutputNotification(notificationRepository.save(notification));
    }

    public Notification findById(Long id) {
        Optional<Notification> notification = notificationRepository.findById(id);
        if (notification.isPresent()) {
            return notification.get();
        } else {
            throw new NotFoundException("Notification", id);
        }
    }

    public Page<Notification> findAll(Pageable pageable) {
        return notificationRepository.findAll(pageable);
    }

    public void deleteById(Long id) {
        notificationRepository.deleteById(id);
    }
}