package br.com.fiap.irrigationapi.repository;

import br.com.fiap.irrigationapi.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    // TO DO: Implements
}
