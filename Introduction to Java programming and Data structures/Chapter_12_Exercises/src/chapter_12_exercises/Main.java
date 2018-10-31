/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */
package chapter_12_exercises;

import java.util.Scanner;

import chapter_12_exercises._05.*;
import chapter_12_exercises._02.Month;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sbang
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int programToRun = 0;
        if (args.length > 0) {
            try {
                programToRun = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument " + args[0] + " must be an integer");
                System.exit(1);
            }
        } else {
            System.out.print("Enter an integer corresponding to the exercise you want to run in this chapter (i.e 1 for 11.1): ");
            programToRun = scanner.nextInt();
        }

        switch (programToRun) {
            case 2:
                _02_Test();
                break;
            case 3:
                _03_Test();
                break;
            case 5:
                _05_Test();
                break;
            default:
                System.err.println("This program only has 9 sub-programs. The argument " + programToRun + " does not match any of the programs.");
                break;
        }
    }

    public static void _02_Test() {
        System.out.print("Type in a number in the range of 1-12: ");
        int number = scanner.nextInt();

        int daysInMonth = Month.getDaysInMonth(number);

        if (daysInMonth != 0) {
            System.out.println("There are " + daysInMonth + " days in " + Month.getMonth(number - 1));
        }
    }

    public static void _03_Test() {
        System.out.print("Type in a number in the range of 1-12: ");
        int number = 0;
        
        try {
            number = scanner.nextInt();
        } catch(InputMismatchException ex) {
            System.out.println("Wrong input. [Expected a number]");
            return;
        }

        int daysInMonth = Month.getDaysInMonth(number);

        if (daysInMonth != 0) {
            System.out.println("There are " + daysInMonth + " days in " + Month.getMonth(number - 1));
        }
    }
    
    public static void _05_Test() {
        Triangle triangle;
        System.out.print("Type in the three sides of a triangle: ");
        try {
            triangle = new Triangle(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        } catch (IllegalTriangleException ex) {
            System.out.println("Invalid sides.");
            return;
        }
        
        System.out.println("Succesfully created the triangle: " + triangle);
    }
}
