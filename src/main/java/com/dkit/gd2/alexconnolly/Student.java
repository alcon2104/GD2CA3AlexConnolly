package com.dkit.gd2.alexconnolly;

public class Student
{
    private String name;
    private String ID;
    private String email;
    private String telephone;
    private String loan;

    public Student(String name, String ID, String email, String telephone, String loan)
    {
        this.name = name;
        this.ID = ID;
        this.email = email;
        this.telephone = telephone;
        this.loan = loan;
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

    public String getLoan()
    {
        return loan;
    }

    public void newStudent()
    {

    }

    public void editStudent()
    {

    }
}
