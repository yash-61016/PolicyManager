/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.policymanager;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author yashpatel
 */
public class calculations {

    public static int premium(int numOfGad, int mostExpGad, boolean valGadget, boolean valMostExpGad) { //calculating premium according to the given table
        if (valGadget == false || valMostExpGad == false) {
            return -1;
        } else if (numOfGad == 1 && mostExpGad < 500) {
            return 599;
        } else if ((numOfGad == 2 || numOfGad == 3) && mostExpGad < 500) {
            return 1099;
        } else if ((numOfGad == 4 || numOfGad == 5) && mostExpGad < 500) {
            return 1599;
        } else if (numOfGad == 1 && (mostExpGad >= 500 && mostExpGad < 800)) {
            return 715;
        } else if ((numOfGad == 2 || numOfGad == 3) && (mostExpGad >= 500 && mostExpGad < 800)) {
            return 1335;
        } else if ((numOfGad == 4 || numOfGad == 5) && (mostExpGad >= 500 && mostExpGad < 800)) {
            return 1960;
        } else if (numOfGad == 1 && (mostExpGad >= 800 && mostExpGad <= 1000)) {
            return 830;
        } else if ((numOfGad == 2 || numOfGad == 3) && (mostExpGad >= 800 && mostExpGad <= 1000)) {
            return 1555;
        } else if ((numOfGad == 4 || numOfGad == 5) && (mostExpGad >= 800 && mostExpGad <= 1000)) {
            return 2282;
        } else {
            return -1;
        }
    }

    public static int excessDiscount(int excess, int numOfGad, int mostExpGad, boolean valGadget, boolean valMostExpGad) { //returns discounted amount according to the excess amount

        int premium = (premium(numOfGad, mostExpGad, valGadget, valMostExpGad)); // getting premium amount according to table
        int discount = 0;
        switch (validation.valExcess(excess)) {//cheching for the excess amount
            case 30:
                discount = 0;
                break;
            case 40:
                discount = 5;
                break;
            case 50:
                discount = 10;
                break;
            case 60:
                discount = 15;
                break;
            case 70:
                discount = 20;
                break;
            default:
                break;
        }
        premium = premium - discount / 100;
        return premium;
    }

    public static int finalPremium(char pay, int excess, int numOfGad, int mostExpGad, boolean valGadget, boolean valMostExpGad) { //returning the discounted amount accourding to if user has selected to pay annually or monthly
        int finalPremium;
        int premium = excessDiscount(excess, numOfGad, mostExpGad, valGadget, valMostExpGad);//getting premium discounted according to excess

        if (pay == 'Y') {
            finalPremium = (int) (12 * (premium - (premium * 0.1)));
        } else {
            finalPremium = premium;
        }
        return finalPremium;
    }

    public static int getLimitPerGad(int gadget) { // calculates the limit per gadget according to the given table
        if (gadget < 500) {
            return 500;
        } else if (gadget > 500 && gadget < 800) {
            return 800;
        } else {
            return 1000;
        }
    }

    public static void policyToFile(String name, String ref, int numOfGad, int mostExpGad, int excess, int premium, char terms, String date) {

        PrintWriter output = null;

        File policy = new File("policy.txt");// create new filestream
        try {
            FileWriter fw = new FileWriter(policy, true);// create new filewriter
            output = new PrintWriter(fw);

            } 
        catch (FileNotFoundException e) {// catch file exceptions
            System.out.println("Problem creating file.");
            System.exit(0);
        } 
        catch (IOException ex) {
            System.out.println("Problem creating file.");
            System.exit(0);
        }

        //output details in correct format to file
        output.print(date);
        output.print("\t");
        output.print(ref);
        output.print("\t");
        output.print(numOfGad);
        output.print("\t");
        output.print(mostExpGad);
        output.print("\t");
        output.print(excess);
        output.print("\t");
        output.print(premium);
        output.print("\t");
        output.print(terms);
        output.print("\t");
        output.print(name);

        output.print("\n");

        output.close();

    }

    public static int get_avgItems(int items, int acpt_policies) { // Calculates average number of items
        return items / acpt_policies;
    }

    public static int get_monthlyPremium(int total_premium, int accepted_policies) { // Calculates average monthly premium
        return total_premium / accepted_policies;
    }

    public static int get_Month(String date) {// calculates the month number from the date
        String month = "";
        //get month name from date
        char ch1 = date.charAt(3);
        char ch2 = date.charAt(4);
        char ch3 = date.charAt(5);
        month = month + ch1 + ch2 + ch3;
        // check the month name and returns the month number
        if (month.equalsIgnoreCase("Jan")) {
            return 1;
        } else if (month.equalsIgnoreCase("Feb")) {
            return 2;
        } else if (month.equalsIgnoreCase("Mar")) {
            return 3;
        } else if (month.equalsIgnoreCase("May")) {
            return 4;
        } else if (month.equalsIgnoreCase("Apr")) {
            return 5;
        } else if (month.equalsIgnoreCase("Jun")) {
            return 6;
        } else if (month.equalsIgnoreCase("Jul")) {
            return 7;
        } else if (month.equalsIgnoreCase("Aug")) {
            return 8;
        } else if (month.equalsIgnoreCase("Sep")) {
            return 9;
        } else if (month.equalsIgnoreCase("Oct")) {
            return 10;
        } else if (month.equalsIgnoreCase("Nov")) {
            return 11;
        } else if (month.equalsIgnoreCase("Dec")) {
            return 12;
        } else {
            return 0;
        }
    }

    public static void print_agvMonth(int[] arr) {// Prints the average month in the given format
        System.out.println("Number of Policies per month(incl. rejected):");
        System.out.println("Jan\tFeb\tMar\tArp\tMay\tJun\tJul\tAug\tSep\tOct\tNov\tDec");
        System.out.println(arr[0] + "\t" + arr[1] + "\t" + arr[2] + "\t" + arr[3] + "\t" + arr[4] + "\t" + arr[5] + "\t" + arr[6] + "\t" + arr[7] + "\t" + arr[8] + "\t" + arr[9] + "\t" + arr[10] + "\t" + arr[11]);
    }

    public static String get_month(int month_num) {//Returns the month name by checking month number
        switch (month_num) {
            case 1:
                return "January";
            case 2:
                return "Febeaury";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "selected month";
        }
    }

    public static boolean check_ref(String text, String ref) {//Checks the refrence number with the given text
        return ref.toLowerCase().contains(text.toLowerCase());
    }

    public static boolean check_name(String text, String name) {//Checks the name with the given text
        return name.toLowerCase().contains(text.toLowerCase());
    }

    public static String get_policy(int index, String[] array) {// returns just name or refrence number deleting the line number from array
        String arr = array[index - 1];
        
        String policy = "";
        arr = arr.replaceFirst("([0-9])", "");
        
        for(int i = 2; i < arr.length(); i++){
            policy = policy + arr.charAt(i);
        }
        if (policy.charAt(0) < 'A' || policy.charAt(0) > 'Z'){
            policy = policy.replaceFirst("\\s", "");
        }
        return policy;
    }

    public static void printPolicy(String client, String ref, int numOfGad, int mostExpGad, int excess, int premium,  char term, String date) {//printing the policy in the given format
        System.out.print("+");
        for (int i = 0; i < 45; i++) {
            System.out.print("=");
        }
        System.out.println("+");

        System.out.print("|");
        for (int i = 0; i < 45; i++) {
            System.out.print(" ");
        }
        System.out.println("|");

        System.out.print("|");
        for (int i = 0; i < 3; i++) {
            System.out.print(" ");
        }
        System.out.print("Client:");
        System.out.print(client);
        for (int i = 0; i < 35 - client.length(); i++) {
            System.out.print(" ");
        }
        System.out.println("|");

        System.out.print("|");
        for (int i = 0; i < 3; i++) {
            System.out.print(" ");
        }
        System.out.print("Date:");
        System.out.print(date);
        for (int i = 0; i < 9; i++) {
            System.out.print(" ");
        }
        System.out.print("Ref:");
        System.out.print(ref);
        for (int i = 0; i < 7; i++) {
            System.out.print(" ");
        }
        System.out.println("|");

        System.out.print("|");
        for (int i = 0; i < 3; i++) {
            System.out.print(" ");
        }
        System.out.print("Terms:");
        String terms;
        if (term == 'A') {
            terms = "Annual";
        } else {
            terms = "Month";
        }
        System.out.print(terms);
        for (int i = 0; i < 23 - terms.length(); i++) {
            System.out.print(" ");
        }
        System.out.print("Items:");
        String Items;
        switch (numOfGad) {
            case 1:
                Items = "One";
                break;
            case 2:
                Items = "Two";
                break;
            case 3:
                Items = "Three";
                break;
            case 4:
                Items = "Four";
                break;
            case 5:
                Items = "Five";
                break;
            default:
                Items = Integer.toString(numOfGad);
                break;
        }
        System.out.print(Items);
        for (int i = 0; i < 7 - Items.length(); i++) {
            System.out.print(" ");
        }
        System.out.println("|");

        System.out.print("|");
        for (int i = 0; i < 3; i++) {
            System.out.print(" ");
        }
        System.out.print("Excess:");
        System.out.print("£" + excess);
        for (int i = 0; i < 32; i++) {
            System.out.print(" ");
        }
        System.out.println("|");

        System.out.print("|");
        for (int i = 0; i < 3; i++) {
            System.out.print(" ");
        }
        System.out.print(terms + "ly");
        for (int i = 0; i < 20 - terms.length() + 2; i++) {
            System.out.print(" ");
        }
        System.out.print("Limit per");
        for (int i = 0; i < 9; i++) {
            System.out.print(" ");
        }
        System.out.println("|");

        System.out.print("|");
        for (int i = 0; i < 3; i++) {
            System.out.print(" ");
        }
        System.out.print("Premium:");
        String Premium;
        if (premium == -1) {
            Premium = "Rejected";
        } else {
            Premium = String.format("£%.2f", premium / 100.00);
        }
        System.out.print(Premium);
        for (int i = 0; i < 16 - Premium.length(); i++) {
            System.out.print(" ");
        }
        System.out.print("Gadget:");
        String gadget;
        if (validation.valMostExpGad(newPolicy.get_mostExpGad()) == false || validation.valGadget(newPolicy.get_numOfGad()) == false || premium == -1) {
            gadget = "Rejected";
        } else {
            gadget = Integer.toString(mostExpGad);
        }
        System.out.print(gadget);
        for (int i = 0; i < 11 - gadget.length(); i++) {
            System.out.print(" ");
        }
        System.out.println("|");

        System.out.print("|");
        for (int i = 0; i < 45; i++) {
            System.out.print(" ");
        }
        System.out.println("|");

        System.out.print("+");
        for (int i = 0; i < 45; i++) {
            System.out.print("=");
        }
        System.out.println("+");

    }
}
