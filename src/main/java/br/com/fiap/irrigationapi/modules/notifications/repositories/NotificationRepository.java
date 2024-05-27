package br.com.fiap.irrigationapi.modules.notifications.repositories;

import br.com.fiap.irrigationapi.modules.notifications.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
