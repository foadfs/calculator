package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class NumberUtils {
    Scanner scanner;
    String path;
    String operation="" ;
    int firstNumber = 0, secondNumber = 0, result = 0;
    ArrayList TemporaryStorage= new ArrayList();
    public void menu() {
        String option;
        System.out.println("menu:\n1-continue\n2-save the calculations\n2-Exit");
        scanner = new Scanner(System.in);
        option = scanner.nextLine();
        switch (option) {
            case "1":
                firstNumber = getNumber("enter first number:");
                secondNumber= getNumber("enter second number:");
                operation = getOperation();
                operation="";
                break;
            case "2":
                writeCreateFile(TemporaryStorage.toString());
                break;
            case "3":
                System.exit(1);
                break;
            default:
                System.out.println("menu:\n1-continue\n2-save the calculations\n3-Exit");
                break;
        }
    }

    private String getOperation() {
        while (!operation.equals("+") && !operation.equals("-") && !operation.equals("/") && !operation.equals("*") &&
                !operation.equals("%")) {
            System.out.println("please enter your operation: ");
            operation = scanner.nextLine();
            doCalculator(operation);
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
                System.err.println("That is not a number, please try again. ");
                retry = false;
            }
        }
        return a;
    }
    private String messageOper(String messageOpera){
        String mss=firstNumber+messageOpera+secondNumber+"="+result;
        TemporaryStorage.add(mss);
        return mss;
    }

    private void writeCreateFile(String str){
        try {
            System.out.println("please enter your path file:\n (for example :c:\\data\\myfile.txt ) " );
            path = scanner.nextLine();
            File file= new File(path);
            FileWriter fileWriter=new FileWriter(file,true);
            BufferedWriter out = new BufferedWriter(fileWriter);
            out.write(str);
            out.newLine();
            out.close();
            System.out.println("The file was successfully writed");
        }catch (IOException e){
            System.err.println("error!");
        }
    }
    private int doCalculator(String operation){
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
                try {
                    result = firstNumber / secondNumber;
                    System.out.println(messageOper("/"));
                }catch (ArithmeticException e){
                    System.err.println("you can not divided by zero! ");
                }
                break;
            case "%":
                result=firstNumber%secondNumber;
                System.out.println(messageOper("%"));
            default:
                System.err.println("\n Please enter only '/' or '*' or '-' or '+' or '%'"); }
        return result;
    }
}
