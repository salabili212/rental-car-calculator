package com.pluarsight;
import java.util.Locale;
import java.util.Scanner;


public class RentalCarCalculator {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        double totalRentalPerDay = 0;
        final double RentalpricePerDay = 8.50;
        double totalrental = 0;
        //Pickup Date
        pickDate(Scanner myScanner);

        System.out.println("Number of dyas for the rental.");
        int rentalDays = myScanner.nextInt();

        System.out.println("Would you like to add electronic toll tag only for $3.95 per day? enter yes OR no only.");
        String electronicToll = myScanner.next();
        electronicToll = electronicToll.toLowerCase();

        System.out.println("Do you want a GPS only for $2.95 per day? please enter yes or no ");
        String GPS = myScanner.next();
        GPS = GPS.toLowerCase();

        System.out.println("Do you want a roadside assistance only for $3.95 per day? please enter yes or no");
        String assistance = myScanner.next();
        assistance = assistance.toLowerCase();

        System.out.println("please enter your current age?");
        int age = myScanner.nextInt();

        if(electronicToll == "yes") totalRentalPerDay += 3.95;
        if(GPS == "yes") totalRentalPerDay += 2.95;
        if(assistance == "yes") totalRentalPerDay += 3.95;

        totalRentalPerDay += RentalpricePerDay;
        totalRentalPerDay = totalRentalPerDay * rentalDays;
        totalrental = totalRentalPerDay;

        if(age < 25){
            totalrental = totalRentalPerDay + (totalRentalPerDay * .30);
        }

        System.out.println("The basic car rental is $"+ totalrental);

    }

    public static  String pickDate(Scanner SecScanner){
        System.out.println("Enter a pickup date month press enter days enter and than year");
        int month = myScanner.nextInt();
        int day = myScanner.nextInt();
        int year = myScanner.nextInt();
    }
}
