package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberUtils {
    public static void menu() {
        String select;
        System.out.println("1-continue\n2-Exit");
        Scanner scanner = new Scanner(System.in);
        select = scanner.nextLine();
        switch (select) {
            case "1":
                int a = 0, b = 0, c = 0;
                String o = "";
                boolean retry = false;
                while (!retry) {
                    try {
                        System.out.println("enter first number:");
                        a = Integer.parseInt(scanner.nextLine());
                        retry = true;
                    } catch (NumberFormatException e) {
                        retry = false;
                        System.out.println("That is not a number, please try again. ");
                    }
                }
                retry = false;
                while (!retry) {
                    try {
                        System.out.println("enter second number:");
                        b = Integer.parseInt(scanner.nextLine());
                        retry = true;
                    } catch (NumberFormatException e) {
                        retry = false;
                        System.out.println("That is not a number, please try again. ");
                    }
                }
                System.out.println("enter operation:");
                o = scanner.nextLine();
                switch (o) {
                    case "+":
                        System.out.println("Addition of " + a + " and " + b + " : " + (a + b));
                        break;
                    case "-":
                        System.out.println("Subtraction of " + a + " and " + b + " : " + (a - b));
                        break;
                    case "*":
                        System.out.println("Multiplication of " + a + " and " + b + " : " + (a * b));
                        break;
                    case "/":
                        try {
                            System.out.println("Division of " + a + " and " + b + " : " + (a / b));
                        } catch (ArithmeticException ae) {
                            System.out.println("ArithmeticException occurred!");
                        }
                        break;
                    case "%":
                        System.out.println("Modulo of " + a + " and " + b + " : " + (a % b));
                        break;
                    default:
                        System.out.println("Please Enter '+', '-', '*', '/' & '%' operator only.");
                }
                break;
            case "2":
                System.exit(1);
                break;

            default:
                System.out.println("1-continue\n2-Exit");
                break;
        }
    }
}
