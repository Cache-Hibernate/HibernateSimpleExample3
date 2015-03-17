package logic;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="Student")
public class Student {

    private Long id;
    private String name;
    private Long age;
    private Statistics statistics;
    private Test test;

    public Student(){
        name = null;
    }

    public Student(Student s){
        name = s.getName();
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    public Long getId() {
        return id;
    }

    @Column(name="name")
    public String getName(){
        return name;
    }

    @Column(name="age")
    public Long getAge(){
        return age;
    }

    public void setId(Long i){
        id = i;
    }

    public void setName(String s){
        name = s;
    }

    public void setAge(Long l){
        age = l;
    }

    @ManyToOne
    @JoinTable(name = "id")
    public Statistics getStatistics(){
        return statistics;
    }

    public void setStatistics(Statistics statistics){
        this.statistics = statistics;
    }

    @ManyToOne
    @JoinTable(name = "Statistics", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "tid"))
    public Test getTest(){
        return test;
    }

    public void setTest(Test test){
        this.test = test;
    }
}