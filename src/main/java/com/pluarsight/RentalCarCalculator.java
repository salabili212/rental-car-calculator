package com.pluarsight;

import java.util.Locale;
import java.util.Scanner;

public class RentalCarCalculator {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        double totalRentalPerDay = 0;
        final double RentalpricePerDay = 29.99;

        // Pickup date
        String date = pickDate(myScanner);

        // Get the number of rental days
        int rentalDays = rentalDays(myScanner);

        // Get the cost of additional options per day
        totalRentalPerDay = addtionalTools(myScanner, totalRentalPerDay);

        // Get the driver's age
        int age = getAge(myScanner);

        printOutResult(totalRentalPerDay, RentalpricePerDay, rentalDays, age, date);
    }

    public static String pickDate(Scanner SecScanner) {
        System.out.println("Enter a pickup date (MM/DD/YYYY):");
        String date = SecScanner.nextLine().trim();
        return date;
    }

    public static int rentalDays(Scanner SecScanner) {
        System.out.println("Number of days for the rental:");
        int rentalDays = SecScanner.nextInt();
        return rentalDays;
    }

    public static double addtionalTools(Scanner secScanner, double totalRentalPerDay) {
        System.out.println("Would you like an electronic toll tag for $3.95 per day? (yes/no)");
        String electronicToll = secScanner.next();

        System.out.println("Do you want a GPS for $2.95 per day? (yes/no)");
        String GPS = secScanner.next();

        System.out.println("Do you want roadside assistance for $3.95 per day? (yes/no)");
        String assistance = secScanner.next();

        if (electronicToll.equalsIgnoreCase("yes")) {
            totalRentalPerDay += 3.95;
        }

        if (GPS.equalsIgnoreCase("yes")) {
            totalRentalPerDay += 2.95;
        }

        if (assistance.equalsIgnoreCase("yes")) {
            totalRentalPerDay += 3.95;
        }

        return totalRentalPerDay;
    }

    public static int getAge(Scanner secScanner) {
        System.out.println("Please enter your current age:");
        int age = secScanner.nextInt();
        return age;
    }

    public static void printOutResult(double totalRentalPerDay, final double RentalpricePerDay,
                                      double rentalDays, int age, String date) {
        double basicTotal = RentalpricePerDay * rentalDays;
        double optionsTotal = totalRentalPerDay * rentalDays;
        double surcharge = 0;

        if (age < 25) {
            surcharge = basicTotal * 0.30;
        }

        double totalRental = basicTotal + optionsTotal + surcharge;

        System.out.println("Pickup date: " + date);
        System.out.printf(Locale.US, "Basic car rental: $%.2f%n", basicTotal);
        System.out.printf(Locale.US, "Options cost: $%.2f%n", optionsTotal);
        System.out.printf(Locale.US, "Underage driver surcharge: $%.2f%n", surcharge);
        System.out.printf(Locale.US, "Total cost: $%.2f%n", totalRental);
        System.out.println("All taxes have already been incorporated into the fees shown.");
    }
}