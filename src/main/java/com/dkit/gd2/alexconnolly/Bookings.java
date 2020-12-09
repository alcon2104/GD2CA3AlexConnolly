package com.dkit.gd2.alexconnolly;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Bookings
{
    private static Scanner keyboard = new Scanner(System.in);

    private int bookingID;
    private String bookDate;
    private String returnDate;
    private String computerType;
    private String assetTag;
    private String studentID;

    public Bookings(int bookingID, String bookDate, String returnDate,
                    String computerType, String assetTag, String studentID)
    {
        this.bookingID = bookingID;
        this.bookDate = bookDate;
        this.returnDate = returnDate;
        this.computerType = computerType;
        this.assetTag = Computer.getAssetTag();
        this.studentID = studentID;
    }


    public int getBookingID()
    {
        return bookingID;
    }

    public String getBookDate()
    {
        return bookDate;
    }

    public String getReturnDate()
    {
        return returnDate;
    }

    public String getComputerType()
    {
        return computerType;
    }

    public String getAssetTag()
    {
        return assetTag;
    }

    public String getStudentID()
    {
        return studentID;
    }


    public void setBookingID(int bookingID)
    {
        this.bookingID = bookingID;
    }

    public void setBookDate(String bookDate)
    {
        this.bookDate = bookDate;
    }

    public void setReturnDate(String returnDate)
    {
        this.returnDate = returnDate;
    }

    public void setComputerType(String computerType)
    {
        this.computerType = computerType;
    }

    public void setAssetTag(String assetTag)
    {
        this.assetTag = assetTag;
    }

    public void setStudentID(String studentID)
    {
        this.studentID = studentID;
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
        int numDays = 0;
        for(int i = 0; i < bookings.size(); i++)
        {
            LocalDate.parse(bookings.getBookingDate());
            if(bookings.getReturnDate != null)
            {
                LocalDate.parse(bookings.getReturnDate());
            }
            
        }
    }

    public static void findNumComputersBooked()
    {
        int countLaptop = 0;
        int countDesktop = 0;
        int countPi = 0;

        for(int i = 0; i < bookings.size(); i++)
        {
            if(bookings.get(i).getComputerType() = "Laptop")
            {
                countLaptop++;
            }
            else if(bookings.get(i).getComputerType() = "Desktop")
            {
                countLaptop++;
            }
            else
            {
                countPi++;
            }
            System.out.println("There are " +countLaptop+ " laptops, " +countDesktop+ " desktops and " +countPi+ " Raspberry Pis currently being booked");
        }
    }

    @Override
    public String toString() {
        return "Bookings{" +
                "bookingID=" + bookingID +
                ", bookDateTime='" + bookDate + '\'' +
                ", returnDateTime='" + returnDate + '\'' +
                ", computerType='" + computerType + '\'' +
                ", assetTag='" + assetTag + '\'' +
                ", studentID='" + studentID + '\'' +
                '}';
    }
}
