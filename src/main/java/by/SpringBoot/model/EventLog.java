package by.SpringBoot.model;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.sql.Timestamp;

@Entity
public class EventLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="test_start")
    @CreationTimestamp
    private Timestamp testStart;

    @Column(name = "test_end")
    @CreationTimestamp
    private Timestamp testEnd;

    @Column(name="status_test")
    private String statusTest;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getTestStart() {
        return testStart;
    }

    public void setTestStart(Timestamp testStart) {
        this.testStart = testStart;
    }

    public Timestamp getTestEnd() {
        return testEnd;
    }

    public void setTestEnd(Timestamp testEnd) {
        this.testEnd = testEnd;
    }

    public String getStatusTest() {
        return statusTest;
    }

    public void setStatusTest(String statusTest) {
        this.statusTest = statusTest;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
