package com.dkit.gd2.alexconnolly;

public class Desktop extends Computer
{
    private Monitor desktopMonitor;


    public Desktop(String manufacturer, String processor, int ramSize, int diskSize, double weight,
                   String assetTag, String purchaseDate, Monitor desktopMonitor)
    {
        super(manufacturer, processor, ramSize, diskSize, weight, assetTag, purchaseDate);
        this.desktopMonitor = desktopMonitor;

    }
    public Monitor getDesktopMonitor()
    {
        return desktopMonitor;
    }
}
