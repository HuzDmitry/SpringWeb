package by.SpringBoot.service;


import by.SpringBoot.model.Student;
import by.SpringBoot.model.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class StudenService {
    @Autowired
    private final StudentRepository repository;

    public StudenService(StudentRepository repository) {
        this.repository = repository;
    }

    /**
     * Получение ученика по id
     * @param id
     * @return
     */
    public Optional<Student> findById(Integer id){
        return repository.findById(id);
    }

    /**
     * Получение списка всех учеников
     * @return
     */
    public List<Student>getStudentAll(){
        return repository.findAll();
    }

    /**
     * Удаление ученика по id
     * @param id
     */
    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    /**
     * Сохранение ученика
     * @param student
     * @return
     */
    public Student save(Student student){
        return repository.save(student);
    }

    /**
     * Обновление ученика по id
     * @param id
     * @param student
     * @return
     */
    public Student updateStatus(Integer id, Student student){
        Student st = repository.findById(id)
                .orElseThrow();
        st.setName(student.getName());
        st.setSurname(student.getSurname());
        st.setPosition(student.getPosition());
        return repository.save(st);
    }

}
