package com.dkit.gd2.alexconnolly;

import java.lang.reflect.Array;

public class Student
{
    private String name;
    private static String ID;
    private String email;
    private String telephone;
    private Array loans;

    public Student(String name, String ID, String email, String telephone, Array loan)
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

    public static String getID()
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

    public Array getLoans()
    {
        return loans;
    }

    public void newStudent()
    {

    }

    public static void addStudent()
    {

    }

    public static void editStudent()
    {

    }
}
