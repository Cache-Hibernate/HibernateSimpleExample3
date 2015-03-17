package logic;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Statistics")
public class Statistics {

    private Long stid;
    private Long id;
    private Long tid;
//    private Set<Student> students = new HashSet<Student>(0);
//    private Set<Test> tests = new HashSet<Test>(0);

    public Statistics(){
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="stid")
    public Long getStid(){
        return stid;
    }

    @Column(name="id")
    public Long getId(){
        return id;
    }

    @Column(name="tid")
    public Long getTid(){
        return tid;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setTid(Long tid){
        this.tid = tid;
    }

    public void setStid(Long stid){
        this.stid = stid;
    }

//    @OneToMany
//    @JoinTable(name = "id")
//    public Set<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(Set<Student> students){
//        this.students = students;
//    }
//
//    @OneToMany
//    @JoinTable(name = "id")
//    public Set<Test> getTests() {
//        return tests;
//    }
//
//    public void setTests(Set<Test> tests){
//        this.tests = tests;
//    }
}