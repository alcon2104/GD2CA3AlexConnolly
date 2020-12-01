package com.dkit.gd2.alexconnolly;

import java.io.*;
import java.util.*;

/**
 * Menus with Enums
 *
 */
public class App 
{
    private static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("Welcome to the computer booking system!\nSelect one of the options below:");

        MenuOptions selected = MenuOptions.CONTINUE;
        while(selected != MenuOptions.QUIT)
        {
            try
            {
                printMenu();
                selected = MenuOptions.values()[Integer.parseInt(keyboard.nextLine().trim())];

                switch(selected)
                {
                    case STUDENT_MENU:
                            Student.addStudent();
                            break;
                    case BOOKINGS_MENU:
                            Bookings.addBooking();
                            break;
                    case QUIT:
                        System.out.println("Thank you for using the computer booking system.\nHave a nice day!");
                        break;
                    default:
                        System.out.println("Selection out of range, please try again");
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

    public static void studentMenu()
    {
        System.out.println("Welcome to the Student menu!\nSelect one of the options below:");

        StudentMenuOptions selected = StudentMenuOptions.CONTINUE;
        while(selected != StudentMenuOptions.QUIT)
        {
            try
            {
                printStudentMenu();
                selected = StudentMenuOptions.values()[Integer.parseInt(keyboard.nextLine().trim())];

                switch(selected)
                {
                    case ADD_STUDENT:
                        Student.addStudent();
                    case EDIT_STUDENT:
                        Student.editStudent();
                    case DELETE_STUDENT:
                        Student.deleteStudent();
                    case PRINT_STUDENT:
                        Student.printStudent();
                    case QUIT:
                        System.out.println("Taking you back to the main menu...");
                        break;
                    default:
                        System.out.println("Selection out of range, please try again");
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

    public static void bookingsMenu()
    {
        System.out.println("Welcome to the Bookings menu!\nSelect one of the options below:");

        BookingMenuOptions selected = BookingMenuOptions.CONTINUE;
        while(selected != BookingMenuOptions.QUIT)
        {
            try
            {
                printBookingsMenu();
                selected = BookingMenuOptions.values()[Integer.parseInt(keyboard.nextLine().trim())];

                switch(selected)
                {
                    case ADD_BOOKING:
                        Bookings.addBooking();
                    case EDIT_BOOKING:
                        Bookings.editBooking();
                    case DELETE_BOOKING:
                        Bookings.deleteBooking();
                    case PRINT_BOOKINGS:
                        Bookings.printBookings();
                    case PRINT_BOOKINGS_STUDENT:
                        Bookings.printBookingsOneStudent();
                    case RETURN_COMPUTER:
                        Bookings.returnComputer();
                    case RETURN_BOOKING_LENGTH:
                        Bookings.bookingLength();
                    case PRINT_BOOKED_MACHINES:
                        Bookings.findNumComputersBooked();
                    case QUIT:
                        System.out.println("Taking you back to the main menu...");
                        break;
                    default:
                        System.out.println("Selection out of range, please try again");
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

    private static void printMenu()
    {
        System.out.println("1. Add Student\t\t\t\t2. Edit Student\n3. Add Booking\t\t\t\t4. Edit Booking\n" +
                "5. Print all bookings\t\t6. Print bookings for one student\n7. Return a computer\t\t8. Return average booking lenght\n" +
                "9. Find number of Desktops, Laptops and Raspberry Pis booked to date\n10. Quit");
        System.out.println("\nSelection -> ");

    }

    private static void printStudentMenu()
    {
        System.out.println("1. Add Student\t\t\t\t2. Edit Student\n3. Delete Student\t\t\t\t4. Print Student\n" + "5 Quit");
        System.out.println("\nSelection -> ");
    }

    private static void printBookingsMenu()
    {
        System.out.println("1. Add Booking\t\t\t\t2. Edit Booking\t\t\t\t3. Delete Booking\n4. Print Bookings\t\t\t\t5.Print Bookings for one student" +
                "\t\t\t\t6.Return a computer\n7. Return average booking length\t\t\t\t8.Find number of Desktops, Laptops and Raspberry Pis booked to date\n9. Quit");
        System.out.println("\nSelection -> ");
    }

    public static void readFile(String section)
    {
        try(Scanner bookFile = new Scanner(new BufferedReader(new FileReader("StudentBookings.txt"))))
        {
            while(bookFile.hasNextLine())
            {
                section.toLowerCase();
                String input = bookFile.nextLine();
                String[] data = input.split(",");
                if(section == "student")
                {
                    String name = data[0];
                    String ID = data[1];
                    String email = data[2];
                    String telephone = data[3];
                    //ArrayList loans = data[4];
                }

                else if(section == "Computer")
                {
                    String manufacturer = data[0];
                    String processor = data[1];
                    int ramSize = Integer.parseInt(data[2]);
                    int diskSize = Integer.parseInt(data[3]);
                    double weight = Double.parseDouble(data[4]);
                    String assetTag = data[5];
                    String purchaseDate = data[6];
                }

                else if(section == "Bookings")
                {
                    int bookingID = Integer.parseInt(data[0]);
                    String bookDateTime = data[1];
                    String returnDateTime = data[2];
                    String computerType = data[3];
                    String assetTag = data[4];
                    String studentID = data[5];
                }
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private void readFromFile(String fileName, String section)
    {
        try(Scanner fileScanner = new Scanner(new BufferedReader(new FileReader("StudentBookings.txt"))))
        {

            while(fileScanner.hasNextLine())
            {
                String input = fileScanner.nextLine();
                String[] data = input.split(",");
                if(section == "student")
                {
                    String name = data[0];
                    String ID = data[1];
                    String email = data[2];
                    String telephone = data[3];
                    //ArrayList loans = data[4];
                }

                else if(section == "Computer")
                {
                    String manufacturer = data[0];
                    String processor = data[1];
                    int ramSize = Integer.parseInt(data[2]);
                    int diskSize = Integer.parseInt(data[3]);
                    double weight = Double.parseDouble(data[4]);
                    String assetTag = data[5];
                    String purchaseDate = data[6];
                }

                else if(section == "Bookings")
                {
                    int bookingID = Integer.parseInt(data[0]);
                    String bookDateTime = data[1];
                    String returnDateTime = data[2];
                    String computerType = data[3];
                    String assetTag = data[4];
                    String studentID = data[5];
                }
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static void writeToFile()
    {
        try(BufferedWriter StudBookingsFile = new BufferedWriter(new FileWriter("StudentBookings.txt"));)
        {
            for(Student student: students.values())
            {
                StudBookingsFile.write(Student.getName(), Student.getID(), Student.getEmail(), Student.getTelephone(), Student.getLoans());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
