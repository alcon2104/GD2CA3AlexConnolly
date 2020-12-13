package com.dkit.gd2.alexconnolly;

import java.awt.print.Book;
import java.io.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BookingsDB implements RecordChanges {
    private static ArrayList<Booking> bookings;
    private static Scanner keyboard = new Scanner(System.in);

    public BookingsDB() {
        this.bookings = new ArrayList<>();
    }

    public void loadBookingsFromFile()
    {
        try (Scanner bookingFile = new Scanner(new BufferedReader(new FileReader("Bookings.txt"))))
        {
            String input;
            while (bookingFile.hasNextLine())
            {
                input = bookingFile.nextLine();
                String[] data = input.split(",");
                int bookingID = Integer.parseInt(data[0]);
                String bookingDate = data[1];
                String returnDate = data[2];
                String computerType = data[3];
                String assetTag = data[4];
                String studentID = data[5];

                Booking booking = new Booking(bookingID, bookingDate, returnDate, computerType, assetTag, studentID);
                this.bookings.add(booking);
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
            for (Booking booking : bookings)
            {
                bookingFile.write(booking.getBookingID()+","+booking.getBookDate()+","+booking.getReturnDate()+","+booking.getComputerType()+","+
                        booking.getAssetTag()+","+booking.getStudentID());
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
            System.out.println("\nBooking Date:>");
            String newBookDate = keyboard.nextLine();
            String newReturnDate = " ";
            System.out.println("\nComputer Type:>");
            String newType = keyboard.nextLine();
            String newTag = generateAssetTag();
            System.out.println("Student ID:>");
            String newStudID = keyboard.nextLine();
            Booking newBooking = new Booking(newID, newBookDate, newReturnDate, newType, newTag, newStudID);
            bookings.add(newBooking);
            System.out.println("Your Booking has been saved!");
            System.out.println("Returning you to the booking menu...");
        }
    }

    public static String generateAssetTag()
    {
        if (Computer.getAssetTag() == null)
        {
            Random rand = new Random();
            int lowerBound = 100;
            int higherBound = 999;
            String newAssetTag = "DKIT" + rand.nextInt(higherBound - lowerBound);
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
            System.out.println("Enter the asset tag of the booking you wish to edit");
            String editTag = keyboard.nextLine();
            Booking bookingToEdit = findBooking(editTag);
            System.out.println("Select the entry you'd like to change\n0 - Quit\t1 - ID \t2 - Book date\t3 - Return date\n4 - Computer type\t5 - Asset tag\t6 - Student ID");
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
                            System.out.println("Enter the new ID");
                            int newID = keyboard.nextInt();
                            bookingToEdit.setBookingID(newID);
                            System.out.println("Edit Successful.");
                            loop = false;
                            break;

                        case BOOK_DATE:
                            System.out.println("Enter the new booking date");
                            String newDate = keyboard.nextLine();
                            bookingToEdit.setBookDate(newDate);
                            System.out.println("Edit Successful.");
                            loop = false;
                            break;

                        case RETURN_DATE:
                            System.out.println("Enter the new booking date");
                            String newReturnDate = keyboard.nextLine();
                            bookingToEdit.setReturnDate(newReturnDate);
                            System.out.println("Edit Successful.");
                            loop = false;
                            break;

                        case COMPUTER_TYPE:
                            System.out.println("Enter the new booking date");
                            String newType = keyboard.nextLine();
                            bookingToEdit.setComputerType(newType);
                            System.out.println("Edit Successful.");
                            loop = false;
                            break;

                        case ASSET_TAG:
                            System.out.println("Enter the new booking date");
                            String newTag = keyboard.nextLine();
                            bookingToEdit.setAssetTag(newTag);
                            System.out.println("Edit Successful.");
                            loop = false;
                            break;

                        case STUDENT_ID:
                            System.out.println("Enter the new booking date");
                            String newStudID = keyboard.nextLine();
                            bookingToEdit.setStudentID(newStudID);
                            System.out.println("Edit Successful.");
                            loop = false;
                            break;
                    }
                    System.out.println("Returning you to the bookings menu...");
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
            String deleteTag = keyboard.nextLine();
            try
            {
                System.out.println(Colours.RED + "Are you sure you want to delete the Booking?\n1 - Yes\t2 - No" + Colours.RESET);
                int delete = keyboard.nextInt();
                keyboard.nextLine();
                if (delete == 1)
                {
                    if(bookings != null)
                    {
                        Booking bookingToDelete = findBooking(deleteTag);
                        if (bookingToDelete != null)
                        {
                            bookings.remove(bookingToDelete);
                            System.out.println("The booking has been deleted.");
                            System.out.println("Returning you to the Booking menu...");
                        }
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
            for (int i = 0; i < bookings.size(); i++)
            {
                System.out.println(bookings.get(i).toString());
            }
        }
        System.out.println("Returning you to the bookings menu...");
    }

    public int generateNewID()
    {
        if(bookings != null)
        {
            Random rand = new Random();
            int lowerBound = 10;
            int higherBound = 99;
            int newID = rand.nextInt(higherBound - lowerBound);
            return newID;

        }
        return 00;
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
            System.out.println("Returning you to the bookings menu...");
        }
    }

    public void returnComputer()
    {
        System.out.println("Please enter the asset tag of the Computer you would like to return");
        String returnTag = keyboard.nextLine();
        try{
            Booking returnBooking = findBooking(returnTag);
            for (int i = 0; i < bookings.size(); i++)
            {
                if (bookings.get(i).getReturnDate() == null)
                {
                    returnBooking.setReturnDate(LocalDate.now().toString());
                    System.out.println("Computer returned!");
                    System.out.println("Returning you to the bookings menu...");
                }
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

    public static void bookingLength()
    {
        long countDays = 0;
        int countBookings = 0;
        for(int i = 0; i < bookings.size(); i++)
        {
            if(bookings.get(i).getReturnDate() == null)
            {
                LocalDate start = LocalDate.parse(bookings.get(i).getBookDate());
                LocalDate end = LocalDate.parse(bookings.get(i).getReturnDate());

                long difference = Duration.between(start, end).toMillis();
                long millisInDay = 1000 * 60 * 60 * 24;
                long days = difference / millisInDay;

                countDays = countDays + days;
                countBookings++;
            }
        }
        double averageLength = countBookings/countDays;
        System.out.println("The average length of computer bookings is " +Colours.GREEN+averageLength+Colours.RESET+" days.");
        System.out.println("Returning you to the bookings menu...");
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
            }
            System.out.println("There are " + countLaptop + " laptops, " + countDesktop + " desktops and " + countPi + " Raspberry Pis currently being booked");
            System.out.println("Returning you to the bookings menu...");
        }
    }

    private Booking findBooking(String assetTag)
    {
        for (Booking booking : bookings)
        {
            if (booking.getAssetTag().equals(assetTag))
            {
                return booking;
            }
        }
        return null;
    }
}
