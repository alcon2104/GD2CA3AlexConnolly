package com.dkit.gd2.alexconnolly;

public class Bookings
{
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
        this.studentID = Student.getID();
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

    public static void addBooking() {
    }

    public static void editBooking()
    {

    }

    public static void printBookings()
    {

    }

    public static void printBookingsOneStudent()
    {

    }

    public static void returnComputer()
    {

    }

    public static void bookingLength()
    {

    }

    public static void findNumComputersBooked()
    {

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
