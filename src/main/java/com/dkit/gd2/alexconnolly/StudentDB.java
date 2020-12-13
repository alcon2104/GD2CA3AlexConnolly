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
        this.students = new ArrayList<>();
    }

    public void loadStudentsFromFile()
    {
        try (Scanner studentFile = new Scanner(new BufferedReader(new FileReader("Students.txt"))))
        {
            while (studentFile.hasNextLine())
            {
                String input = studentFile.nextLine();
                String[] data = input.split(",");
                String name = data[0];
                String ID = data[1];
                String email = data[2];
                String telephone = data[3];
                ArrayList<String> loans = readStudentLoans(data);

                Student newStudent = new Student(name, ID, email, telephone, loans);
                this.students.add(newStudent);
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
            for (int i = 4; i < data.length; i++)
            {
                loans.add(data[i]);
            }
            return loans;
    }

    public static void saveStudentsToFile()
    {
        try (BufferedWriter studentFile = new BufferedWriter(new FileWriter("Students.txt")))
        {
            if(students != null)
            {
                for (Student student : students)
                {
                    studentFile.write(student.getName() + "," + student.getID() + "," + student.getEmail() + "," + student.getTelephone() + "," + student.getLoans());
                    studentFile.write("\n");
                }
            }
        }
        catch (IOException e)
        {
            System.out.println(Colours.RED+"Bookings could not be saved"+Colours.RESET);
        }
    }

    @Override
    public void addNew()
    {
        if(students != null)
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
    public void edit()
    {
        if(students != null)
        {
            System.out.println("Enter the ID of the student you wish to edit");
            String editID = keyboard.nextLine();
            Student studentToEdit = findStudent(editID);
            System.out.println("Select the entry you'd like to change\n0 - QUIT\t1 - ID \t2 - Name\n3 - Email\t4 - Telephone");
            boolean loop = true;
            EditStudentOptions menuChoice;
            int selected;
            while (loop)
            {
                selected = keyboard.nextInt();
                keyboard.nextLine();
                menuChoice = EditStudentOptions.values()[selected];
                try
                {
                    switch (menuChoice)
                    {
                        case QUIT:
                            loop = false;
                            break;
                        case ID:
                            System.out.println("Enter the new ID");
                            String newID = keyboard.nextLine();
                            studentToEdit.setID(newID);
                            System.out.println("Edit Successful.");

                            System.out.println("Returning you to the Student menu...");
                            loop = false;
                            break;
                        case NAME:
                            System.out.println("Enter the new name");
                            String newName = keyboard.nextLine();
                            studentToEdit.setName(newName);
                            System.out.println("Edit Successful.");

                            System.out.println("Returning you to the Student menu...");
                            loop = false;
                            break;

                        case EMAIL:
                                System.out.println("Enter the new email");
                                    String newEmail = keyboard.nextLine();
                                    studentToEdit.setEmail(newEmail);
                                    System.out.println("Edit Successful.");

                                System.out.println("Returning you to the Student menu...");
                                loop = false;
                                break;

                        case TELEPHONE:
                            System.out.println("Enter the new phone number");
                            String newPhone = keyboard.nextLine();
                            studentToEdit.setTelephone(newPhone);
                            System.out.println("Edit Successful.");

                            System.out.println("Returning you to the Student menu...");
                            loop = false;
                            break;


                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(Colours.RED + "Selection out of range, try again" + Colours.RESET);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(Colours.RED + "Selection out of range, try again" + Colours.RESET);
                }
            }
        }
    }

    @Override
    public void delete()
    {
        if(students != null)
        {
            System.out.println("Enter the ID of the student you wish to delete");
            String deleteID = keyboard.nextLine();
            try {
                System.out.println(Colours.RED + "Are you sure you want to delete the student?\n1 - Yes\t2 - No" + Colours.RESET);
                int deleteChoice = keyboard.nextInt();
                keyboard.nextLine();
                if (deleteChoice == 1)
                {
                    if(students != null)
                    {
                        Student studentToDelete = findStudent(deleteID);
                        if(studentToDelete != null)
                        {
                            students.remove(studentToDelete);
                            System.out.println("The booking has been deleted.");
                            System.out.println("Returning you to the Student menu...");
                        }
                    }
                }
                else if (deleteChoice == 2)
                {
                    System.out.println("Returning you to the Student menu...");
                }
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(Colours.RED + "Selection out of range, try again" + Colours.RESET);
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println(Colours.RED + "Selection out of range, try again" + Colours.RESET);
            }
        }
    }

    private Student findStudent(String ID)
    {
        for (Student student : students)
        {
            if (student.getID().equals(ID))
            {
                return student;
            }
        }
        return null;
    }

    @Override
    public void print()
    {
        if(students != null)
        {
            System.out.println("Enter the ID of the student you wish to view");
            String ID = keyboard.nextLine();
            for (Student student : students)
            {
                if (student.getID().equals(ID))
                {
                    System.out.println(student);
                }
            }
        }
    }
}
