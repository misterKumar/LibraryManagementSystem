package com.example.Student_Library_Management_System.Models;

import jakarta.persistence.*;

@Entity
@Table(name="Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true)
    private String email;// note that donot enter duplicate mail.
    private int age;
    private String country;
    private String mobile;
    // plain syntax for bidirectional mapping
    // name of variable of the parent entity that you have written in child class foreign key attributes.
    // i.e., from child class  @OneToOne
    //    @JoinColumn
    //    Student student this student variable have to mention in parent class
    @OneToOne(mappedBy = "studentVariableName",cascade = CascadeType.ALL)
    private Card card;

    public Student() {
        // this constructor is for beans caused by entity
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
