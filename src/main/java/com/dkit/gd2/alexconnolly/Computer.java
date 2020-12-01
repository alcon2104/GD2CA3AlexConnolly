package com.dkit.gd2.alexconnolly;

import java.util.Random;

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

//    public static String generateAssetTag()
//    {
//        if(Computer.getAssetTag() == null)
//        {
//            Random rand = new Random();
//            int lowerBound = 10000;
//            int higherBound = 99999;
//            String newAssetTag = "DKIT-" + rand.nextInt(higherBound - lowerBound);
//            System.out.println(newAssetTag);
//            App.readFile("Students");
//            //if(newAssetTag == any other asset tag that exists already)
//            {
//                return null;
//            }
//            else
//            {
//                return newAssetTag;
//            }
//        }
//        return null;
//    }
}
