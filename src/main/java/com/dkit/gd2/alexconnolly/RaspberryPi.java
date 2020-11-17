package com.dkit.gd2.alexconnolly;

public class RaspberryPi extends Computer
{
    private int numGPIOPins;
    private int sdStorage;


    public RaspberryPi(String manufacturer, String processor, int ramSize,
    int diskSize, double weight, String assetTag, String purchaseDate, int numGPIOPins, int sdStorage)
    {
        super(manufacturer, processor, ramSize, diskSize, weight, assetTag, purchaseDate);
        this.numGPIOPins = numGPIOPins;
        this.sdStorage = sdStorage;
    }

    public int getNumGPIOPins()
    {
        return numGPIOPins;
    }

    public int getSdStorage()
    {
        return sdStorage;
    }
}
