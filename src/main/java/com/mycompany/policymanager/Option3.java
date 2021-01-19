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
public class Option3 {

    public static void option3(String file_name, int month_num) {

        int total_policies = 0;
        int accepted_policies = 0;
        int items = 0;
        int month_terms = 0;
        int monthly_premium = 0;
        int total_premium = 0;
        Scanner input = null;  	// keeping the compiler happy

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

                if (calculations.get_Month(date) == month_num) {//Checking for policies of the given month's number
                    total_policies++;
                    if (premium != -1) {//Checking if policy is rejected or accepted
                        accepted_policies++;
                        items += numOfGad;
                        if (terms == 'A') {// if term is annually then divide it by 12 and add in total premium
                            total_premium += (premium / 12);
                        } else {
                            total_premium += premium;//if term is monthly then add it directly to total premium
                        }
                    }

                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist");
            System.exit(1);
        }
        input.close();
        String avg_monthlyPremium = String.format("£%.2f", calculations.get_monthlyPremium(total_premium, accepted_policies) / 100.00); //getting average monthly premium and converting it to decimal form
        System.out.println("Total number of policies in " + calculations.get_month(month_num) + " is " + total_policies);
        System.out.println("Average number of items: " + calculations.get_avgItems(items, accepted_policies));
        System.out.println("Average Monthly Premium for Accepted Policies is: " + avg_monthlyPremium);
    }

}
