package logic;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Test")
public class Test {

    private Long tid;
    private String tname;
    private Statistics statistics;
    private Student student;

    public Test(){
        tname = null;
    }

    public Test(Test s){
        tname = s.getTName();
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="tid")
    public Long getTid() {
        return tid;
    }

    @Column(name="tname")
    public String getTName(){
        return tname;
    }

    public void setTid(Long i){
        tid = i;
    }

    public void setTName(String s){
        tname = s;
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
    @JoinTable(name = "Statistics", joinColumns = @JoinColumn(name = "tid"), inverseJoinColumns = @JoinColumn(name = "id"))
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student){
        this.student = student;
    }
}