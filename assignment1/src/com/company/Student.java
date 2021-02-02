package com.company;

public class Student {

    private String name;
    private String familyName;
    private final int studentNumber;

    public Student(String name, String familyName, int studentNumber) {
        this.name = name;
        this.familyName = familyName;
        this.studentNumber = studentNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    @Override
    public String toString() {
        return (name + ' ' +
                familyName +
                ", s" + studentNumber +
                '.');
    }
}
