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

//    public static void bookingLength()
//    {
//        int numDays = 0;
//        for(int i = 0; i < bookings.size(); i++)
//        {
//            LocalDate.parse(bookings.getBookingDate());
//            if(bookings.getReturnDate != null)
//            {
//                LocalDate.parse(bookings.getReturnDate());
//            }
//
//        }
//    }



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
