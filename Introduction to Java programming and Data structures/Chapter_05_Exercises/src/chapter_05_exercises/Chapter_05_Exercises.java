package chapter_05_exercises;

import java.util.Scanner;

/**
 *
 * @author Samuel Bangslund
 */
public class Chapter_05_Exercises {

    static Scanner scanner = new Scanner(System.in);

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
            System.out.print("Enter an integer corresponding to the exercise you want to run in this chapter (i.e 1 for 5.1): ");
            programToRun = scanner.nextInt();
        }

        switch (programToRun) {
            case 1:
                passOrFail();
                break;
            case 2:
                multiplicationQuiz();
                break;
            case 3:
                convertCToF();
                break;
            case 4:
                inchToMeters();
                break;
            case 5:
                convertCToFFToC();
                break;
            case 6:
                squareMeterToPing();
                break;
            case 7:
                computeFutureTuition();
                break;
            case 8:
                findHighestScore();
                break;
            case 17:
                displayPyramid();
                break;
            case 18:
                displayPattern();
                break;
            case 21:
                compareLoans();
                break;
            default:
                System.err.println("This program only has 21 sub-programs. The argument " + programToRun + " does not lie within this range.");
                break;
        }
    }

    /**
     * 5.1 Will continue to prompt the user for a java score, and depending on
     * that score the program will determine whether or not you have passed or
     * failed. (To exit the program one must enter -1)
     */
    static void passOrFail() {
        boolean running = true;

        while (running) {
            System.out.print("Enter a java score for evaluation: ");
            int input = scanner.nextInt();
            if (input >= 60) {
                System.out.println("You passed the exam.");
            } else if (input == -1) {
                System.out.println("No numbers are entered except 0.");
                running = false;
            } else {
                System.out.println("You don't pass the exam.");
            }
        }
    }

    /**
     * 5.2 Quizzes the user for a product between two numbers. It also keeps
     * track of how long it took you to complete said quiz.
     */
    static void multiplicationQuiz() {
        int number1,
                number2,
                timeSum = 0;

        long time;

        for (int i = 0; i < 10; i++) {
            number1 = (int) (Math.random() * 13);
            number2 = (int) (Math.random() * 13);

            System.out.print("What is the product of these to numbers? " + number1 + " * " + number2 + ": ");

            time = System.currentTimeMillis();

            if (scanner.nextInt() == number1 * number2) {
                System.out.print("Correct, ");
            } else {
                System.out.println("Wrong the correct answer is " + number1 * number2);
            }
            time = (System.currentTimeMillis() - time) / 1_000;
            timeSum += time;

            System.out.println("it took you " + time + " seconds to complete.\n");
        }
        System.out.println("The test is done. It took you " + timeSum + " seconds to complete.");
    }

    /**
     * 5.3 Displays the conversion between 0-100 Celsius to Fahrenheit.
     * (Incremented by 2)
     */
    static void convertCToF() {
        System.out.format("%-4s    %4s", "Celsius", "Fahrenheit\n");
        for (int i = 0; i <= 100; i += 2) {
            System.out.format("%-4s            %5s\n", i, String.format("%.1f", (double) i * 9 / 5 + 32));
        }
    }

    /**
     * 5.4 Print a table with the conversion between inches and meters.
     */
    static void inchToMeters() {
        System.out.format("%-7s     %7s\n", "Celsius", "Fahrenheit");

        for (int i = 1; i <= 10; i++) {
            System.out.format("%-7s        %7s\n", i, String.format("%.2f", i * 2.54));
        }
    }

    /**
     * 5.5 Prints a table for the Celsius to Fahrenheit conversion. (Both ways)
     */
    static void convertCToFFToC() {
        int fahrenheit = 20;
        double fahrenheitFromCelsius,
                celsiusFromFahrenheit;

        System.out.format("%-7s    %7s   |   %-7s     %7s\n", "Celsius", "Fahrenheit", "Fahrenheit", "Celsius");

        for (int celsius = 0; celsius <= 100; celsius += 2) {
            fahrenheitFromCelsius = (double) celsius * 9 / 5 + 32;
            celsiusFromFahrenheit = ((double) fahrenheit - 32) * 5 / 9;

            System.out.format("%-7s       %7s   |   %-7s     %10s\n", celsius, String.format("%.3f", fahrenheitFromCelsius), fahrenheit, String.format("%.3f", celsiusFromFahrenheit));
            fahrenheit = fahrenheit + 5;
        }
    }

    static void compareLoans() {
        double percentage = 0.05,
                percentageIncrease = 0.0025,
                monthlyPayment = 188.71,
                monthlyIncrement = 0.015,
                tempMonthly = 0,
                totalPayment = 0;

        System.out.print("Loan amount: ");
        double loanAmount = scanner.nextDouble();
        System.out.print("Number of years: ");
        double numberOfYears = scanner.nextInt();

        System.out.format("%-10s   %10s   %10s\n", "Interest Rate", "Monthly Payment", "Total Payment");

        for (int rates = 1; rates <= numberOfYears * 4 + 1; rates++) {
            tempMonthly = monthlyPayment +  rates + monthlyIncrement;
            for (int month = 1; month <= numberOfYears * 12; month++) {
                totalPayment += monthlyPayment * Math.pow(1 + percentage, month);
            }
            System.out.format("%-6s   %6s    %8s\n", String.format("%.3f", percentage * 100), String.format("%.2f", tempMonthly), String.format("%.2f", totalPayment));
            percentage += percentageIncrease;
        }
    }

    /**
     * 5.6 Prints a table for the ping and square meter conversion.
     */
    static void squareMeterToPing() {
        int squareMeters = 30;
        System.out.format("%-7s %7s   |   %-7s %7s\n", "Ping", "Square meter", "Square meter", "Ping");
        for (int ping = 10; ping <= 80; ping += 5) {
            System.out.format("%-7s      %7s   |   %-7s      %7s\n", ping, String.format("%.3f", ping * 3.305), squareMeters, String.format("%.3f", squareMeters / 3.305));
            squareMeters += 5;
        }
    }

    /**
     * 5.7 Computes the tuition after 10 years and then the cost of the four
     * years after that.
     */
    static void computeFutureTuition() {
        double startTuition = 10_000,
                fourYearTuitionCost = 0,
                percentage = 0.06;

        double tenYearTuition = startTuition * Math.pow((1 + percentage), 10);

        for (int year = 11; year <= 14; year++) {
            fourYearTuitionCost += startTuition * Math.pow((1 + percentage), year);
        }

        System.out.format("The tuition after 10 years is: $%,.2f\n", tenYearTuition);
        System.out.format("The cost of four years after the tenth year is: $%,.2f", fourYearTuitionCost);
    }

    /**
     * 5.8 Finds the best student from the prompted number of students their
     * corresponding name and score.
     */
    static void findHighestScore() {
        String name;
        String bestStudent = "";

        int score;
        int highestScore = 0;

        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        for (int i = 1; i <= numberOfStudents; i++) {
            System.out.print("Enter the name and score of student number " + i + ". [name score]: ");
            name = scanner.next();
            score = scanner.nextInt();

            if (highestScore < score) {
                highestScore = score;
                bestStudent = name;
            }
        }

        System.out.println("The best student between the " + numberOfStudents + " is " + bestStudent + " with a score of " + highestScore);
    }

    
    static void displayPyramid() {
        System.out.print("Enter the number of lines: ");
        int numberOfLines = scanner.nextInt();

        for (int i = 1; i <= numberOfLines * 2 - 1; i++) {
            if (i >= numberOfLines / 2) {
                for (int j = i; j <= numberOfLines; j++) {
                    System.out.print(j + " ");
                }
            } else {
                for (int j = i; j <= numberOfLines; j++) {
                    System.out.print(j + " ");
                }
            }
            System.out.println("");
        }
    }

    /**
     * 5.18 Displays the chosen pattern to the user.
     */
    static void displayPattern() {
        System.out.print("Choose what pattern to display: ");
        String pattern = scanner.next();

        switch (pattern) {
            case "A":
                for (int i = 1; i <= 6; i++) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print("* ");
                    }
                    System.out.println("");
                }
                break;
            case "B":
                for (int i = 6; i >= 1; i--) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print("* ");
                    }
                    System.out.println("");
                }
                break;
            case "C":
                for (int i = 6; i >= 1; i--) {
                    for (int j = 1; j <= 6; j++) {
                        if (j >= i) {
                            System.out.print("* ");
                        } else {
                            System.out.print("  ");
                        }
                    }
                    System.out.println("");
                }
                break;
            case "D":
                for (int i = 1; i <= 6; i++) {
                    for (int j = 1; j <= 6; j++) {
                        if (j >= i) {
                            System.out.print("* ");
                        } else {
                            System.out.print("  ");
                        }
                    }
                    System.out.println("");
                }
                break;
            default:
                System.out.println("Pattern doesn't exist.");
                break;
        }
    }
}
