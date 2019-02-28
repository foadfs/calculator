package com.company;

import java.util.Scanner;

public class NumberUtils {
    Scanner scanner;
    String operation="" ;
    int firstNumber = 0, secondNumber = 0, result = 0;
    public void menu() {
        String select;
        System.out.println("1-continue\n2-Exit");
        scanner = new Scanner(System.in);
        select = scanner.nextLine();
        switch (select) {
            case "1":
                firstNumber = getNumber("enter first number:");
                secondNumber= getNumber("enter second number:");
                operation = getOperation();
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
        while (!operation.equals("+") && !operation.equals("-") && !operation.equals("/") && !operation.equals("*") &&
                !operation.equals("%")) {
            getoper();
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

    private String getoper(){
        System.out.println("please enter your operation: ");
        operation = scanner.nextLine();
        switch (operation) {
            case "+":
                result=firstNumber+secondNumber;
                System.out.println(messageOper("+"));
            break;
            case "-":
                result=firstNumber-secondNumber;
                System.out.println(messageOper("-"));
            break;
            case "*":
                result=firstNumber*secondNumber;
                System.out.println(messageOper("*"));
            break;
            case "/":
                result=firstNumber/secondNumber;
                System.out.println(messageOper("/"));
            break;
            case "%":
                result=firstNumber%secondNumber;
                System.out.println(messageOper("%"));
            default:
                System.out.println("\n Please enter only '/' or '*' or '-' or '+' or '%'"); }
        return operation;
    }

    private String messageOper(String messageopera){
        String mss=firstNumber+messageopera+secondNumber+"="+result;
   return mss;
    }
}
