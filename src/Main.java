package src;

import java.util.Scanner;

import BrazukasProject.Classes.*;


public class Main {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        int decision = 999;

        while (decision != 0){
            StaticMethods.Menu();
            decision = input.nextInt();

            switch (decision) {
                case 1:
                    StaticMethods.PrintQuestionUser();
                    int LoginOrLoad = input.nextInt();
                    
                    if (LoginOrLoad == 1) {
                        User usuario = User.CreaterUser();
                        usuario.PrintRegisteredUser();
                    }


                    break;

                case 0:
                    break;
            }
        } // End main while
    } // End static method main
} // End class Main
