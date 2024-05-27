package br.com.fiap.irrigationapi.modules.schedule.services;

import br.com.fiap.irrigationapi.modules.schedule.models.Schedule;
import br.com.fiap.irrigationapi.modules.schedule.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public Schedule update(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public Optional<Schedule> findById(Long id) {
        return scheduleRepository.findById(id);
    }

    public Page<Schedule> findAll(Pageable pageable) {
        return scheduleRepository.findAll(pageable);
    }

    public void deleteById(Long id) {
        scheduleRepository.deleteById(id);
    }
}
