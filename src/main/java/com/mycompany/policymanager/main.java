/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.policymanager;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author yashpatel
 */
public class main {

    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        Scanner keyb = new Scanner(System.in);
        boolean exit = true;
        while (exit) {
            System.out.print("\n");
            System.out.println("Choose option below:\n1.Enter new Policy\n2.Display Summary of Policies\n3.Display summary of Policies for Selected Month\n4.Find and Display Policy\n0.Exit");
            int option = in.nextInt();
            if (option == 1) {
                    Option1.newPolicy();// Creates new policy
                    System.out.print("\n");
                }
                if (option == 2) {
                    System.out.println("Which file do you want to open?\n1.Current\t2.Archive");
                    int file_name = in.nextInt();// Archive or Current
                    if (file_name == 1) {
                        String current = "policy.txt";
                        Option2.option2(current);
                    } else if (file_name == 2) {
                        String archive = "archive.txt";
                        Option2.option2(archive);
                    }
                    System.out.print("\n");
                }
                if (option == 3) {
                    System.out.println("Which file do you want to open?\n1.Current\t2.Archive");
                    int file_name = in.nextInt();// Archive or Current
                    if (file_name == 1) {
                        String current = "policy.txt";
                        System.out.println("Enter the month's number you want to see policies of:");
                        int month_num = in.nextInt();//month number
                        Option3.option3(current, month_num);
                    } else if (file_name == 2) {
                        String archive = "archive.txt";
                        System.out.println("Enter the month's number you want to see policies of:");
                        int month_num = in.nextInt();//month number
                        Option3.option3(archive, month_num);
                    }
                    System.out.print("\n");
                }
                if (option == 4) {
                    System.out.println("Which file do you want to open?\n1.Current\t2.Archive");
                    int file_name = in.nextInt();// Archive or Current
                    if (file_name == 1) {
                        String current = "policy.txt";
                        System.out.println("Enter the text you want to search with:");
                        String text = keyb.nextLine();//Search text
                        Option4.search_policy(current, text);

                    } else if (file_name == 2) {
                        String archive = "archive.txt";
                        System.out.println("Enter the text you want to search with:");
                        String text = keyb.nextLine();//Search text
                        Option4.search_policy(archive, text);

                    }
                    System.out.print("\n");
                }
                if (option == 0) {
                    exit = false;//Exit
                }
            }
            System.out.println("You have Exited.");
        }
    }

