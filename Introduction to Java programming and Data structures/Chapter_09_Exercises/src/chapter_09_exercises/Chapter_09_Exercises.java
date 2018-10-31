package chapter_09_exercises;

import java.util.Scanner;

/**
 * @author Samuel Bangslund
 */
public class Chapter_09_Exercises {

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
            System.out.print("Enter an integer corresponding to the exercise you want to run in this chapter (i.e 1 for 9.1): ");
            programToRun = scanner.nextInt();
        }

        switch (programToRun) {
            case 1:
                exercise_9_1();
                break;
            case 2:
                exercise_9_2();
                break;
            case 3:
                exercise_9_3();
                break;
            case 4:
                exercise_9_4();
                break;
            case 6:
                exercise_9_6();
                break;
            case 7:
                exercise_9_7();
                break;
            case 8:
                exercise_9_8();
                break;
            case 9:
                exercise_9_9();
                break;
            default:
                System.err.println("This program only has 7 sub-programs. The argument " + programToRun + " does not match any of the programs.");
                break;
        }
    }

    static void exercise_9_1() {
        _9_1_Rectangle rectangle1 = new _9_1_Rectangle(4, 40);
        _9_1_Rectangle rectangle2 = new _9_1_Rectangle(3.5, 35.9);

        System.out.println("Width: " + rectangle1.getWidth() + " Height: " + rectangle1.getHeight() + " Perimeter: " + rectangle1.getPerimeter());
        System.out.println("Width: " + rectangle2.getWidth() + " Height: " + rectangle2.getHeight() + " Perimeter: " + rectangle2.getPerimeter());
    }

    static void exercise_9_2() {
        _9_2_Stock stock1 = new _9_2_Stock("ORCL", "Oracle Corporation");
        stock1.setPreviousClosingPrice(34.5);
        stock1.setCurrentPrice(34.35);

        System.out.format("The price has changed %.2f%s\n", stock1.getChangePercent(), "%");
    }

    static void exercise_9_3() {
        _9_3_Date[] dates = {
            new _9_3_Date(1_000),
            new _9_3_Date(100_000),
            new _9_3_Date(1_000_000),
            new _9_3_Date(10_000_000),
            new _9_3_Date(100_000_000),
            new _9_3_Date(1_000_000_000),
            new _9_3_Date(10_000_000_000L),
            new _9_3_Date(100_000_000_000L)
        };

        for(_9_3_Date date : dates) {
            System.out.println(date.getDate());
        }
    }
    
    static void exercise_9_4() {
        for(int number : new _9_4_Random(1000).getNumberOfRandoms(50, 0, 100)) {
            System.out.println(number);
        }
    }
    
    static void exercise_9_6() {
        _9_6_StopWatch stopWatch = new _9_6_StopWatch();
        
        int[] arr = new int[100_000];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 100);
        }
        
        stopWatch.startTime();
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index]) 
                    index = j;
      
            int smallerNumber = arr[index];  
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        stopWatch.stopTime();
        System.out.println("The sort took " + stopWatch.getElapsedTime() / 1000 + " seconds.");
    }
    
    static void exercise_9_7() {
        _9_7_Account account = new _9_7_Account(1122, 20_000);
        account.setAnnualInterestRate(4.5);
        
        account.withdraw(2_500);
        account.deposit(3_000);
        
        System.out.format("Balance:[%s]  Montly:[%s]  Date:[%s]\n", account.getBalance(), account.getMontlyInterest(), account.getDateCreated());
    }
    
    static void exercise_9_8() {
        _9_8_Fan fan1 = new _9_8_Fan(3, 10, "Yellow");
        fan1.isOn(true);
        
        _9_8_Fan fan2 = new _9_8_Fan(2, 5, "Blue");
        
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
    
    static void exercise_9_9() {
        _9_9_RegularPolygon poly1 = new _9_9_RegularPolygon();
        _9_9_RegularPolygon poly2 = new _9_9_RegularPolygon(6, 4);
        _9_9_RegularPolygon poly3 = new _9_9_RegularPolygon(10, 4, 5.6, 7.8);
        
        System.out.format("Perimeter:[%s]  Area:[%.2f]\n", poly1.getPerimeter(), poly1.getArea());
        System.out.format("Perimeter:[%s]  Area:[%.2f]\n", poly2.getPerimeter(), poly2.getArea());
        System.out.format("Perimeter:[%s]  Area:[%.2f]\n", poly3.getPerimeter(), poly3.getArea());
    }
}
