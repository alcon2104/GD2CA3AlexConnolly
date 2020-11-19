package com.dkit.gd2.alexconnolly;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Menus with Enums
 *
 */
public class App 
{
    private static Scanner keyboard = new Scanner(System.in);
    public static void main( String[] args )
    {
        System.out.println("Welcome to the computer booking system!\nSelect one of the options below:");

        MenuOptions selected = MenuOptions.CONTINUE;
        while(selected != MenuOptions.QUIT)
        {
            try
            {
                menu();
                selected = MenuOptions.values()[Integer.parseInt(keyboard.nextLine().trim())];

                switch(selected)
                {
                    case ADD_STUDENT:
                            Student.addStudent();
                            break;
                    case EDIT_STUDENT:
                            Student.editStudent();
                            break;
                    case ADD_BOOKING:
                            Bookings.addBooking();
                            break;
                    case EDIT_BOOKING:
                            Bookings.editBooking();
                            break;
                    case PRINT_BOOKINGS:
                            Bookings.printBookings();
                            break;
                    case PRINT_BOOKINGS_STUDENT:
                            Bookings.printBookingsOneStudent();
                            break;
                    case RETURN_COMPUTER:
                            Bookings.returnComputer();
                            break;
                    case RETURN_BOOKING_LENGTH:
                            Bookings.bookingLength();
                            break;
                    case PRINT_BOOKED_MACHINES:
                            Bookings.findNumComputersBooked();
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

    private static void menu()
    {
        System.out.println("1. Add Student\t\t\t\t2. Edit Student\n3. Add Booking\t\t\t\t4. Edit Booking\n" +
                "5. Print all bookings\t\t6. Print bookings for one student\n7. Return a computer\t\t8. Return average booking lenght\n" +
                "9. Find number of Desktops, Laptops and Raspberry Pis booked to date\n10. Quit");
        System.out.println("\nSelection -> ");

    }
}
