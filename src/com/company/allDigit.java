package com.company;

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
