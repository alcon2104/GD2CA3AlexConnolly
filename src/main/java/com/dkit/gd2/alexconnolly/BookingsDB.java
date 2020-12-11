package com.dkit.gd2.alexconnolly;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BookingsDB implements RecordChanges {
    private static ArrayList<Bookings> bookings;
    private static Scanner keyboard = new Scanner(System.in);

    public BookingsDB() {
        this.bookings = bookings;
    }

    public void loadBookingsFromFile()
    {
        try (Scanner bookingFile = new Scanner(new BufferedReader(new FileReader("Bookings.txt"))))
        {
            while (bookingFile.hasNextLine())
            {
                String input = bookingFile.nextLine();
                String[] data = input.split(",");
                int bookingID = Integer.parseInt(data[0]);
                String bookingDate = data[1];
                String returnDate = data[3];
                String computerType = data[4];
                String assetTag = data[5];
                String studentID = data[6];

                Bookings booking = new Bookings(bookingID, bookingDate, returnDate, computerType, assetTag, studentID);
                bookings.add(booking);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(Colours.PURPLE + "Could not load bookings; if this is the first time running the application then this might be fine." + Colours.RESET);
        }
    }

    public static void saveBookingsToFile()
    {
        try (BufferedWriter bookingFile = new BufferedWriter(new FileWriter("Bookings.txt")))
        {
            for (Bookings bookings : bookings)
            {
                bookingFile.write(bookings.getBookingID() + bookings.getBookDate() + bookings.getReturnDate() + bookings.getComputerType() +
                        bookings.getAssetTag() + bookings.getStudentID());
                bookingFile.write("\n");
            }

        }
        catch (IOException e)
        {
            System.out.println(Colours.RED + "Bookings could not be saved" + Colours.RESET);
        }
    }

    @Override
    public void addNew()
    {
        if (bookings != null)
        {
            System.out.println("Please Enter the new Booking's details below, after every new detail, please press enter");
            int newID = generateNewID();
            System.out.println("\nBooking Date + Time:>");
            String newBookDateTime = keyboard.nextLine();
            String newReturnDateTime = " ";
            System.out.println("\nComputer Type:>");
            String newType = keyboard.nextLine();
            String newTag = generateAssetTag();
            System.out.println("Student ID:>");
            String newStudID = keyboard.nextLine();


            try
            {
                for (int i = 0; i < bookings.size(); i++)
                {
                    if (newStudID != bookings.get(i).getStudentID())
                    {
                        System.out.println("This student ID doesn't exist - would you like to create a new student entry?\n1-Yes\t2-No");
                        int ans = keyboard.nextInt();
                        if (ans == 1)
                        {
                            Bookings newBooking = new Bookings(newID, newBookDateTime, newReturnDateTime, newType, newTag, newStudID);
                            bookings.add(newBooking);
                            System.out.println("Your Booking has been saved! Taking you to the AddStudent section...");
                            StudentDB studentDB = new StudentDB();
                            studentDB.addNew();
                        }
                        else if (ans == 2)
                        {
                            System.out.println("Sorry - we can't book computers for students that don't exist. Please try again");
                        }
                    }
                }
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Please select either 1 or 2 as your answer");
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Please select either 1 or 2 as your answer");
            }
        }
    }

    public static String generateAssetTag()
    {
        if (Computer.getAssetTag() == null)
        {
            Random rand = new Random();
            int lowerBound = 10000;
            int higherBound = 99999;
            String newAssetTag = "DKIT-" + rand.nextInt(higherBound - lowerBound);
            System.out.println(newAssetTag);
            //computers arraylist
            for (int i = 0; i < bookings.size(); i++)
            {
                if (newAssetTag == bookings.get(i).getAssetTag())
                {
                    generateAssetTag();
                }
            }
            return newAssetTag;
        }
        return null;
    }


    @Override
    public void edit()
    {
        if(bookings != null)
        {
            System.out.println("Enter the ID of the booking you wish to edit");
            int editID = keyboard.nextInt();
            System.out.println("Select the entry you'd like to change\n0 - Quit\t1 - ID \t2 - Book date/time\t3 - Return date/time\n4 - Computer type\t5 - Asset tag\t6 - Student ID");
            boolean loop = true;
            EditBookingOptions menuChoice;
            int selected;
            while(loop)
            {
                selected = keyboard.nextInt();
                keyboard.nextLine();
                menuChoice = EditBookingOptions.values()[selected];
                try
                {
                    switch (menuChoice)
                    {
                        case QUIT:
                            loop = false;
                            break;
                        case ID:
                            for (int i = 0; i <= bookings.size(); i++)
                            {
                                if (bookings.get(i).getBookingID() == editID)
                                {
                                    System.out.println("Enter the new ID");
                                    int newID = keyboard.nextInt();
                                    bookings.get(i).setBookingID(newID);
                                }
                                System.out.println("Edit Successful.");
                                System.out.println("Returning you to the Booking menu...");
                            }

                        case BOOK_DATE:
                            for (int i = 0; i <= bookings.size(); i++)
                            {
                                if (bookings.get(i).getBookingID() == editID)
                                {
                                    System.out.println("Enter the new Booking Date");
                                    String newDate = keyboard.nextLine();
                                    bookings.get(i).setBookDate(newDate);
                                }
                                System.out.println("Edit Successful.");
                                System.out.println("Returning you to the Booking menu...");
                            }

                        case RETURN_DATE:
                            for (int i = 0; i <= bookings.size(); i++)
                            {
                                if (bookings.get(i).getBookingID() == editID)
                                {
                                    System.out.println("Enter the new Return Date");
                                    String newDate = keyboard.nextLine();
                                    bookings.get(i).setReturnDate(newDate);
                                }
                                System.out.println("Edit Successful.");
                                System.out.println("Returning you to the Booking menu...");
                            }

                        case COMPUTER_TYPE:
                            for (int i = 0; i <= bookings.size(); i++)
                            {
                                if (bookings.get(i).getBookingID() == editID)
                                {
                                    System.out.println("Enter the new Computer Type");
                                    String newType = keyboard.nextLine();
                                    bookings.get(i).setComputerType(newType);
                                }
                                System.out.println("Edit Successful.");
                                System.out.println("Returning you to the Booking menu...");
                            }

                        case ASSET_TAG:
                            for (int i = 0; i <= bookings.size(); i++)
                            {
                                if (bookings.get(i).getBookingID() == editID)
                                {
                                    System.out.println("Enter the new Asset tag");
                                    String newTag = keyboard.nextLine();
                                    bookings.get(i).setBookDate(newTag);
                                }
                                System.out.println("Edit Successful.");
                                System.out.println("Returning you to the Booking menu...");
                            }

                        case STUDENT_ID:
                            for (int i = 0; i <= bookings.size(); i++)
                            {
                                if (bookings.get(i).getBookingID() == editID)
                                {
                                    System.out.println("Enter the new Student ID");
                                    String newID = keyboard.nextLine();
                                    bookings.get(i).setBookDate(newID);
                                }
                                System.out.println("Edit Successful.");
                                System.out.println("Returning you to the Booking menu...");
                            }

                    }
                    System.out.println("Returning you to the Bookings menu...");
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
    }

    @Override
    public void delete()
    {
        if (bookings != null)
        {
            System.out.println("Enter the asset tag of the booking you wish to delete");
            String deleteID = keyboard.nextLine();
            try
            {
                System.out.println(Colours.RED + "Are you sure you want to delete the Booking?\n1 - Yes\t2 - No" + Colours.RESET);
                int delete = keyboard.nextInt();
                if (delete == 1)
                {
                    for (int i = 0; i <= bookings.size(); i++)
                    {
                        if (bookings.get(i).getAssetTag() == deleteID)
                        {
                            bookings.remove(bookings.get(i));
                        }
                        System.out.println("The booking has been deleted.");
                        System.out.println("Returning you to the Booking menu...");
                    }
                }
                else if (delete == 2)
                {
                    System.out.println("Returning you to the Booking menu...");
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

    @Override
    public void print()
    {
        if(bookings != null) {
            for (int i = 0; i < bookings.size(); i++) {
                System.out.println(bookings.get(i).toString());
            }
        }
    }

    public static int generateNewID()
    {
        if(bookings != null)
        {
            Random rand = new Random();
            int lowerBound = 10;
            int higherBound = 99;
            int newID = rand.nextInt(higherBound - lowerBound);
            for (int i = 0; i <= bookings.size(); i++)
            {
                if (bookings.get(i).getBookingID() != newID)
                {
                    generateNewID();
                }
            }
            return newID;

        }
        return 0;
    }

    public static void printBookingsOneStudent()
    {
        if(bookings != null)
        {
            System.out.println("Enter the ID of a student you would like to view the bookings of");
            String printID = keyboard.nextLine();
            for (int i = 0; i < bookings.size(); i++)
            {
                if (bookings.get(i).getStudentID().equals(printID))
                {
                    System.out.println(bookings.get(i).toString());
                }
            }
        }
    }

//    public static void returnComputer()
//    {
//        System.out.println("Please enter the asset tag of the Computer you would like to return");
//        String returnTag = keyboard.nextLine();
//        try{
//            for (int i = 0; i < bookings.size(); i++)
//            {
//                if (bookings.get(i).getAssetTag().equals(returnTag))
//                {
//                    LocalDate today = LocalDate.now();
//                    bookings.get(i).setReturnDate(today);
//                    System.out.println("Computer returned!");
//                    System.out.println("Returning you to the main menu...");
//                }
//            }
//        }
//        catch(IllegalArgumentException e)
//        {
//            System.out.println(Colours.RED+"Selection out of range, try again"+Colours.RESET);
//        }
//        catch(ArrayIndexOutOfBoundsException e)
//        {
//            System.out.println(Colours.RED+"Selection out of range, try again"+Colours.RESET);
//        }
//    }

    public static void bookingLength()
    {

    }

    public static void findNumComputersBooked()
    {
        if(bookings != null)
        {
            int countLaptop = 0;
            int countDesktop = 0;
            int countPi = 0;

            for (int i = 0; i < bookings.size(); i++)
            {
                if (bookings.get(i).getComputerType().equals("Laptop"))
                {
                    countLaptop++;
                } else if (bookings.get(i).getComputerType().equals("Desktop"))
                {
                    countLaptop++;
                } else {
                    countPi++;
                }
                System.out.println("There are " + countLaptop + " laptops, " + countDesktop + " desktops and " + countPi + " Raspberry Pis currently being booked");
            }
        }
    }
}
