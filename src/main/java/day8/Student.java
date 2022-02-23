package day8;

public class Student {
    private int id;
    private String name;
    private int roll;
    private final String university="xyz" ;

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

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getUniversity() {
        return university;
    }

    public Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }
}
