package BrazukasProject;

import java.util.Scanner;

import BrazukasProject.Classes.*;


public class Main {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        int decision;

        while (decision != 0){
            System.out.println("MENU");
            System.out.println("1 - USUARIO");
            System.out.println("0 - Sair");
            decision = input.nextInt();

            switch (decision) {
                case 1:
                    User.PrintQuestionUser();


                    break;

                case 0:
                    break;
            }
        } // End main while
    } // End static method main
} // End class Main
