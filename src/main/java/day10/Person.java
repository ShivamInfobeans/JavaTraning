package day10;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/*
Each person could have multiple phone numbers linked to it.
person (id,name)   phonenumber(id, phonenumber, person_id, provider)
person(1, name-1)
insert into phonernumber("123123",1)
insert into phonernumber("1231123",1)

 */
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "person",cascade = CascadeType.PERSIST)
    private Set<PhoneNumber> phoneNumbers= new HashSet<>();

    public Set<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }





    public Person() {
    }

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
}