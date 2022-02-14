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