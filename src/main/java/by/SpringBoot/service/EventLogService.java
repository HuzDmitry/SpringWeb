package by.SpringBoot.service;

import by.SpringBoot.model.EventLog;
import by.SpringBoot.model.EventLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class EventLogService {
    @Autowired
    private final EventLogRepository repository;

    public EventLogService(EventLogRepository repository) {
        this.repository = repository;
    }

    /**
     * сохранение результата в журнале
     * @param eventLog
     * @return
     */
    public EventLog save(EventLog eventLog){
        return repository.save(eventLog);
    }

    /**
     * Удаление результата в журнале
     * @param id
     */
    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    /**
     * Получение результата по id
     * @param id
     * @return
     */
    public Optional<EventLog>findById(Integer id){
        return repository.findById(id);
    }

    /**
     * получение всех событий
     * @return
     */
    public List<EventLog> findAll(){
        return repository.findAll();
    }

    /**
     * Обновление статуса и времени окончания теста
     * @param id
     * @param eventLog
     * @return
     */
    public EventLog updateEventLog(Integer id, EventLog eventLog){
        EventLog ev = repository.findById(id).orElseThrow();
        ev.setStatusTest(eventLog.getStatusTest());
        ev.setTestEnd(eventLog.getTestEnd());
        ev.setTestEnd(new Timestamp(System.currentTimeMillis()));
        return repository.save(ev);
    }
}
