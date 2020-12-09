package com.dkit.gd2.alexconnolly;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class StudentDB implements RecordChanges
{
    private static ArrayList<Student> students;
    private static Scanner keyboard = new Scanner(System.in);

    public StudentDB()
    {
        this.students = students;
    }

    public static void loadStudentsFromFile() {
        try (Scanner studentFile = new Scanner(new BufferedReader(new FileReader("Students.txt"))))
        {
            while (studentFile.hasNextLine())
            {
                String input = studentFile.nextLine();
                String[] data = input.split(",");
                String name = data[0];
                String ID = data[1];
                String email = data[3];
                String telephone = data[4];
                ArrayList<String> loans = readStudentLoans(data);
            }

        }
        catch (FileNotFoundException e)
        {
            System.out.println(Colours.PURPLE+"Could not load players; if this is the first time running the application then this might be fine."+Colours.RESET);
        }
    }

    private static ArrayList<String> readStudentLoans(String[] data)
    {
        ArrayList<String> loans = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            loans.add(data[i]);
        }
        return loans;
    }

    public static void saveStudentsToFile()
    {
        try (BufferedWriter studentFile = new BufferedWriter(new FileWriter("Students.txt")))
        {
            for(Student student: students)
                studentFile.write(student.getName() + student.getID() + student.getEmail() + student.getTelephone() + student.getLoans());
                studentFile.write("\n");
        }
        catch (IOException e)
        {
            System.out.println(Colours.RED+"Bookings could not be saved"+Colours.RESET);
        }
    }

    @Override
    public void addNew()
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

        students.add(newStudent);

        saveStudentsToFile();
    }

    public static String generateStudentID()
    {
        Random rand = new Random();
        int lowerBound = 10000000;
        int higherBound = 99999999;
        String newID = "D"+rand.nextInt(higherBound - lowerBound);
        for(int i = 0; i < students.size(); i++)
            if(newID == students.get(i).getID())
            {
                generateStudentID();
            }
        return newID;
    }

    @Override
    public void edit() {
        System.out.println("Enter the ID of the student you wish to edit");
        String editID = keyboard.nextLine();
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
                        for(int i = 0; i < students.size(); i++)
                        {
                            if(students.get(i).getID() == editID)
                            {
                                System.out.println("Enter the new ID");
                                String newID = keyboard.nextLine();
                                students.get(i).setName(newID);
                                System.out.println("Edit Successful.");
                            }
                            else
                            {
                                System.out.println(Colours.RED+"The Student ID you entered already exists, and so could not be added"+Colours.RESET);
                            }
                            System.out.println("Returning you to the Booking menu...");
                        }
                    case NAME:
                        for(int i = 0; i <= students.size(); i++)
                        {
                            if(students.get(i).getID() == editID)
                            {
                                System.out.println("Enter the new name");
                                String newName = keyboard.nextLine();
                                students.get(i).setName(newName);
                                System.out.println("Edit Successful.");
                            }
                            System.out.println("Returning you to the Booking menu...");
                        }

                    case EMAIL:
                        for(int i = 0; i <= students.size(); i++)
                        {
                            if(students.get(i).getID() == editID)
                            {
                                System.out.println("Enter the new email");
                                String newEmail = keyboard.nextLine();
                                students.get(i).setEmail(newEmail);
                                System.out.println("Edit Successful.");
                            }
                            System.out.println("Returning you to the Booking menu...");
                        }

                    case TELEPHONE:
                        for(int i = 0; i <= students.size(); i++)
                        {
                            if(students.get(i).getID() == editID)
                            {
                                System.out.println("Enter the new telephone number");
                                String newNumber = keyboard.nextLine();
                                students.get(i).setName(newNumber);
                                System.out.println("Edit Successful.");
                            }
                            System.out.println("Returning you to the Booking menu...");
                        }

                }
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(Colours.RED+"Selection out of range, try again"+Colours.RESET);
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println(Colours.RED+"Selection out of range, try again"+Colours.RESET);
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
            System.out.println(Colours.RED+"Are you sure you want to delete the student?\n1 - Yes\t2 - No"+Colours.RESET);
            int deleteChoice = keyboard.nextInt();
            keyboard.nextLine();
            if (deleteChoice == 1)
            {
                for(int i = 0; i <= students.size(); i++)
                {
                    if(students.get(i).getID() == deleteID)
                    {
                        students.remove(students.get(i));
                    }
                    System.out.println("The booking has been deleted.");
                    System.out.println("Returning you to the Booking menu...");
                }
            }
            else if (deleteChoice == 2)
            {
                System.out.println("Returning you to the main menu...");
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(Colours.RED+"Selection out of range, try again"+Colours.RESET);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println(Colours.RED+"Selection out of range, try again"+Colours.RESET);
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
