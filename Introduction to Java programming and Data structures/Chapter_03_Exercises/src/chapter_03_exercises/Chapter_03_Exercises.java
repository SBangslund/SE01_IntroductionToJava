package chapter_03_exercises;

import java.util.Scanner;

/**
 *
 * @author Samuel Bangslund
 */
public class Chapter_03_Exercises {

    static Scanner scanner = new Scanner(System.in);
    static final double KILOGRAMS_PER_POUND = 0.45359237,
            METERS_PER_INCH = 0.0254;

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
            System.out.print("Enter an integer corresponding to the exercise you want to run in this chapter (i.e 1 for 3.1): ");
            programToRun = scanner.nextInt();
        }

        switch (programToRun) {
            case 1:
                solveQuadraticEquations();
                break;
            case 2:
                multiplyThreeNumbers();
                break;
            case 3:
                solve2x2LinearEquations();
                break;
            case 4:
                randomMonth();
                break;
            case 5:
                findFutureDates();
                break;
            case 6:
                healthApplication();
                break;
            case 7:
                computeChange();
                break;
            case 8:
                sortThreeIntegers();
                break;
            case 9:
                ISBNStandard();
                break;
            default:
                System.err.println("This program only has 9 sub-programs. The argument " + programToRun + " does not lie within this range.");
                break;
        }
    }

    /**
     * 3.1 Solves a quadratic equation with prompted a, b and c variables.
     */
    static void solveQuadraticEquations() {
        // Prompts for input
        System.out.print("Enter a, b and c: ");
        double a = scanner.nextDouble(),
                b = scanner.nextDouble(),
                c = scanner.nextDouble();

        // Calculates
        double discrimintant = Math.pow(b, 2) - 4 * a * c,
                r1 = (-b + Math.sqrt(discrimintant)) / 2 * a,
                r2 = (-b - Math.sqrt(discrimintant)) / 2 * a;

        // Outputs
        if (discrimintant == 0) {
            System.out.println("The equation has one root: " + r1);
        } else if (discrimintant > 0) {
            System.out.println("The equation has two roots: " + r1 + " and " + r2);
        } else {
            System.out.println("The equation has no roots.");
        }
    }

    /**
     * 3.2 Prints three numbers for the user to add together. Then checks if the
     * user answered correctly.
     */
    static void multiplyThreeNumbers() {
        System.out.print("What are these three integers added together?: ");
        int number1 = (int) (Math.random() * 10),
                number2 = (int) (Math.random() * 10),
                number3 = (int) (Math.random() * 10);

        System.out.print(number1 + " " + number2 + " " + number3 + " : ");

        int numbersAddedTogether = scanner.nextInt();

        System.out.println(number1 + " * " + number2 + " * " + number3 + " = " + numbersAddedTogether + " is "
                + (numbersAddedTogether == number1 * number2 * number3));
    }

    /**
     * 3.3 Solves a 2x2 linear equation given that a, b, e, c, d, f is provided
     * by the user. Then returns the x and y.
     */
    static void solve2x2LinearEquations() {
        System.out.print("Enter a, b, c, d, e, f: ");
        double a = scanner.nextDouble(),
                b = scanner.nextDouble(),
                c = scanner.nextDouble(),
                d = scanner.nextDouble(),
                e = scanner.nextDouble(),
                f = scanner.nextDouble();

        if (a * d - b * c != 0) {
            double x = (e * d - b * f) / (a * d - b * c),
                    y = (a * f - e * c) / (a * d - b * c);

            System.out.println(a + "x + " + b + "y = " + e);
            System.out.println(c + "x + " + d + "y = " + f);

            System.out.format("\nx = %.2f \ny = %.2f", x, y);
        } else {
            System.out.println("The equation has no solution.");
        }
    }

    /**
     * 3.4 Creates a random number and prints the corresponding month.
     */
    static void randomMonth() {
        int randomMonth = (int) (Math.random() * 13);

        System.out.print("The random number was " + randomMonth + " which is ");

        switch (randomMonth) {
            case 1:
                System.out.print("January");
                break;
            case 2:
                System.out.print("February");
                break;
            case 3:
                System.out.print("March");
                break;
            case 4:
                System.out.print("April");
                break;
            case 5:
                System.out.print("May");
                break;
            case 6:
                System.out.print("June");
                break;
            case 7:
                System.out.print("July");
                break;
            case 8:
                System.out.print("August");
                break;
            case 9:
                System.out.print("September");
                break;
            case 10:
                System.out.print("October");
                break;
            case 11:
                System.out.print("November");
                break;
            case 12:
                System.out.print("December");
        }
    }

    /**
     * 3.5 Finds the future date in weekdays based on the initial date and then
     * the amount of days from there.
     */
    static void findFutureDates() {
        System.out.print("Enter today's date: ");
        int today = scanner.nextInt();
        System.out.print("Enter the number of days elapsed since today: ");
        int elapsedDays = scanner.nextInt();

        switch (today) {
            case 1:
                System.out.print("Today is Monday ");
                break;
            case 2:
                System.out.print("Today is Tuesday ");
                break;
            case 3:
                System.out.print("Today is Wednesday ");
                break;
            case 4:
                System.out.print("Today is Thursday ");
                break;
            case 5:
                System.out.print("Today is Friday ");
                break;
            case 6:
                System.out.print("Today is Saturday ");
                break;
            case 7:
                System.out.print("Todaay is Sunday ");
                break;
        }

        switch ((elapsedDays + today) % 7) {
            case 1:
                System.out.print("and the future day is Monday");
                break;
            case 2:
                System.out.print("and the future day is Tuesday");
                break;
            case 3:
                System.out.print("and the future day is Wednesday");
                break;
            case 4:
                System.out.print("and the future day is Thursday");
                break;
            case 5:
                System.out.print("and the future day is Friday");
                break;
            case 6:
                System.out.print("and the future day is Saturday");
                break;
            case 7:
                System.out.print("and the future day is Sunday");
                break;
        }
    }

    /**
     * 3.6 Calculates the BMI from the variables given by the user.
     */
    static void healthApplication() {
        System.out.print("Enter weight in pounds: ");
        double weight = scanner.nextDouble();
        System.out.print("Enter feet: ");
        double feet = scanner.nextDouble();
        System.out.print("Enter inches: ");
        double inches = scanner.nextDouble();

        double weightInKilograms = weight * KILOGRAMS_PER_POUND,
                heightInMeters = inches * METERS_PER_INCH + (feet / 3.2786),
                bmi = weightInKilograms / Math.pow(heightInMeters, 2);

        System.out.format("BMI is %.3f\n", bmi);
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi < 25) {
            System.out.println("Normal");
        } else if (bmi < 30) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }

    /**
     * 3.7 Computes the amount of change the user should receive in dollars and
     * cents. Also makes sure that the plural of each word matches the amount.
     */
    static void computeChange() {
        System.out.print("Enter your amount of cash: ");
        double amount = scanner.nextDouble();
        int dollars = (int) (amount / 100),
                cents = (int) (amount % 100);

        String dollarEnding = (dollars > 1) ? " dollars" : " dollar",
                centEnding = (cents > 1) ? " pennies" : " penny";

        System.out.println("The change is equal to: $" + dollars + dollarEnding + " and " + cents + centEnding);
    }

    /**
     * Sorts three integers in non-decreasing order.
     */
    static void sortThreeIntegers() {
        System.out.print("Enter three integers for the program to sort in non-decreasing order: ");
        int a = scanner.nextInt(),
                b = scanner.nextInt(),
                c = scanner.nextInt();

        int lowest = 0,
                middle = 0,
                highest = 0;

        if (a < b) {
            if (a < c) {
                lowest = a;
            } else {
                middle = a;
                lowest = c;
                highest = b;
            }
        } else if (a < c) {
            lowest = b;
            middle = a;
            highest = c;
        } else {
            if (c < b) {
                lowest = c;
                middle = b;
            } else {
                lowest = b;
                middle = c;
            }
            highest = a;
        }
        System.out.println("The non-decreasing order is: " + lowest + " : " + middle + " : " + highest);
    }

    static void ISBNStandard() {
        System.out.print("Enter the first 9 digits of an ISBN as integer: ");
        String isbn = scanner.next();
        // Converts the string into a char array. (For indexing)
        char[] isbnAsCharArray = isbn.toCharArray();
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            // Follows the formular assigned. Gets the chars in the array
            // and then converts that char into an int. 
            sum += Integer.parseInt(String.valueOf(isbnAsCharArray[i])) * (i + 1);
        }

        System.out.print("The ISBN-10 number is " + isbn + ((sum % 11 == 10) ? "X" : sum % 11));
    }
}
