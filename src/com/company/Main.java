package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) throws myException {
        Scanner scan = new Scanner(System.in);
        while(true) {
            String scanStr = scan.nextLine();
            if(scanStr.split(" ").length > 3){
                throw new myException("throws Exception //т.к. формат " +
                        "математической операции не удовлетворяет заданию " +
                        "- два операнда и один оператор (+, -, /, *)");
            }else if(scanStr.split(" ").length < 3){
                throw new myException("throws Exception //т.к. строка не является математической операцией");
            }else {
                System.out.println(allDigit.mathOperation(scanStr.split(" ")));
            }
        }
    }
}

class allDigit{
    public static boolean isDigit(String operand){
        try {
            Integer.parseInt(operand);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }
    public static String mathOperation(String[] operation) throws myException{
        if(isDigit(operation[0]) && isDigit(operation[2])) {
            int operand_1 = Integer.parseInt(operation[0]);
            int operand_2 = Integer.parseInt(operation[2]);
            String operator = operation[1].toString();
            int result = 0;
            switch (operator) {
                case "+":
                    result = operand_1 + operand_2;
                    break;
                case "-":
                    result = operand_1 - operand_2;
                    break;
                case "*":
                    result = operand_1 * operand_2;
                    break;
                case "/":
                    result = operand_1 / operand_2;
            }
            return String.valueOf(result);
        }else if(!isDigit(operation[0]) && !isDigit(operation[2])){
            operation[0] = String.valueOf(romanDigits.parseInteger(operation[0]));
            operation[2] = String.valueOf(romanDigits.parseInteger(operation[2]));
            int digitForConvert = Integer.parseInt(mathOperation(operation));
            if(digitForConvert <= 0){
                throw new myException("throws Exception //т.к. в римской системе нет отрицательных чисел");
            }else {
                return romanDigits.convertToRoman(digitForConvert);
            }
        }else{
            throw new myException("throws Exception //т.к. используются одновременно разные системы счисления");
        }
    }
}
class romanDigits{
    static int number = 0;

    public static int parseInteger(String numb) throws myException {
        switch (numb) {
            case "I" -> number = 1;
            case "II" -> number = 2;
            case "III" -> number = 3;
            case "IV" -> number = 4;
            case "V" -> number = 5;
            case "VI" -> number = 6;
            case "VII" -> number = 7;
            case "VIII" -> number = 8;
            case "IX" -> number = 9;
            case "X" -> number = 10;
            default -> number = 0;
        }
        if(number < 1 && number > 10){
            throw new myException("throws Exception //т.к. операнды должны быть от 1 до 0 включительно");
        }else{
            return number;
        }
    }
    public static String convertToRoman(int numb){
        String resultValue = "";
        ArrayList romanMap = new ArrayList<>();
        romanMap.add("I");
        romanMap.add("IV");
        romanMap.add("V");
        romanMap.add("IX");
        romanMap.add("X");
        romanMap.add("XL");
        romanMap.add("L");
        romanMap.add("XC");
        romanMap.add("C");

        ArrayList arabicMap = new ArrayList<>();
        arabicMap.add(1);
        arabicMap.add(4);
        arabicMap.add(5);
        arabicMap.add(9);
        arabicMap.add(10);
        arabicMap.add(40);
        arabicMap.add(50);
        arabicMap.add(90);
        arabicMap.add(100);

        for(int i = 8; i >= 0; i--){
            int item = Integer.parseInt(arabicMap.get(i).toString());
            while (numb >= item){
                resultValue += romanMap.get(i);
                numb -= item;
            }
        }
        return resultValue;
    }
}

class myException extends Exception{
    private int operand_1;
    private int operand_2;

    public myException(String message) {

        System.err.println(message);
    }
}