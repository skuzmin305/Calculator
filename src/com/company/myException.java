package com.company;

class myException extends Exception{
    private int operand_1;
    private int operand_2;

    public myException(String message) {

        System.err.println(message);
    }
}