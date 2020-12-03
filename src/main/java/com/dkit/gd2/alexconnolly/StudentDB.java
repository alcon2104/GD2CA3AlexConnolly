package com.dkit.gd2.alexconnolly;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDB
{
    private ArrayList<Student> students;
    private static Scanner keyboard = new Scanner(System.in);

    public StudentDB(ArrayList<Student> students)
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
}
