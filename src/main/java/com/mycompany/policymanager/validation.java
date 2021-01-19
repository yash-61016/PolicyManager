/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.policymanager;

/**
 *
 * @author yashpatel
 */
public class validation {

    public static boolean valname(String name) {
        return name.length() <= 20;//returns true if name is less than or equal to 20

    }

    public static boolean valRef(String ref) {// returns false if refrence numeber is not valid
        if (ref.length() != 6) {
            return false;
        } else if (ref.charAt(0) < 'A' || ref.charAt(0) > 'Z') {
            return false;
        } else if (ref.charAt(1) < 'A' || ref.charAt(1) > 'Z') {
            return false;
        } else if (ref.charAt(2) < '0' || ref.charAt(2) > '9') {
            return false;
        } else if (ref.charAt(3) < '0' || ref.charAt(3) > '9') {
            return false;
        } else if (ref.charAt(4) < '0' || ref.charAt(4) > '9') {
            return false;
        } else {
            return !(ref.charAt(5) < 'A' || ref.charAt(5) > 'Z');
        }
    }

    public static boolean valGadget(int numOfGad) {
        return numOfGad <= 5;//returns false if number of gadgets is more than 5
    }

    public static boolean valMostExpGad(int mostExpGad) {
        if(mostExpGad > 1000) {
            return false;
        }
        else if (mostExpGad <= 0) {
            return false;
        }
        else return true;
        }

    public static int valExcess(int excess) {// returns the increased excess amount or default excess amount
        if (excess > 0) {
            return excess + 30;
        } else {
            return 30;
        }
    }

    public static char valPay(char pay, int numOfGad, int mostExpGad) {//validating and returning the term
        if (!valGadget(numOfGad) || !valMostExpGad(mostExpGad)) { // if the policy is rejected then returns R
            return 'R';
        } else if (pay == 'Y') { // if user selects to pay annually then returns A
            return 'A';
        } else if (pay == 'N') { // if user selects to pay monthly then returns B
            return 'M';
        } else {
            return 'R';
        }
    }
}
