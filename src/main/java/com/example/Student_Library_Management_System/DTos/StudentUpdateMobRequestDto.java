package com.example.Student_Library_Management_System.DTos;

public class StudentUpdateMobRequestDto {
    private int id;
    private String mobile;
    //Dto's depend on API's being called... add
    // attributes as required.

    public StudentUpdateMobRequestDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
