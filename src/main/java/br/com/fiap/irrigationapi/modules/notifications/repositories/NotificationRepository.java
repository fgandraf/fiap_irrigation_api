package br.com.fiap.irrigationapi.modules.notifications.repositories;

import br.com.fiap.irrigationapi.modules.notifications.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    // TO DO: Implements
}
