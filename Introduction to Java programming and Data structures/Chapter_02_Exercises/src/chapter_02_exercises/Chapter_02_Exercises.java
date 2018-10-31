package chapter_02_exercises;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Scanner;

/**
 *
 * @author Samuel Bangslund
 */
public class Chapter_02_Exercises {
    static Scanner scanner = new Scanner(System.in);
    static final double FEET    = 3.2786,
                        MILES   = 1.6,
                        INCHES  = 0.0254,
                        PING    = 0.3025,
                        POUNDS  = 0.45359237;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int programToRun = 0;
        if(args.length > 0) {
            try {
                programToRun = Integer.parseInt(args[0]);
            } catch(NumberFormatException e) {
                System.err.println("Argument " + args[0] + " must be an integer");
                System.exit(1);
            }
        }else {
            System.out.print("Enter an integer corresponding to the exercise you want to run in this chapter (i.e 1 for 2.1): ");
            programToRun = scanner.nextInt();
        }
        
        switch(programToRun) {
            case 1:
                System.out.println("Running milesToKilometer program...");
                milesToKilometer();
                break;
            case 2:
                System.out.println("Running volumeOfTriangle program...");
                volumeOfTriangle();
                break;
            case 3:
                System.out.println("Running metersToFeet program...");
                metersToFeet();
                break;
            case 4: 
                System.out.println("Running metersToPing program...");
                metersToPing();
                break;
            case 5:
                System.out.println("Running calculateTips program...");
                calculateTips();
                break;
            case 6:
                System.out.println("Running multiplyDigitsInNumber program...");
                multiplyDigitsInNumber();
                break;
            case 7:
                System.out.println("Running minutesInYears program...");
                minutesToYears();
                break;
            case 8:
                System.out.println("Running currentTime program...");
                showCurrentTime();
                break;
            case 9:
                System.out.println("Running averageAcceleration program...");
                averageAcceleration();
                break;
            case 10:
                System.out.println("Running calculateEnergy program...");
                calculateEnergy();
                break;
            case 11:
                System.out.println("Running populationProjection program...");
                populationProjection(312_032_486, 7, 13, 45);
                break;
            case 12:
                System.out.println("Running findRunwayLength program...");
                findRunwayLength();
                break;
            case 13:
                System.out.println("Running annualInterestRate program...");
                annualInterestRate();
                break;
            case 14:
                System.out.println("Running computingBMI program...");
                computingBMI();
                break;
            case 15:
                System.out.println("Running distanceOfTwoPoints program...");
                distanceOfTwoPoints();
                break;
            case 16:
                System.out.println("Running hexagonArea program...");
                hexagonArea();
                break;
            case 17:
                System.out.println("Running windChillTemp program...");
                windChillTemp();
                break;
            case 18:
                System.out.println("Running printTable program...");
                printTable();
                break;
            case 19:
                System.out.println("Running areaOfATriangle program...");
                areaOfATriangle();
                break;
            case 20:
                System.out.println("Running calculateInterest program...");
                calculateInterest();
                break;
            case 21:
                System.out.println("Running calculateFutureInvestment program...");
                calculateFutureInvestment();
                break;
            case 22:
                System.out.println("Running computeChange program...");
                computeChange();
                break;
            case 23:
                System.out.println("Running costOfDriving program...");
                costOfDriving();
                break;
            default:
                System.err.println("This program only has 1-23 sub-programs. The argument " + programToRun + " does not lie within this range.");
                break;
        }
    }
    
    /** 2.1
     * Prompts the user for a miles value.
     * Then proceeds to convert that value to kilometers and prints it back to the user. PIO
     */
    static void milesToKilometer() { 
        System.out.print("Enter miles: ");
        double milesFromInput = scanner.nextDouble();
        System.out.println(milesFromInput + " miles is " + (float)(milesFromInput * MILES) + " kilometers");
    }
    
    /** 2.2
     * Prompts the user for the triangles sides length. (It's an equilateral triangle)
     */
    static void volumeOfTriangle() {
        System.out.print("Enter length of the traingles sides: ");
        double lengthFromInput = scanner.nextDouble();
        
        double  area = (Math.sqrt(3) / 4) * Math.pow(lengthFromInput, 2),
                volume = area * lengthFromInput;
        System.out.println("The area is " + (float)area);
        System.out.println("The volume of the Triangular prism is " + (float)volume);
    }
    
    /** 2.3
     * Prompts the user for meters to convert to feet.
     */
    static void metersToFeet(){
        System.out.print("Enter a value for meter: ");
        double metersFromInput = scanner.nextDouble();
        
        System.out.println(metersFromInput + " meters is " + (metersFromInput * FEET) + " feet");
    }
    
    /** 2.4
     * Prompts the user for square meters then prints the equivalent ping.
     */
    static void metersToPing() {
        System.out.print("Enter a number in square meters: ");
        double metersFromInput = scanner.nextDouble();
        
        System.out.println(metersFromInput + " square meters is " + (metersFromInput * PING) + " pings");
    }
    
    /** 2.5
     * Prompts the user for a subtotal and a gratuity rate.
     * It then prints the resulting gratuity and total to pay.
     */
    static void calculateTips() {
        System.out.print("Enter the subtotal and a gratuity rate: ");
        double  subTotal = scanner.nextDouble(),
                gratuityRate = scanner.nextDouble(),
                gratuity = subTotal * gratuityRate / 100,
                total = subTotal + gratuity;
        
        System.out.println("The gratuity is $" + gratuity + " and total is $" + total);
    }
    
    /** 2.6
     * Multiplies all the integers from the number with each other.
     * The range is only from 0 to 1000.(Everything above won't work.)
     */
    static void multiplyDigitsInNumber() {
        System.out.print("Enter a number between 0 and 1000: ");
        int inputNumber = scanner.nextInt();
        
        int     ones = inputNumber % 10,
                tens = (inputNumber < 10) ? 1 : (inputNumber / 10) % 10,
                hundreds = (inputNumber < 100) ? 1 : inputNumber / 100;
        
        System.out.println("When multiplying the digits the total is: " + (hundreds * tens * ones));
    }
    
    /** 2.7
     * Prompts the user for minutes to convert to years.
     */
    static void minutesToYears() {
        System.out.print("Enter the number of minutes: ");
        int minutes = scanner.nextInt();
        
        double  days = minutes / 60 / 24,
                years = days / 365,
                restOfDays = days % 365;
        
        System.out.println(String.format("%,d", minutes) + " minutes is approximately " + (int)years + " years and " + (int)restOfDays + " days");
    }
    
    /** 2.8
     * Shows the current time based on the prompted offset input.
     */
    static void showCurrentTime() {
        // Prompt the user for offset input.
        System.out.print("Enter the time offset for the timezone (Max is 18): ");
        int offsetInt = scanner.nextInt();
        
        ZoneOffset zoneOffset;
        if(offsetInt > 9 && offsetInt <= 18) {
            zoneOffset = ZoneOffset.of("+" + offsetInt + ":00");
        } else if(offsetInt < 10 && offsetInt >= 0) {
            zoneOffset = ZoneOffset.of("+0" + offsetInt + ":00");
        } else {
            zoneOffset = ZoneOffset.of("+00:00");
        }
        
        // Get the localtime with the prompted offset.
        LocalDateTime localDateTime = LocalDateTime.now(zoneOffset);
        
        // Print results to console.
        System.out.println("The zone offset is: " + zoneOffset);
        System.out.print("The current time is ");
        System.out.println(localDateTime.toLocalTime().minusNanos(localDateTime.getNano()));
    }
    
    /** 2.9
     * Based on the user inputs for v0, v1 and t, this calculates the average acceleration.
     */
    static void averageAcceleration() {
        System.out.print("Enter the v0, v1 and t: ");
        double  v0  = scanner.nextDouble(),
                v1  = scanner.nextDouble(),
                t   = scanner.nextDouble();   
        
        System.out.println("The average acceleration is " + (float)((v1 - v0) / t));
    }
    
    /** 2.10
     * Based on the user input, this calculates the amount of energy needed
     * to heat water from the initial temperature to the final temperature.
     */
    static void calculateEnergy() {
        double  amountOfWater, 
                initialTemperature,
                finalTemperature;
        
        System.out.print("Enter the amount of water in kilograms: ");
        amountOfWater = scanner.nextDouble();
        System.out.print("Enter the initial temperature(celsius): ");
        initialTemperature = scanner.nextDouble();
        System.out.print("Enter the final temperature(celsius): ");
        finalTemperature = scanner.nextDouble();
        
        System.out.println("The energy needed is " + (amountOfWater * (finalTemperature - initialTemperature) * 4184));
    }
    
    /** 2.11
     * Create a projection of the population growth in a given time period (in years).
     * The years variable is decides by the user input.
     * @param population The start population.
     * @param years The time period.
     * @param births How often, in seconds, a child is born.
     * @param deaths How often, in seconds, a person dies.
     * @param immigrants How often, in seconds, a person immigrates.
     */
    static void populationProjection(int population, int births, int deaths, int immigrants) {
        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();
        
        double incrementPerDay = 24 * 60 * 60 *(1.0 / births - 1.0 / deaths + 1.0 / immigrants);
        int startPopulation = population;
        for(byte i = 1; i <= years; i++) {
            population += incrementPerDay * 365;
            System.out.println("In year " + i + " the population is " + String.format("%,d", population));
        }
        
        System.out.println("\nThe population was at " + String.format("%,d", startPopulation) + " when the simulation began.");
        System.out.println("The population was at " + String.format("%,d", population) + " when the simulation ended.\n");
        System.out.println("This results in a difference of " + String.format("%,d",(population - startPopulation)) + "\n");
        
        System.out.println("A child is born every " + births + " seconds.");
        System.out.println("A person dies every " + deaths + " seconds.");
        System.out.println("An immigrant adds to the population every " + immigrants + " seconds.");
    }
    
    /** 2.12
     * Finds the necessary length of the runway for the plane to take off.
     * (Based on the speed and acceleration of the plane.)
     */
    static void findRunwayLength() {
        System.out.print("Enter speed and acceleration: ");
        double  speed = scanner.nextDouble(),
                acceleration = scanner.nextDouble();
        
        System.out.println("The minimum runway length for this airplane is " + 
                            (float)(Math.pow(speed, 2) / (2 * acceleration)));
    }
    
    /** 2.13
     * Calculates the final account value after 6 months with an interest rate of 3.75%.
     * The user is prompted for the monthly savings amount.
     */
    static void annualInterestRate() {
        System.out.print("Enter the monthly saving amount: ");
        double  savingsAmount = scanner.nextDouble(),
                rate = 0.0375,
                monthlyRate = rate / 12,
                accountValue = 0;
        
        String[] months = {"first", "second", "third", "fourth", "fifth", "sixth"};
        
        for (int i = 0; i < 6; i++) {
            accountValue = (i != 0) ? (savingsAmount + accountValue) * (1 + monthlyRate) : 100 * (1 + monthlyRate);
            System.out.println("After the " + months[i] + ", the account value is " + accountValue);
        }
    }
    
    /** 2.14
     * Compute the BMI of a person with a prompted weight and height.
     */
    static void computingBMI() {
        System.out.print("Enter the weigth in pounds: ");
        double weight = scanner.nextDouble();
        System.out.print("Enter height in inches: ");
        double height = scanner.nextDouble();
        
        System.out.println("BMI is " + (float)((weight * POUNDS) / Math.pow(height * INCHES, 2)));
    }
    
    /** 2.15
     * Calculates the distance between two points prompted from the user.
     */
    static void distanceOfTwoPoints() {
        System.out.print("Enter x1 and y1: ");
        double  x1 = scanner.nextDouble(),
                y1 = scanner.nextDouble();
        
        System.out.print("Enter x2 and y2: ");
        double  x2 = scanner.nextDouble(),
                y2 = scanner.nextDouble();
        
        System.out.println("The distance between the two points is " + Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }
    
    /** 2.16
     * Prompt length from the user and then proceed to calculate the area of the hexagon.
     */
    static void hexagonArea() {
        System.out.print("Enter the length of the side: ");
        double length = scanner.nextDouble();
        
        System.out.println("The area of the hexagon is " + (float)((3 * Math.sqrt(3)) / 2 * Math.pow(length, 2)));
    }
    
    /** 2.17
     * Prompts for air temperature and the corresponding wind speed 
     * then proceeds to calculate the wind chill index.
     */
    static void windChillTemp(){
        System.out.print("Enter the tempterature in Fahrenheit between -58F and 41F: ");
        double temperature = scanner.nextDouble();
        System.out.print("Enter the wind speed (>= 2) in miles per hour: ");
        double  windSpeed = scanner.nextDouble(),
                windChill = 35.72 + 0.6215 * temperature - 35.75 * Math.pow(windSpeed, 0.16) + 0.4275 * temperature * Math.pow(windSpeed, 0.16);
        
        System.out.println("The wind chill index is " + (float)windChill);
    }
    
    /** 2.18
     * Print a prefixed table.
     */
    static void printTable() {
        System.out.println("   a\t  b\t  Middle Point");
        System.out.println(   "(0, 0)   (2, 1)    (1.0, 0.5)\n"
                            + "(1, 4)   (4, 2)    (2.5, 3.0)\n"
                            + "(2, 7)   (6, 3)    (4.0, 5.0)\n"
                            + "(3, 9)   (10, 5)   (6.5, 7.0)\n"
                            + "(4, 11)  (12, 7)   (8.0, 9.0)");
    }
    
    /** 2.19
     * Calculate the area of a triangle based on 3 prompted points.
     */
    static void areaOfATriangle() {
        System.out.print("Print the coordinates of three points seperated by spaces like x1 y1 x2 y2 x3 y3: ");
        double  x1 = scanner.nextDouble(),
                y1 = scanner.nextDouble(),
                x2 = scanner.nextDouble(),
                y2 = scanner.nextDouble(),
                x3 = scanner.nextDouble(),
                y3 = scanner.nextDouble();
        
        double  side1 = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)),
                side2 = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2)),
                side3 = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2)),
                s = (side1 + side2 + side3) / 2,
                area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        
        System.out.println("The area of the triangle is " + (float)area);
    }
    
    /** 2.20
     * Calculate the interest based on the prompted balance and interest rate.
     */
    static void calculateInterest() {
        System.out.print("Enter balance and interest rate (e.g., 3 for 3%: ");
        double  balance = scanner.nextDouble(),
                interestRate = scanner.nextDouble(),
                interest = balance * (interestRate / 1200);
        
        System.out.println("The interest is " + (float)interest);
    }
    
    /** 2.21
     * Calculate the future investment based on the prompted interest rate and number of years.
     */
    static void calculateFutureInvestment() {
        System.out.print("Enter investment amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter annual interest rate in percentage: ");
        double interestRate = scanner.nextDouble();
        System.out.print("Enter number of years: ");
        double numberOfYears = scanner.nextDouble(),
                futureInvestmentValue = amount * Math.pow(1 + interestRate / 1200, numberOfYears * 12);
        
        System.out.println("Future value us $" + (float)futureInvestmentValue);
    }
    
    /** 2.22
     * Convert the prompted number into dollars and cents.
     * (The last two digits being the cents)
     */
    static void computeChange() {
        System.out.print("Enter the change to compute: ");
        int     change = scanner.nextInt(),
                dollars = change / 100,
                cents = change % 100;
        
        System.out.println("The change is equal to: $" + dollars + " and " + cents + " cents");
    }
    
    /** 2.23
     * Calculate the cost of driving a prompted distance with
     * the corresponding fuel cost and fuel efficiency.
     */
    static void costOfDriving() {
        System.out.print("Enter the driving distance: ");
        double distance = scanner.nextDouble();
        System.out.print("Enter miles per gallon: ");
        double milesPerGallon = scanner.nextDouble();
        System.out.print("Enter price per gallon: ");
        double pricePerGallon = scanner.nextDouble();
        
        System.out.println("The cost of driving is $" + (float)(distance / milesPerGallon * pricePerGallon));
    }
}
