package chapter_06_exercises;

import java.util.Scanner;

/**
 *
 * @author Samuel Bangslund
 */
public class Chapter_06_Exercises {

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
            System.out.print("Enter an integer corresponding to the exercise you want to run in this chapter (i.e 1 for 6.1): ");
            programToRun = scanner.nextInt();
        }

        switch (programToRun) {
            case 2:
                System.out.println((sumDigits(543623)));
                break;
            case 3:
                System.out.println("The reversed number of 12345 is equal to " + reverse(12345));
                System.out.println("Is 121 palindrome? " + isPalindrome(121));
                break;
            case 4:
                displayReverse(847287);
                break;
            case 7:
                displayInvestmentValue();
                break;
            case 8:
                displayConversionTable();
                break;
            case 14:
                displayPIEstimate(900);
                break;
            case 22:
                System.out.print("The approximate squareroot of 9 is: ");
                System.out.println(approximateSqrt(9));
                break;
            case 25:
                System.out.println(convertMillis(555_550_000));
                break;
            case 28:
                printMersennaPrimeTable(31);
                break;
            default:
                System.err.println("This program only has 9 sub-programs. The argument " + programToRun + " does not match any of the programs.");
                break;
        }
    }

    /**
     * 6.2 Adds together all the integers in the number. (i.e sumDigits(12) = 3)
     *
     * @param n the number.
     * @return the sum of the added integers.
     */
    static int sumDigits(long n) {
        String integers = Long.toString(n);
        char[] integersAsCharArray = integers.toCharArray();
        int sum = 0;

        for (int i = 0; i < integersAsCharArray.length; i++) {
            sum += Character.getNumericValue(integersAsCharArray[i]);
        }

        return sum;
    }

    /**
     * 6.3a Reverses the composition of the number. (i.e reverse(123) = 321)
     *
     * @param number to reverse
     * @return the reversed number.
     */
    static int reverse(int number) {
        char[] numbersAsChar = Integer.toString(number).toCharArray();
        String reversedNumber = "";

        for (int i = numbersAsChar.length; i > 0; i--) {
            reversedNumber += numbersAsChar[i - 1];
        }

        return Integer.parseInt(reversedNumber);
    }

    /**
     * 6.3b Checks if the number is palindrome. (isPalindrome(121) = true)
     *
     * @param number to check.
     * @return true if the number is palindrome.
     */
    static boolean isPalindrome(int number) {
        return number == reverse(number);
    }

    /**
     * 6.4 Displays the reverse number of the given number.
     *
     * @param number to reverse and display.
     */
    static void displayReverse(int number) {
        System.out.println("The reverse number of " + number + " is " + reverse(number));
    }

    /**
     * 6.7 Displays the calculated investment value based on the user inputs.
     * Makes use of the futureInvestmentValue().
     */
    static void displayInvestmentValue() {
        System.out.print("The amount invested: ");
        double investmentValue = scanner.nextDouble();
        System.out.print("Annual interest rate (in %): ");
        double annualInterestRate = scanner.nextDouble() / 100;

        int years = 30;

        System.out.format("%5s     %12s\n", "Years", "Future Value");

        for (int i = 1; i <= years; i++) {
            double annualInterest = futureInvestmentValue(investmentValue, annualInterestRate / 12, i);
            System.out.format("%-2s            %8s\n", i, String.format("%,.2f", annualInterest));
        }
    }

    /**
     * 6.7 Returns the investment value calculated from the given parameters.
     * constant * (1 + percent)^period
     *
     * @param investmentValue initial value.
     * @param monthlyInterestRate how much the value should be incremented. (in
     * percent)
     * @param years number of years.
     * @return the final investment value of the given period.
     */
    static double futureInvestmentValue(double investmentValue, double monthlyInterestRate, int years) {
        return investmentValue * Math.pow(1 + monthlyInterestRate, years * 12);
    }

    /**
     * 6.8 Displays the conversion between km and miles in a table. Makes use of
     * the mileToKilometer() method and the kilometerToMile() method.
     */
    static void displayConversionTable() {
        System.out.format("%s     %s     |     %s     %s\n", "Miles", "Kilometers", "Kilometers", "Miles");
        int kmCount = 20;

        for (int i = 1; i <= 10; i++) {
            System.out.format("%-3s            %5s     |     %-3s           %6s\n",
                    i, String.format("%.1f", mileToKilometer(i)), kmCount, String.format("%.3f", kilometerToMile(kmCount)));

            kmCount += 5;
        }
    }

    /**
     * 6.8 Converts miles to kilometers.
     *
     * @param mile to convert.
     * @return amount of kilometers.
     */
    static double mileToKilometer(double mile) {
        return mile * 1.609;
    }

    /**
     * 6.8 Converts kilometers to miles.
     *
     * @param kilometer to convert.
     * @return amount of miles.
     */
    static double kilometerToMile(double kilometer) {
        return kilometer / 1.609;
    }

    /**
     * 6.14 Displays the estimation of pi as a table. The higher the i, the
     * closer the estimation gets. (This method uses the estimatePI() method.)
     *
     * @param i
     */
    static void displayPIEstimate(int i) {
        System.out.format("%s            %s\n", "i", "m(i)");

        for (int j = 1; j <= i + 100; j += 100) {
            System.out.format("%-10s        %6s\n", j, String.format("%.8f", estimatePI(j)));
        }
    }

    /**
     * 6.14 Estimates pi based on the number of iterations.
     *
     * @param i number of iterations.
     * @return the estimation of pi.
     */
    static double estimatePI(int i) {
        double factor = 1;
        for (int j = 2; j < i; j++) {
            factor += Math.pow(-1, j + 1) / (2 * j - 1);
        }

        return 4 * factor;
    }

    /**
     * 6.22 Will approximate square root of the number provided.
     *
     * @param number to find the square root of.
     * @return The approximate square number.
     */
    static double approximateSqrt(double number) {
        double lastGuess = 1;
        double nextGuess;

        while (true) {
            nextGuess = (lastGuess + number / lastGuess) / 2;

            if (Math.abs(nextGuess - lastGuess) > 0.0001) {
                lastGuess = nextGuess;
            } else {
                return nextGuess;
            }
        }
    }

    /**
     * 6.25 Converts milliseconds into a hours:minutes:seconds string format.
     *
     * @param millis to convert.
     * @return A string with the format: hours:minutes:seconds.
     */
    static String convertMillis(long millis) {
        long hours = millis / 1000 / 60 / 60;
        long minutes = millis / 1000 / 60 % 60;
        long seconds = millis / 1000 % 60;

        return hours + ":" + minutes + ":" + seconds;
    }

    /**
     * 6.28 Prints the prime -> Mersenna table.
     *
     * @param limit Max prime to check for Mersenna prime.
     */
    static void printMersennaPrimeTable(int limit) {
        System.out.format("%1s       %7s\n", "p", "2^p - 1");
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                int mersenna = (int) (Math.pow(2, i) - 1);
                if (isPrime(mersenna)) {
                    System.out.format("%-3s     %-3s\n", i, String.format("%,d", mersenna));
                }
            }
        }
    }

    /**
     * 6.28a Checks to see if the number is prime.
     *
     * @param number to check.
     * @return true if the number is a prime number.
     */
    static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
