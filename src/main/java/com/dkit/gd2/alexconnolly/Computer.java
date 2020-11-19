package com.dkit.gd2.alexconnolly;

public class Computer
{
    private String manufacturer;
    private String processor;
    private int ramSize;
    private int diskSize;
    private double weight;
    private static String assetTag;
    private String purchaseDate;

    public Computer(String manufacturer, String processor, int ramSize,
    int diskSize, double weight, String assetTag, String purchaseDate)
    {
        this.manufacturer = manufacturer;
        this.processor = processor;
        this.ramSize = ramSize;
        this.diskSize = diskSize;
        this.weight = weight;
        this.assetTag = assetTag;
        this.purchaseDate = purchaseDate;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }

    public String getProcessor()
    {
        return processor;
    }

    public int getRamSize()
    {
        return ramSize;
    }

    public int getDiskSize()
    {
        return diskSize;
    }

    public double getWeight()
    {
        return weight;
    }

    public static String getAssetTag()
    {
        return assetTag;
    }

    public String getPurchaseDate()
    {
        return purchaseDate;
    }
}
