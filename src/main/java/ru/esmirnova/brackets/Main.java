package ru.esmirnova.brackets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // input the brackets
        System.out.println("Enter the brackets sequence:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputBracketsString = reader.readLine();

        System.out.println("Enter the brackets matching strategy:");
        System.out.println("1 - match the earliest brackets in line");
        System.out.println("2 - match the closest to each other brackets");
        String strategyString = reader.readLine();

        AbstractStrategy str;
        if (strategyString.equals("1")) {
            str = new EarliestBracketStrategy(inputBracketsString);
        } else if (strategyString.equals("2")) {
            str = new ClosestBracketsStrategy(inputBracketsString);
        } else {
            System.out.println("Invalid strategy chosen. Defaulting to strategy 1.");
            str = new EarliestBracketStrategy(inputBracketsString);
        }
        String correctBracketsString = str.getValidBrackets();

        // Printing the correct brackets
        if (correctBracketsString.length()>0) {
            System.out.println(correctBracketsString.length() + " - \"" + correctBracketsString + "\"");
        } else {
            System.out.println(0);
        }
    }
}