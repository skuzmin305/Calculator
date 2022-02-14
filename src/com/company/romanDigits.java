package com.company;

import java.util.ArrayList;

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
