package com.dkit.gd2.alexconnolly;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedDeque;

public class BookingsDB implements RecordChanges
{
    private static ArrayList<Bookings> bookings;
    private static Scanner keyboard = new Scanner(System.in);

    public BookingsDB()
    {
        this.bookings = bookings;
    }

    public static void loadBookingsFromFile()
    {
        try (Scanner bookingFile = new Scanner(new BufferedReader(new FileReader("Bookings.txt"))))
        {
            while (bookingFile.hasNextLine()) {
                String input = bookingFile.nextLine();
                String[] data = input.split(",");
                int bookingID = Integer.parseInt(data[0]);
                String bookingDateTime = data[1];
                String returnDateTime = data[3];
                String computerType = data[4];
                String assetTag = data[5];
                String studentID = data[6];

                ArrayList booking = new ArrayList<>();
                booking.add(bookingID);
                booking.add(bookingDateTime);
                booking.add(returnDateTime);
                booking.add(computerType);
                booking.add(assetTag);
                booking.add(studentID);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(Colours.PURPLE+"Could not load bookings; if this is the first time running the application then this might be fine."+Colours.RESET);
        }
    }

    public static void saveBookingsToFile(Bookings booking)
    {
        try (BufferedWriter bookingFile = new BufferedWriter(new FileWriter("Bookings.txt")))
        {
            for(int i = 0; i < bookings.size(); i++)
            {
                bookingFile.write(booking.getBookingID() + booking.getBookDateTime() + booking.getReturnDateTime() + booking.getComputerType() +
                        booking.getAssetTag() + booking.getStudentID());
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void addNew()
    {
        System.out.println("Please Enter the new Booking's details below, after every new detail, please press enter");
        int newID = generateNewID();
        System.out.println("\nBooking Date + Time:>");
        String newBookDateTime = keyboard.nextLine();
        String newReturnDateTime = " ";
        System.out.println("\nComputer Type:>");
        String newType = keyboard.nextLine();
        String newTag = Computer.generateAssetTag();
        System.out.println("Student ID:>");
        String newStudID = keyboard.nextLine();

        try
        {
            for(int i = 0; i < bookings.size(); i++)
            {
                if(newStudID != Bookings.getBookingID().getStudentID();
                       {
                            System.out.println("This student ID doesn't exist - would you like to create a new student entry?\n1-Yes\t2-No");
                            int ans = keyboard.nextInt();
                            if(ans== 1)
                            {
                                Bookings newBooking = new Bookings(newID, newBookDateTime, newReturnDateTime, newType, newTag, newStudID);
                                saveBookingsToFile(newBooking);
                                System.out.println("Your Booking has been saved! Taking you to the AddStudent section...");
                                StudentDB studentDB = new StudentDB();
                                studentDB.addNew();
                            }
                            else if(ans == 2)
                            {
                                System.out.println("Sorry - we can't book computers for students that don't exist. Please try again");
                            }
                       }
            }
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Please select either 1 or 2 as your answer");
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Please select either 1 or 2 as your answer");
        }
    }

    @Override
    public void edit()
    {
        System.out.println("Enter the ID of the booking you wish to edit");
        String ID = keyboard.nextLine();
        System.out.println("Select the entry you'd like to change\n0 - Quit\t1 - ID \t2 - Book date/time\t3 - Return date/time\n4 - Computer type\t5 - Asset tag\t6 - Student ID");
        boolean loop = true;
        EditBookingOptions menuChoice;
        int selected;
        while(loop) {
            selected = keyboard.nextInt();
            keyboard.nextLine();
            menuChoice = EditBookingOptions.values()[selected];
            try {
                switch (menuChoice) {
                    case QUIT:
                        loop = false;
                        break;
                    case ID:
                        System.out.println("Enter the new ID");
                        String newID = keyboard.nextLine();
                        bookings.getAssetTag().setID(newID);

                    case BOOK_DATE_TIME:
                        System.out.println("Enter the new Book date/time");
                        String newBook = keyboard.nextLine();
                        bookings.getAssetTag().setBookDateTime(newBook);

                    case RETURN_DATE_TIME:
                        System.out.println("Enter the new Return date/time");
                        String newReturn = keyboard.nextLine();
                        bookings.getAssetTag().setReturnDateTime(newReturn);

                    case COMPUTER_TYPE:
                        System.out.println("Enter the new Computer type");
                        String newType = keyboard.nextLine();
                        bookings.getAssetTag().setComputerType(newType);

                    case ASSET_TAG:
                        System.out.println("Enter the new asset tag");
                        String newTelephone = keyboard.nextLine();
                        bookings.getAssetTag().setTag(newTelephone);

                    case STUDENT_ID:
                        System.out.println("Enter the new Student ID");
                        String newStudID = keyboard.nextLine();
                        bookings.getAssetTag().setTelephone(newStudID);

                }
                System.out.println("Returning you to the Bookings menu...");
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

    @Override
    public void delete()
    {
        System.out.println("Enter the ID of the booking you wish to delete");
        String deleteID = keyboard.nextLine();
        try
        {
            System.out.println(Colours.RED+"Are you sure you want to delete the Booking?\n1 - Yes\t2 - No"+ Colours.RESET);
            int delete = keyboard.nextInt();
            if (delete == 1)
            {
                bookings.getAssetTag().remove();
                System.out.println("The booking has been deleted.");
                System.out.println("Returning you to the Booking menu...");
            }
            else if (delete == 2)
            {
                System.out.println("Returning you to the Booking menu...");
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

    @Override
    public void print()
    {
        for(int i = 0; i < bookings.size(); i++)
        {
            System.out.println(bookings.get(i).toString());
        }
    }

    public static int generateNewID()
    {
        Random rand = new Random();
        int lowerBound = 10;
        int higherBound = 99;
        int newID = rand.nextInt(higherBound - lowerBound);
        if(newID == Bookings.getBookingID()/*bookings ids*/)
        {
            generateNewID();
        }
        return newID;
    }
}
