/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.policymanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author yashpatel
 */
public class Option4 {

    @SuppressWarnings({ "unused", "resource" })
	public static void search_policy(String file_name, String text) {

        String option = "";
        int index = 1;//to print line number
        Scanner input = null;//keeping compiler happy
        Scanner in = new Scanner(System.in);
        try {

            input = new Scanner(new File(file_name));

            while (input.hasNext()) {
                String date = input.next();
                String ref = input.next();
                int numOfGad = input.nextInt();
                int mostExpGad = input.nextInt();
                int excess = input.nextInt();
                int premium = input.nextInt();
                char terms = input.next().charAt(0);
                String name = input.nextLine();

                if (calculations.check_ref(text, ref)) {//checking if refrence number is matching from the given text
                    option = option + index + ") " + ref + "\n";//adding refrence numeber with line number in a string
                    index++;
                }
                if (calculations.check_name(text, name)) {//cheching if name is matching from the given text
                    name = name.replaceFirst("\\s", "");//deleting extra spaces from name
                    option = option + index + ") " + name + "\n";//addind name with line number in a string
                    index++;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist");
            System.exit(1);
        }
        System.out.println("Search results\n");
        String[] option_array = option.split("\n");//converting string into string array
        for (int i = 0; i < option_array.length; i++) {//printing string array
            System.out.println(option_array[i]);
        }

        Scanner keyb = new Scanner(System.in);
        System.out.println("Which policy you want to display ?\n Enter line number: ");
        int line_num = keyb.nextInt();//taking line number to print from user

        input = null;
        try {

            input = new Scanner(new File(file_name));

            while (input.hasNext()) {
                String date = input.next();
                String ref = input.next();
                int numOfGad = input.nextInt();
                int mostExpGad = input.nextInt();
                int excess = input.nextInt();
                int premium = input.nextInt();
                char terms = input.next().charAt(0);
                String name = input.nextLine();
                name = name.replaceFirst("\\s", "");

                //checking if refrence number or name is equal to the seleceted line number
                if (ref.equals(calculations.get_policy(line_num, option_array)) || name.equals(calculations.get_policy(line_num, option_array))) {
                	newPolicy tempPolicy = new newPolicy(name, ref, numOfGad, mostExpGad, excess, premium, terms, date);
                    calculations.printPolicy(tempPolicy);//printing the policy in the given format
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist");
            System.exit(1);
        }
    }

}
