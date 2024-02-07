package by.SpringBoot.controller;

import by.SpringBoot.model.EventLog;
import by.SpringBoot.model.Student;
import by.SpringBoot.service.EventLogService;
import by.SpringBoot.service.StudenService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@OpenAPIDefinition(info = @Info(title = "API Test", version = "1.0"))
public class TestsController {

    @Autowired
    private final StudenService studenService;

    @Autowired
    private final EventLogService eventLogService;

    public TestsController(StudenService studenService, EventLogService eventLogService) {
        this.studenService = studenService;
        this.eventLogService = eventLogService;
    }

    @GetMapping("/student")
    public List<Student> findAllStudent(){
        return studenService.getStudentAll();
    }

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student){
        return studenService.save(student);
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable Integer id,@RequestBody Student student){
        return studenService.updateStatus(id, student);
    }

    @GetMapping("/student/{id}")
    public Student findByIdStudent(@PathVariable Integer id){
        return studenService.findById(id)
                .orElseThrow(()->new RuntimeException("Student not found: "+id));
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable Integer id){
        studenService.deleteById(id);
    }

    @GetMapping("/log")
    public List<EventLog>findAllEventLog(){
        return eventLogService.findAll();
    }

    @PostMapping("/log")
    public EventLog saveEventLog(@RequestBody EventLog eventLog){
        return eventLogService.save(eventLog);
    }

    @DeleteMapping("/log/{id}")
    public void deleteEventLog(@PathVariable Integer id){
        eventLogService.deleteById(id);
    }

    @GetMapping("/log/{id}")
    public EventLog findByIdEventLog(@PathVariable Integer id){
        return eventLogService.findById(id)
                .orElseThrow(()->new RuntimeException("EventLog Not fount: "+id));
    }

    @PutMapping("/log/{id}")
    public EventLog updateEventLog(@PathVariable Integer id,@RequestBody EventLog eventLog){
        return eventLogService.updateEventLog(id, eventLog);
    }

}
