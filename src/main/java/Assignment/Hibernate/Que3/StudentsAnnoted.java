package Assignment.Hibernate.Que3;

//import jakarta.persistence.*;
import javax.persistence.*;

@Entity
@Table(name = "Students")
public class StudentsAnnoted {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public StudentsAnnoted() {
    }

    public StudentsAnnoted(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    private int marks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

}