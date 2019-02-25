package com.company;

import java.util.Scanner;

public class NumberUtils {
    Scanner scanner;

    public void menu() {
        String select;
        System.out.println("1-continue\n2-Exit");
        scanner = new Scanner(System.in);
        select = scanner.nextLine();
        switch (select) {
            case "1":
                int a = 0, b = 0, c = 0;
                String o = "";
                a = getNumber("enter first number:");
                b = getNumber("enter second number:");
                String opr = getOperation();
                break;
            case "2":
                System.exit(1);
                break;
            default:
                System.out.println("1-continue\n2-Exit");
                break;
        }
    }

    private String getOperation() {
        String operation = "";
        while (!operation.equals("+") && !operation.equals("-") && !operation.equals("/") && !operation.equals("*") &&
                !operation.equals("%")) {
            System.out.println("please enter your operation: ");
            operation = scanner.nextLine();
        }
        return operation;
    }

    private int getNumber(String message) {
        int a = 0;
        boolean retry = false;
        while (!retry) {
            try {
                System.out.println(message);
                a = Integer.parseInt(scanner.nextLine());
                retry = true;
            } catch (NumberFormatException e) {
                retry = false;
                System.out.println("That is not a number, please try again. ");
            }
        }
        return a;
    }

}
