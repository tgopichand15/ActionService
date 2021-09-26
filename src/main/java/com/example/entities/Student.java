package com.example.entities;

import javax.persistence.*;
import java.util.*;

//this is for one to one ,one to many and many to one examples


@Entity
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int rollno;
    private String name;
    private int marks;


    //so here we are adding list adding mappedby avoids extra table Student_Laptop because we already have mapping in laptop table
    @OneToMany

    //so if you want many to many add List of student in student class and now if we dont give mapped by field we will get 4 tables Laptop Student Laptop_Student,Student_Laptop to avoid this we need to add mappedBy="Student" or Laptop we can add field cascase=CascadeType.ALL and fetch=FetchType.EAGER if we give we will have only one mapping table that is  Student_laptop
    //in case if we want to customise the Laptop_Student table name as tge name which we give with Annotatoion (@JoinTable(name="employee_addresstable,joincolumns=@joincolumn(name="employee_id" ,inversejoincolumn=@joincolum("address_id")
    private List<Laptop> laptop=new ArrayList<Laptop>();

    public List<Laptop> getLaptop() {
        return laptop;
    }

    public void setLaptop(List<Laptop> laptop) {
        this.laptop = laptop;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", rollno=" + rollno +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", laptop=" + laptop +
                '}';
    }
}
