package com.dkit.gd2.alexconnolly;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Student
{
    private static Scanner keyboard = new Scanner(System.in);

    private String name;
    private static String ID;
    private String email;
    private String telephone;
    private ArrayList loans;

    public Student(String name, String ID, String email, String telephone, ArrayList loan)
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

    public ArrayList getLoans()
    {
        return loans;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public static void setID(String ID)
    {
        Student.ID = ID;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public static void addStudent()
    {
        //read file
        System.out.println("Please Enter the new Student's details below, after every new detail, please press enter");
        String newName = keyboard.nextLine();
        String newID = keyboard.nextLine();
        String newEmail = keyboard.nextLine();
        String newTelephone = keyboard.nextLine();
        System.out.println("Please enter each loan individually. If there is no loans, enter nothing");
        String newLoan = keyboard.nextLine();
        if(newLoan == null)
        {
            Student newStudent = new Student(newName, newID, newEmail, newTelephone, null );

        }
        else
        {
            //Student newStudent = new Student(newName, newID, newEmail, newTelephone, loans.add(newLoan));

        }
        //Write to file
    }

    public static void editStudent()
    {
        System.out.println("Enter the ID of the student you wish to edit, then select which action you'd like to take");
        String editID = keyboard.nextLine();
        System.out.println("1 - Edit details\t2 - Delete Student");
        int ans = keyboard.nextInt();
        try
        {
            if (ans == 1) {
                System.out.println("Select the entry you'd like to change\n1 - ID \t2 - Name\t3 - Email\t4 - Telephone");
                EditStudentOptions selected = EditStudentOptions.CONTINUE;
                selected = EditStudentOptions.values()[Integer.parseInt(keyboard.nextLine().trim())];
                switch (selected) {
                    case ID:
                        System.out.println("Enter the new ID");
                        String newID = keyboard.nextLine();
                        //.getID().setID(newID);

                    case NAME:
                        System.out.println("Enter the new Name");
                        String newName = keyboard.nextLine();
                        //.getID().setName(newName);

                    case EMAIL:
                        System.out.println("Enter the new Email");
                        String newEmail = keyboard.nextLine();
                        //.getID().setEmail(newEmail);

                    case TELEPHONE:
                        System.out.println("Enter the new Telephone");
                        String newTelephone = keyboard.nextLine();
                        //.getID().setTelephone(newTelephone);
                }
            }
            else if (ans == 2) {
                try
                {
                    System.out.println("Are you sure you want to delete the student?\n1 - Yes\t2 - No");
                    int delete = keyboard.nextInt();
                    if (delete == 1)
                    {
                        //delete the poor kid
                        System.out.println("The student has been deleted.");
                        System.out.println("Returning you to the main menu...");
                    }
                    else if (delete == 2)
                    {
                        System.out.println("Returning you to the main menu...");
                        App.main();
                    }
                }
                catch(IllegalArgumentException e)
                {
                    System.out.println("Selection out of range, try again");
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    System.out.println("Selection out of range, try again");
                }
            }
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Selection out of range, try again");
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Selection out of range, try again");
        }

    }
}
