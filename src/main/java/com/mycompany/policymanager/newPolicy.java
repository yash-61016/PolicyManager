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
public class newPolicy {

    private static String name;
    private static String ref;
    private static int numOfGad;
    private static int mostExpGad;
    private static int excess;
    private static int premium;
    private static char terms;
    private static String date;

    public newPolicy(String name, String ref, int numOfGad, int mostExpGad, int excess, int premium, char terms, String date) {
        newPolicy.date = date;
        newPolicy.ref = ref;
        newPolicy.numOfGad = numOfGad;
        newPolicy.mostExpGad = mostExpGad;
        newPolicy.excess = excess;
        newPolicy.premium = premium;
        newPolicy.terms = terms;
        newPolicy.name = name;
    }

    public static String get_name() {
        return name;
    }

    public static String get_Ref() {
        return ref;
    }

    public static int get_numOfGad() {
        return numOfGad;
    }

    public static int get_mostExpGad() {
        return mostExpGad;
    }

    public static int get_excess() {
        return excess;
    }

    public static int get_premium() {
        return premium;
    }

    public static char get_terms() {
        return terms;
    }
}
