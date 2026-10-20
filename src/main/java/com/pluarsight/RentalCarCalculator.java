package com.pluarsight;
import java.util.Locale;
import java.util.Scanner;


public class RentalCarCalculator {
    public static void main(String[] args) {
        //declear the scanner variable
        Scanner myScanner = new Scanner(System.in);

        //Declear some variables for the rental price and total
        double totalRentalPerDay = 0;
        final double RentalpricePerDay = 8.50;
        double totalrental = 0;


        //Pickup Date
        String date = pickDate(myScanner);

        //get how many days for the rental
        int rentalDays = rentalDays(myScanner);

        //Mthod to see if user need addtionals things
        totalRentalPerDay = addtionalTools(myScanner,totalRentalPerDay);

        //Get the user age
        int age = getAge(myScanner);

        //Final method will print out the result
        printOutResult(totalRentalPerDay,RentalpricePerDay,rentalDays,age,date);


    }



    // Date method get the date and return it.
    public static  String pickDate(Scanner SecScanner){
        System.out.println("Enter a pickup date month press enter days enter and than year");
        int month = SecScanner.nextInt();
        int day = SecScanner.nextInt();
        int year = SecScanner.nextInt();

        String date = month+"-"+day+"-20"+year;
        return date;
    }

    //get the days for the rental
    public static int rentalDays(Scanner SecScanner){
        System.out.println("Number of dyas for the rental.");
        int rentalDays = SecScanner.nextInt();
        return rentalDays;
    }

    //Addtional tools
    public static double addtionalTools(Scanner secScanner, double totalRentalPerDay){
        System.out.println("Would you like to add electronic toll tag only for $3.95 per day? enter yes OR no only.");
        String electronicToll = secScanner.next();
        electronicToll = electronicToll.toLowerCase();

        System.out.println("Do you want a GPS only for $2.95 per day? please enter yes or no ");
        String GPS = secScanner.next();
        GPS = GPS.toLowerCase();

        System.out.println("Do you want a roadside assistance only for $3.95 per day? please enter yes or no");
        String assistance = secScanner.next();
        assistance = assistance.toLowerCase();

        if(electronicToll == "yes") totalRentalPerDay += 3.95;
        if(GPS == "yes") totalRentalPerDay += 2.95;
        if(assistance == "yes") totalRentalPerDay += 3.95;

        return totalRentalPerDay;
    }

    //get the age from the user
    public static int getAge(Scanner secScanner){
        System.out.println("please enter your current age?");
        int age = secScanner.nextInt();
        return age;
    }

    //the final method that will print out all the result
    public static void printOutResult(double totalRentalPerDay,final double RentalpricePerDay,double rentalDays,int age,String date){
        double totalRental = (totalRentalPerDay + RentalpricePerDay) * rentalDays;
        if(age < 25){
            totalRental += (totalRental * .30);
        }

        System.out.println("Date to pickup is "+ date);
        System.out.println("The basic car rental is $"+totalRental+" Per day.");
        if(age < 25){
            System.out.println("There is a 30% surcharge on the basic car rental for drivers under 25.");
        }
        System.out.println("All taxes have already been incorporated into the fees shown.");

    }
}
