package com.day1csvdatahandling.advanceproblems.csvdatatojavaobjects;

public class Student {
    private String name;
    private int age;
    private double marks;

    public Student(String name, int age, double marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", marks=" + marks + "}";
    }

    //Getters and setters
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getMarks() { return marks; }
}

