package com.dkit.gd2.alexconnolly;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Bookings
{
    private static Scanner keyboard = new Scanner(System.in);

    private int bookingID;
    private String bookDateTime;
    private String returnDateTime;
    private String computerType;
    private String assetTag;
    private String studentID;

    public Bookings(int bookingID, String bookDateTime, String returnDateTime,
                    String computerType, String assetTag, String studentID)
    {
        this.bookingID = bookingID;
        this.bookDateTime = bookDateTime;
        this.returnDateTime = returnDateTime;
        this.computerType = computerType;
        this.assetTag = Computer.getAssetTag();
        this.studentID = studentID;
    }


    public int getBookingID()
    {
        return bookingID;
    }

    public String getBookDateTime()
    {
        return bookDateTime;
    }

    public String getReturnDateTime()
    {
        return returnDateTime;
    }

    public String getComputerType()
    {
        return computerType;
    }

    public static String getAssetTag()
    {
        return assetTag;
    }

    public String getStudentID()
    {
        return studentID;
    }

    public static void printBookingsOneStudent()
    {
        //read in arraylist of bookings

        //check if the student id is anywhere in the file. If it is, print out that record
    }

    public static void returnComputer()
    {
        System.out.println("Please enter the asset tag of the Computer you would like to return");
        String returnTag = keyboard.nextLine();
        //read file + find assetTag
        //if(assetTag no there)
        {
            System.out.println("The asset tag you entered could not be found. Would you like to try again?\n1 - Yes\t2 - No");
            int ans = keyboard.nextInt();
            try
            {
                if(ans == 1)
                {
                    returnComputer();
                }
                else if(ans == 2)
                {
                    System.out.println("Returning you to the main menu...");
                }
            }
            catch(IllegalArgumentException e)
            {
                System.out.println(Colours.RED+"Selection out of range, try again"+Colours.RESET);
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println(Colours.RED+"Selection out of range, try again"+Colours.RESET);
            }
        }

    }

    public static void bookingLength()
    {

    }

    public static void findNumComputersBooked()
    {
        //read file
        //Check for types
        //If type = 1, 2, or 3, add one to a count of either
        //Return 40 - number of computers counted AND number of computers counted separately
    }

    @Override
    public String toString() {
        return "Bookings{" +
                "bookingID=" + bookingID +
                ", bookDateTime='" + bookDateTime + '\'' +
                ", returnDateTime='" + returnDateTime + '\'' +
                ", computerType='" + computerType + '\'' +
                ", assetTag='" + assetTag + '\'' +
                ", studentID='" + studentID + '\'' +
                '}';
    }
}
