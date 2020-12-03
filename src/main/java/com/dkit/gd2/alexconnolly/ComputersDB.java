package com.dkit.gd2.alexconnolly;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ComputersDB
{
    private ArrayList<Computer> computers;
    private Scanner keyboard = new Scanner(System.in);

    public ComputersDB(ArrayList<Computer> computers)
    {
        this.computers = computers;
    }

    public static void loadComputersFromFile()
    {
        try(Scanner computerFile = new Scanner(new BufferedReader(new FileReader("Computers.txt"))))
        {
            while(computerFile.hasNextLine())
            {
                String input = computerFile.nextLine();
                String[] data = input.split(",");
                String manufacturer = data[0];
                String processor = data[1];
                int ramSize = Integer.parseInt(data[3]);
                int diskSize = Integer.parseInt(data[4]);
                double weight = Double.parseDouble(data[5]);
                String assetTag = data[5];
                String purchaseDate = data[6];
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(Colours.PURPLE+"Could not load computers; if this is the first time running the application then this might be fine."+Colours.RESET);
        }
    }
}
