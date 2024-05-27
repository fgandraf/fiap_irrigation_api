package br.com.fiap.irrigationapi.modules.schedule.repositories;

import br.com.fiap.irrigationapi.modules.schedule.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
