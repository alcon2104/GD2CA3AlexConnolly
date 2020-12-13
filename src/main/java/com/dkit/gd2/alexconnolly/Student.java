package com.dkit.gd2.alexconnolly;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Student
{
    private static Scanner keyboard = new Scanner(System.in);

    private String name;
    private String ID;
    private String email;
    private String telephone;
    private ArrayList<String> loans;

    public Student(String name, String ID, String email, String telephone)
    {
        this.name = name;
        this.ID = ID;
        this.email = email;
        this.telephone = telephone;
        this.loans = new ArrayList();
    }

    public Student(String name, String ID, String email, String telephone, ArrayList<String> loans)
    {
        this.name = name;
        this.ID = ID;
        this.email = email;
        this.telephone = telephone;
        this.loans = loans;
    }

    public String getName()
    {
        return name;
    }

    public String getID()
    {
        return ID;
    }

    public String getEmail()
    {
        return email;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public ArrayList getLoans()
    {
        return loans;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "name='" + name + '\'' +
                ", ID='" + ID + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", loans=" + loans +
                '}';
    }
}

