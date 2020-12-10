package com.dkit.gd2.alexconnolly;

import java.io.*;
import java.util.*;

/**
 * Menus with Enums
 *
 */
public class App {

    private static Scanner keyboard = new Scanner(System.in);
    public static void main( String[] args )
    {
        App playerDBApp = new App();
        playerDBApp.start();
    }

    private void start()
    {
        System.out.println("This is an application!");
        StudentDB studentDB = new StudentDB();
        BookingsDB bookingsDB = new BookingsDB();
        ComputersDB computersDB = new ComputersDB();
        studentDB.loadStudentsFromFile();
        BookingsDB.loadBookingsFromFile();
        ComputersDB.loadComputersFromFile();
        doMainMenuLoop(studentDB, bookingsDB, computersDB);
        StudentDB.saveStudentsToFile();
        BookingsDB.saveBookingsToFile();
    }

    private void doMainMenuLoop(StudentDB studentDB, BookingsDB bookingsDB, ComputersDB computersDB)
    {
        System.out.println(Colours.GREEN+"Welcome to the Student Computer Bookings Application (SCMA)!"+Colours.RESET);
        boolean loop = true;
        MenuOptions menuChoice;
        int selected;
        while(loop)
        {
            printMainMenu();
            try {
                selected = keyboard.nextInt();
                keyboard.nextLine();
                menuChoice = MenuOptions.values()[selected];

                switch (menuChoice) {
                    case QUIT:
                        loop = false;
                        break;
                    case STUDENT_MENU:
                        System.out.println("Calling student menu");
                        studentMenu();
                        break;
                    case BOOKINGS_MENU:
                        bookingsMenu();
                        break;
                    default:
                        System.out.println("Selection out of range, please try again");
                }
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Selection out of range, try again");
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Selection out of range, try again");
            }
        }
        System.out.println(Colours.GREEN+"Thank you for using the SCMA!"+Colours.RESET);
    }

    public static void studentMenu() {
        System.out.println(Colours.GREEN+"Welcome to the Student menu!\nSelect one of the options below:"+Colours.RESET);
        boolean loop = true;
        StudentMenuOptions menuChoice;
        int selected;
        while(loop)
        {
            printStudentMenu();
            try {
                selected = keyboard.nextInt();
                keyboard.nextLine();
                menuChoice = StudentMenuOptions.values()[selected];
                StudentDB studentDB = new StudentDB();
                switch (menuChoice) {
                    case QUIT:
                        loop = false;
                        break;
                    case ADD_STUDENT:
                        studentDB.addNew();
                        break;
                    case EDIT_STUDENT:
                        studentDB.edit();
                        break;
                    case DELETE_STUDENT:
                        studentDB.delete();
                        break;
                    case PRINT_STUDENT:
                        studentDB.print();
                        break;
                    default:
                        System.out.println("Selection out of range, please try again");
                        System.out.println(menuChoice);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Selection out of range, try again");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Selection out of range, try again");
            }
        }
        System.out.println(Colours.GREEN+"Returning to the main menu..."+Colours.RESET);
    }

    public static void bookingsMenu() {
        System.out.println(Colours.GREEN+"Welcome to the Bookings menu!\nSelect one of the options below:"+Colours.RESET);
        boolean loop = true;
        BookingMenuOptions menuChoice;
        int selected;
        while(loop)
        {
            printBookingsMenu();
            try {
                selected = keyboard.nextInt();
                keyboard.nextLine();
                menuChoice = BookingMenuOptions.values()[selected];
                BookingsDB bookingsDB = new BookingsDB();
                switch (menuChoice) {
                    case QUIT:
                        loop = false;
                        break;
                    case ADD_BOOKING:
                        bookingsDB.addNew();
                        break;
                    case EDIT_BOOKING:
                        bookingsDB.edit();
                        break;
                    case DELETE_BOOKING:
                        bookingsDB.delete();
                        break;
                    case PRINT_BOOKINGS:
                        bookingsDB.print();
                        break;
                    case PRINT_BOOKINGS_STUDENT:
                        BookingsDB.printBookingsOneStudent();
                        break;
                    case RETURN_COMPUTER:
                        //BookingsDB.returnComputer();
                    case RETURN_BOOKING_LENGTH:
                        //BookingsDB.bookingLength();
                    case PRINT_BOOKED_MACHINES:
                        BookingsDB.findNumComputersBooked();
                        break;
                    default:
                        System.out.println(Colours.RED+"Selection out of range, please try again"+Colours.RESET);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(Colours.RED+"Selection out of range, please try again"+Colours.RESET);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(Colours.RED+"Selection out of range, please try again"+Colours.RESET);
            }
        }
        System.out.println(Colours.GREEN+"Returning to the main menu..."+Colours.RESET);
    }

    private static void printMainMenu()
    {
        System.out.println("\nOptions to select:");
        for (int i = 0; i < MenuOptions.values().length; i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + MenuOptions.values()[i].toString() +
                    Colours.RESET);

        }
        System.out.print("Enter a number to select the options (0 to quit):>");
    }

    private static void printStudentMenu() {
        System.out.println("\nOptions to select:");
        for (int i = 0; i < StudentMenuOptions.values().length; i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + StudentMenuOptions.values()[i].toString() +
                    Colours.RESET);
        }
        System.out.print("Enter a number to select the options (0 to quit):>");
    }

    private static void printBookingsMenu() {
        System.out.println("\nOptions to select:");
        for (int i = 0; i < BookingMenuOptions.values().length; i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + BookingMenuOptions.values()[i].toString() +
                    Colours.RESET);
        }
        System.out.print("Enter a number to select the options (0 to quit):>");
    }
}
