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
        this.assetTag = assetTag;
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

    public void newBooking()
    {

    }

    public void editBooking()
    {

    }

    public void printAllBookings()
    {

    }

    public void printAllBookingsOrderedForStudent()
    {

    }

    public void returnComputer()
    {

    }

    public void bookingLength()
    {

    }

    public void numComputersBooked()
    {

    }
}
