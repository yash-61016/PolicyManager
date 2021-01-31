/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.policymanager;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author yashpatel
 */
public class Option1 {
    
    @SuppressWarnings("resource")
	public static void newPolicy() throws IOException {
        try  {
        	Scanner in = new Scanner(System.in);
			System.out.println("Enter your name:");
			String name = in.nextLine();
			name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase(); // Capitalising 1st letter of name
			while (!validation.valname(name)) { // Checking and prompting for invalid names
			    System.out.println("Enter vaild name:");
			    name = in.nextLine();
			    name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
			}
			
			System.out.println("Enter Refrence number:");
			String ref_num = in.nextLine().toUpperCase();
			while (!validation.valRef(ref_num)) { // Checing and prompting for invalid refrence number
			    System.out.println("Enter vaild Refrence number:");
			    ref_num = in.nextLine().toUpperCase();
			}
			System.out.println("Enter number of gadgets:");
			int numOfGad = in.nextInt();
			validation.valGadget(numOfGad);// validating number of gadgets
			
			System.out.println("Enter value of most expensive gadget:");
			int mostExpGad = in.nextInt();
			validation.valMostExpGad(mostExpGad);//validating value of most expensive gadget
			
			System.out.println("Enter amount of excess you want to increase:");
			int excess = in.nextInt();
			while (excess > 40 || excess % 10 != 0) {//Checking and promting user for invaild amount of excess
			    System.out.println("Enter amount of excess you want to increase (Maximum 40 & in multiple of 10):");
			    excess = in.nextInt();
			}
			System.out.println("You want to pay annually?\n press Y for Yes N for No:");
			char term = in.next().toUpperCase().charAt(0);
			while (term != 'Y' && term != 'N') {
			    System.out.println("Enter Y or N:");
			    term = in.next().toUpperCase().charAt(0);
			}
			String final_name = name;
			String final_ref_num = ref_num;
			int final_numOfGad = numOfGad;
			int final_mostExpGad = mostExpGad;
			int final_excess = validation.valExcess(excess);
			int final_premium = calculations.finalPremium(term, excess, numOfGad, mostExpGad, validation.valGadget(numOfGad), validation.valMostExpGad(mostExpGad));
			char final_term = validation.valPay(term, numOfGad, mostExpGad);
			
			newPolicy policy = new newPolicy(final_name, final_ref_num, final_numOfGad , final_mostExpGad, final_excess, final_premium, final_term, getDate()); //Creating new policy
			
			calculations.policyToFile(policy);//apending policy to file
			
			calculations.printPolicy(policy);//printing policy
		}catch(Exception e) {
			
		}
    }
    
    public static String getDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        return sdf.format(cal.getTime());
    }
    
}
