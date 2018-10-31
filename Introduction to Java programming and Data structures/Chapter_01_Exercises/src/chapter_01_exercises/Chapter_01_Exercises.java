/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter_01_exercises;

import java.util.Scanner;

/**
 *
 * @author sbang
 */
public class Chapter_01_Exercises {
    static Scanner scanner = new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int programToRun = 0;
        if(args.length > 0) {
            try {
                programToRun = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument " + args[0] + " must be an integer");
                System.exit(1);
            }
        } else {
            System.out.print("Enter an integer corresponding to the exercise you want to run in this chapter (i.e 1 for 1.1): ");
            programToRun = scanner.nextInt();
        }
        
        switch(programToRun) {
            case 1:
                System.out.println("Running displayMessage program...");
                displayMessage();
                break;
            case 2:
                System.out.println("Running displayMessageTimes program...");
                displayMessageTimes("I love Java", 5);
                break;
            case 3:
                displayPattern();
                break;
            case 4: 
                System.out.println("Running displayIntPowerTable program...");
                characterWithInt('a', 4);
                displayIntPowerTable(10, 10, 1);
                break;
            case 5:
                System.out.println("Running computeExpression program...");
                computeExpression();
                break;
            case 6:
                System.out.println("Running sumFromOneTo program...");
                sumFromOneTo(10);
                break;
            case 7:
                System.out.println("Running approximatePI program...");
                approximatePI(10000);
                break;
            case 8:
                System.out.println("Running printAreaOfCircle + printPerimeterOfCircle program...");
                printAreaOfCircle(6.5f);
                printPerimeterOfCircle(6.5f);
                break;
            case 9:
                System.out.println("Running printAreaOfRectangle + printPerimeterOfRectangle program...");
                printAreaOfRectangle(5.3f, 6.5f);
                printPerimeterOfRectangle(5.3f, 6.5f);
                break;
            case 10:
                System.out.println("Running printAverageSpeedInMiles program...");
                printAverageSpeedInMiles(15, 0, 50, 30);
                break;
            case 11:
                System.out.println("Running populationProjection program...");
                populationProjection(312_032_486, 5, 7, 13, 45);
                break;
            case 12: 
                System.out.println("Running printAverageSpeedInKilometers program...");
                printAverageSpeedInKilometers(24, 1, 40, 34);
                break;
            case 13:
                System.out.println("Running compute2x2 program...");
                compute2x2(3.4f, 50.2f, 44.5f, 2.1f, .55f, 5.9f);
                break;
            default:
                System.err.println("This program only has 1-13 sub-programs. The argument " + programToRun + " does not lie within this range.");
                break;
        }
    }

    /** 1.1
     * Prints three predetermined messages to the console.
     */
    static void displayMessage() { 
        System.out.println(" Welcome to Java\n Learning Java Now\n Programming is fun");
    }

    /** 1.2
     * Print a message a number of times.
     *
     * @param message to print.
     * @param numberOfTimes the message should be printed.
     */
    static void displayMessageTimes(String message, int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            System.out.println(message);
        }
    }

    /** 1.3
     * Print a predetermined pattern message.
     */
    static void displayPattern() { 
        System.out.println("    J\n"
                + "J   aaa    v     vaaa\n"
                + "J  J  aa    V V    a a\n"
                + "J    aaaa       V     aaa");
    }

    /** 1.4
     * Prints a character followed by the power symbol and then an incrementing
     * number. The amount of characters is determined by the length.
     *
     * @param character to print before the power symbol and number.
     * @param length to make the print.
     */
    static void characterWithInt(char character, int length) { 
        for (int i = 1; i <= 4; i++) {
            if (i != 1) {
                System.out.print(character + "^" + i + " ");
            } else {
                System.out.print(character + " ");
            }
        }
        System.out.println("");
    }

    /** 1.4
     * Displays a table based on the given parameters. The integer is powered
     * each time it moves a column, and the power index I incremented at each
     * row.
     *
     * @param columns to print.
     * @param rows to print.
     * @param number to power.
     */
    static void displayIntPowerTable(int columns, int rows, int integer) {
        for (int y = 0; y < rows; y++) {
            displayIntPowerLine(integer, columns);
            integer++;
        }
    }

    /** 1.4
     * Display the power of an integer on one lines, determined by the
     * length(numberOfTimes).
     *
     * @param integer to power.
     * @param numberOfTimes how many times it should be powered and printed.
     */
    static void displayIntPowerLine(int integer, int numberOfTimes) {
        int[] integers = new int[numberOfTimes];
        for (int i = 0; i < numberOfTimes; i++) {
            integers[i] = (int) Math.pow(integer, i + 1);
        }

        for (int powerInt : integers) {
            System.out.print(powerInt + " ");
        }
        System.out.println("");
    }

    /** 1.5
     * Prints the result of a predefined mathematical expression.
     */
    static void computeExpression() {  
        System.out.println((7.5 * 6.5 - 4.5 * 3) / (47.5 - 5.5));
    }

    /** 1.6
     * Prints the sum of all the numbers from 1 to the number.
     *
     * @param number
     */
    static void sumFromOneTo(int number) {
        int sum = 0;
        for (int i = 0; i <= number; i++) {
            sum = sum + i;
        }
        System.out.println("The sum from 1 to " + number + " is: " + sum);
    }

    /** 1.7
     * Approximates PI based on the approxIndex. The higher the number, the
     * better.
     *
     * @param approxIndex
     */
    static void approximatePI(int approxIndex) {
        float factor = 0f;
        boolean negative = true;
        for (int i = 3; i <= approxIndex + 3; i++) {
            if (i % 2 != 0) {
                if (negative) {
                    factor = factor - 1.0f / i;
                } else {
                    factor = factor + 1.0f / i;
                }
                negative = !negative;
            }
        }
        System.out.println("PI is approximately(" + approxIndex + "): " + (4 * (1 + factor)));
    }

    /** 1.8
     * Prints the area of a circle with the given radius.
     *
     * @param radius of the circle.
     */
    static void printAreaOfCircle(float radius) {
        System.out.println("Area of a circle with " + radius + " in radius is = " + (Math.pow(radius, 2) * Math.PI));
    }

    /** 1.8
     * Prints the perimeter of the circle with the given radius.
     *
     * @param radius of the circle.
     */
    static void printPerimeterOfCircle(float radius) {
        System.out.println("Perimeter of circle with " + radius + " in radius is = " + (2 * radius * Math.PI));
    }

    /** 1.9
     * Prints the area of a rectangle with a given width and height.
     *
     * @param width of the rectangle.
     * @param height of the rectangle.
     */
    static void printAreaOfRectangle(float width, float height) {
        System.out.println("Area of a rectangle with the width of " + width + " and the height of " + height + " is = " + (width * height));
    }

    /** 1.9
     * Prints the perimeter of a rectangle with the given width and height.
     *
     * @param width of the rectangle.
     * @param height of the rectangle.
     */
    static void printPerimeterOfRectangle(float width, float height) {
        System.out.println("Perimeter of a rectangle with the width of " + width + " and the height of " + height + " is = " + (2 * (width + height)));
    }

    /** 1.10
     * Prints the average speed in miles based on the parameters.
     *
     * @param kilometers of which the speed is measured.
     * @param minutes
     * @param seconds
     */
    static void printAverageSpeedInMiles(float kilometers, float hours, float minutes, float seconds) {
        float hoursSum = hours + minutes / 60 + seconds / (60 * 60) ,
                speedInMiles = kilometers * 1.6f;
        System.out.println("Average speed in miles: " + speedInMiles);
    }
    
    /** 1.11
     * Prints the average speed in miles based on the parameters.
     * @param miles
     * @param hours
     * @param minutes
     * @param seconds 
     */
    static void printAverageSpeedInKilometers(float miles, float hours, float minutes, float seconds) {
        float hoursSum = hours + minutes / 60 + seconds / (60 * 60),
                speedInKilometers = miles / 1.6f;
        System.out.println("Average speed in kilometers : " + speedInKilometers);
    }

    /** 1.12
     * Create a projection of the population growth in a given time period (in years)
     * @param population The start population.
     * @param years The time period.
     * @param births How often, in seconds, a child is born.
     * @param deaths How often, in seconds, a person dies.
     * @param immigrants How often, in seconds, a person immigrates.
     */
    static void populationProjection(int population, float years, int births, int deaths, int immigrants) {
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
    
    /** 1.13
     * Computes a 2 x 2 linear equation. (ax + by = e & cx + dy = f)
     * @param a first equations x factor.
     * @param b first equations y factor.
     * @param e the result of the first equation.
     * @param c second equations x factor.
     * @param d second equations y factor.
     * @param f the result of the second equation.
     */
    static void compute2x2(float a, float b, float e, float c, float d, float f) {
        if(a * d - b * c != 0) {
            float   x = (e * d - b * f) / (a * d - b * c),
                    y = (a * f - e * c) / (a * d - b * c);
            
            System.out.println(a + "x + " + b + "y = " + e);
            System.out.println(c + "x + " + d + "y = " + f);
            
            System.out.println("\ny = " + y + "\nx = " + x);
        } else {
            System.out.println("ad - bc = 0");
        }
    }
}
