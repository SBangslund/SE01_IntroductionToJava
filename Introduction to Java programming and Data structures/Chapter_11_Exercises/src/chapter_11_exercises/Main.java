package chapter_11_exercises;

import chapter_11_exercises._01.*;
import chapter_11_exercises._02.*;
import chapter_11_exercises._03.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Samuel Bangslund
 */
public class Main {
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
            System.out.print("Enter an integer corresponding to the exercise you want to run in this chapter (i.e 1 for 11.1): ");
            programToRun = scanner.nextInt();
        }

        switch (programToRun) {
            case 1:
                _01_Test();
                break;
            case 2:
                _02_Test();
                break;
            case 3:
                _03_Test();
                break;
            case 4:
                ArrayList<Integer> list = new ArrayList();
                list.add(10);
                list.add(4);
                list.add(7);
                System.out.println(_04_Test(list));
                break;
            case 8:
                _08_Test();
                break;
            default:
                System.err.println("This program only has 9 sub-programs. The argument " + programToRun + " does not match any of the programs.");
                break;
        }
    }
    
    static void _01_Test() {
        System.out.print("Enter the parameters"
                + "(double side1, double side2, double side3, String color, boolean isFilled) "
                + "to create a triangle: ");
        
        double side1 = scanner.nextDouble();
        double side2 = scanner.nextDouble();
        double side3 = scanner.nextDouble();
        String color = scanner.next();
        boolean isFilled = scanner.nextBoolean();
        
        Triangle triangle = new Triangle(side1, side2, side3, color, isFilled);
        
        System.out.println(triangle);
        System.out.println("The triangle has an area of: " + triangle.getArea());
        System.out.println("and a perimeter of: " + triangle.getPerimeter());
    }
    
    static void _02_Test() {
        Person person = new Person("Mads Ingerson", "Odensevejarbejde 247", "12345678", "fedthår14@coolmail.dk");
        Student student = new Student("Software Engineering");
        Employee employee = new Employee(124, 25000);
        Faculty faculty = new Faculty(201, 26000, "Øv tider", "Salesman");
        Staff staff = new Staff(250, 25000, "Cleaner");
        
        System.out.println(person);
        System.out.println(student);
        System.out.println(employee);
        System.out.println(faculty);
        System.out.println(staff);
    }
    
    static void _03_Test() {
        Account account = new Account(2919_3919, 10_000);
        SavingsAccount savings = new SavingsAccount(8423_5123, 8_000);
        CheckingsAccount checking = new CheckingsAccount(7572_4123, 4_000, -1000);
        
        // Testing toString() overrides.
        System.out.println("\nTesting toString() overrides.");
        System.out.println(account);
        System.out.println(savings);
        System.out.println(checking);
        
        // Try to withdraw more than there is in the account.
        System.out.println("\nTry to withdraw more than there is in the account.");
        savings.withdraw(9_000);    // There is 8_000$ in the account.
        checking.withdraw(5_000);   // There is 4_000$ in the account.
        System.out.println(savings);
        System.out.println(checking);
    }
    
    static Integer _04_Test(ArrayList<Integer> arrayList) {
        if( arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        
        int max = 0;
        for(Integer number : arrayList) {
            max = number > max ? number : max;
        }
        
        return max;
    }
    
    static void _08_Test() {
        chapter_11_exercises._08.Account account = new chapter_11_exercises._08.Account("George", 1122, 1_000, 1.5);
        
        account.deposit(30);
        account.deposit(40);
        account.deposit(50);
        
        account.withdraw(5);
        account.withdraw(4);
        account.withdraw(2);
        
        account.printAccountSummary();
    }
}
