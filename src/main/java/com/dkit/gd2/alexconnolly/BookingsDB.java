package com.dkit.gd2.alexconnolly;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BookingsDB
{
    private ArrayList<Bookings> bookings;
    private static Scanner keyboard = new Scanner(System.in);

    public BookingsDB()
    {
        this.bookings = bookings;
    }

    public static void loadBookingsFromFile() {
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
}
