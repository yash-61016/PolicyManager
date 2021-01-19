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
public class Option2 {

    public static void option2(String file_name) throws FileNotFoundException {
        int total_policies = 0;
        int accepted_policies = 0;
        int items = 0;
        int total_premium = 0;
        int month_terms = 0;
        int monthly_premium = 0;
        int[] month = new int[12];
        
        
        
        Scanner input = null;
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

                

                total_policies++;//Counting total policies
                if (premium != -1) {//Checking for accepted policies
                    items += numOfGad;
                    accepted_policies++;
                    if (terms == 'A'){// if term is annually then divide it by 12 and add in total premium
                    total_premium += (premium / 12);
                    }
                    else total_premium += premium;//if term is monthly then add it directly to total premium
                }
                if (terms == 'M') {// Counting monthly premium
                    monthly_premium += premium;
                    month_terms++;
                }
                
                
                switch (calculations.get_Month(date)) { // Checking for month and according adding policies in to the months 
                    case 1:
                        month[0] = month[0] + 1;
                        break;
                    case 2:
                        month[1] = month[1] + 1;
                        break;
                    case 3:
                        month[2] = month[2] + 1;
                        break;
                    case 4:
                        month[3] = month[3] + 1;
                        break;
                    case 5:
                        month[4] = month[4] + 1;
                        break;
                    case 6:
                        month[5] = month[5] + 1;
                        break;
                    case 7:
                        month[6] = month[6] + 1;
                        break;
                    case 8:
                        month[7] = month[7] + 1;
                        break;
                    case 9:
                        month[8] = month[8] + 1;
                        break;
                    case 10:
                        month[9] = month[9] + 1;
                        break;
                    case 11:
                        month[10] = month[10] + 1;
                        break;
                    case 12:
                        month[11] = month[11] + 1;
                        break;
                    default:
                        break;
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist");
            System.exit(1);
        }
        input.close();
        String avg_monthlyPremium = String.format("£%.2f", calculations.get_monthlyPremium(total_premium,accepted_policies) / 100.00);
        System.out.println("Total number of Policies in " + file_name + " are: " + total_policies);
        System.out.println("Average number of Items for Accepted policies is: " + calculations.get_avgItems(items, accepted_policies));
        System.out.println("Average Monthly Premium for Accepted Policies is: " + avg_monthlyPremium);
        calculations.print_agvMonth(month);//printing month in the given format
        
    }

}
