package day8;

public class PhoneNumber {
    private int id;
    private String number;
    private Person1 person;

    public PhoneNumber() {
    }

    public PhoneNumber(int id, String number, Person1 person) {
        this.id = id;
        this.number = number;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public Person1 getPerson() {
        return person;
    }

    public void setPerson(Person1 person) {
        this.person = person;
    }
}