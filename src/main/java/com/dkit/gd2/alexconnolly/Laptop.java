package com.dkit.gd2.alexconnolly;

public class Laptop extends Computer
{
    private int screenSize;
    private int batteryLifeHrs;


    public Laptop(String manufacturer, String processor, int ramSize,
    int diskSize, double weight, String assetTag, String purchaseDate, int screenSize, int batteryLifeHrs) {
        super(manufacturer, processor, ramSize, diskSize, weight, assetTag, purchaseDate);
        this.screenSize =  screenSize;
        this.batteryLifeHrs = batteryLifeHrs;
    }

    public int getScreenSize()
    {
        return screenSize;
    }

    public int getBatteryLifeHrs()
    {
        return batteryLifeHrs;
    }
}

