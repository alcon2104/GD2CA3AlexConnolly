package com.dkit.gd2.alexconnolly;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Student implements RecordChanges
{
    private static Scanner keyboard = new Scanner(System.in);

    private String name;
    private static String ID;
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

    @Override
    public void add()
    {
        System.out.println("Please Enter the new Student's details below, after every new detail, please press enter");
        System.out.println("Name:");
        String newName = keyboard.nextLine();
        String newID = generateStudentID();
        System.out.println("Email:");
        String newEmail = keyboard.nextLine();
        System.out.println("Phone Number");
        String newTelephone = keyboard.nextLine();
        Student newStudent = new Student(newName, newID, newEmail, newTelephone);

        //Write to file
    }

    private String generateStudentID()
    {
        Random rand = new Random();
        int lowerBound = 10000000;
        int higherBound = 99999999;
        String newID = "D"+rand.nextInt(higherBound - lowerBound);
        if(newID == /*existing student ids*/)
        {
            generateStudentID();
        }
        return newID;
    }

    @Override
    public void edit() {
        System.out.println("Enter the ID of the student you wish to edit");
        String ID = keyboard.nextLine();
        System.out.println("Select the entry you'd like to change\n0 - QUIT\t1 - ID \t2 - Name\n3 - Email\t4 - Telephone");
        boolean loop = true;
        EditStudentOptions menuChoice;
        int selected;
        while (loop) {
            selected = keyboard.nextInt();
            keyboard.nextLine();
            menuChoice = EditStudentOptions.values()[selected];
            try {
                switch (menuChoice) {
                    case QUIT:
                        loop = false;
                        break;
                    case ID:
                        System.out.println("Enter the new ID");
                        String newID = keyboard.nextLine();
                        //check that the id doesn't already exist already first
                        //students.getID().setID(newID);

                    case NAME:
                        System.out.println("Enter the new Name");
                        String newName = keyboard.nextLine();
                        //students.getID().setName(newName);

                    case EMAIL:
                        System.out.println("Enter the new Email");
                        String newEmail = keyboard.nextLine();
                        //students.getID().setEmail(newEmail);

                    case TELEPHONE:
                        System.out.println("Enter the new Telephone");
                        String newTelephone = keyboard.nextLine();
                        //students.getID().setTelephone(newTelephone);

                }
            } catch (IllegalArgumentException e) {
                System.out.println("Selection out of range, try again");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Selection out of range, try again");
            }
        }
    }

    @Override
    public void delete()
    {
        System.out.println("Enter the ID of the student you wish to delete");
        String deleteID = keyboard.nextLine();
        try
        {
            System.out.println("Are you sure you want to delete the student?\n1 - Yes\t2 - No");
            int deleteChoice = keyboard.nextInt();
            keyboard.nextLine();
            if (deleteChoice == 1)
            {
                //students.getStudentID().remove();
                System.out.println("The student has been deleted.");
                System.out.println("Returning you to the main menu...");
            }
            else if (deleteChoice == 2)
            {
                System.out.println("Returning you to the main menu...");
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Selection out of range, try again");
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Selection out of range, try again");
        }
    }

    @Override
    public void print()
    {
        System.out.println("Enter the ID of the student you wish to view");
        String ID = keyboard.nextLine();
        //search students arraylist in db and print out any corresponding numbers in a new array
        //if the array is still empty at the end, say the student number doesn't exist
    }
}

