package com.dkit.gd2.alexconnolly;

import java.util.ArrayList;
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

    public String getAssetTag()
    {
        return assetTag;
    }

    public String getStudentID()
    {
        return studentID;
    }

    public static void addBooking()
    {
        //read file
        System.out.println("Please Enter the new Booking's details below, after every new detail, please press enter");
        int newID = keyboard.nextInt();
        String newBookDateTime = keyboard.nextLine();
        String newReturnDateTime = keyboard.nextLine();
        String newType = keyboard.nextLine();
        String newTag = keyboard.nextLine();
        String newStudID = keyboard.nextLine();

        //try()
        //{
            //if(newStudID != (any of the student ids in the text file)
            //        {
            //            System.out.println("This student ID doesn't exist - would you like to create a new student entry?\n1-Yes\t2-No");
            //            int ans = keyboard.nextInt();
            //            if(ans== 1)
            //            {
            //                Bookings newBooking = new Bookings(newID, newBookDateTime, newReturnDateTime, newType, newTag, newStudID);
            //                write to the file before taking the user to add a student
            //                System.out.println("Your Booking has been saved! Taking you to the AddStudent section...");
            //                Student.addStudent();
            //            }
            //            else if(ans == 2)
            //            {
            //                System.out.println("Sorry - we can't book computers for students that don't exist. Please try again");
            //            }
            //        }
        //}
        //catch(IllegalArgumentException e)
        //{
            //System.out.println("Please select either 1 or 2 as your answer");
        //}
        //catch(ArrayIndexOutOfBoundsException e)
        //{
           //System.out.println("Please select either 1 or 2 as your answer");
        //}
        System.out.println("Returning you to the main menu...");
    }

    public static void editBooking()
    {
        System.out.println("Enter the ID of the booking you wish to edit");
        String ID = keyboard.nextLine();
        try
        {
            System.out.println("Select the entry you'd like to change\n1 - ID \t2 - Book date/time\t3 - Return date/time\t4 - Computer type\n5 - Asset tag\t6 - Student ID");
            EditBookingOptions selected = EditBookingOptions.CONTINUE;
            selected = EditBookingOptions.values()[Integer.parseInt(keyboard.nextLine().trim())];
            switch (selected)
            {
                case ID:
                    System.out.println("Enter the new ID");
                    String newID = keyboard.nextLine();
                    //.getAssetTag().setID(newID);

                case BOOK_DATE_TIME:
                    System.out.println("Enter the new Book date/time");
                    String newBook = keyboard.nextLine();
                    //.getAssetTag().setBookDateTime(newBook);

                case RETURN_DATE_TIME:
                    System.out.println("Enter the new Return date/time");
                    String newReturn = keyboard.nextLine();
                    //.getAssetTag().setReturnDateTime(newReturn);

                case COMPUTER_TYPE:
                    System.out.println("Enter the new Computer type");
                    String newType = keyboard.nextLine();
                    //.getAssetTag().setComputerType(newType);

                case ASSET_TAG:
                    System.out.println("Enter the new asset tag");
                    String newTag = keyboard.nextLine();
                    //.getAssetTag().setTag(newTelephone);

                case STUDENT_ID:
                    System.out.println("Enter the new Student ID");
                    String newStudID= keyboard.nextLine();
                    //.getAssetTag().setTelephone(newStudID);

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

    public static void deleteBooking()
    {
        System.out.println("Enter the ID of the booking you wish to edit");
        String ID = keyboard.nextLine();
        try
        {
            System.out.println("Are you sure you want to delete the Booking?\n1 - Yes\t2 - No");
            int delete = keyboard.nextInt();
            if (delete == 1)
            {
                //delete the booking
                System.out.println("The booking has been deleted.");
                System.out.println("Returning you to the main menu...");
            }
            else if (delete == 2)
            {
                System.out.println("Returning you to the main menu...");
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

    public static void printBookings()
    {

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
                    //App.main();
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
