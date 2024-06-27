package BrazukasProject.Classes;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private static int numberOfUsers; 
    private String name;
    private int password;
    private int code; 


    private static ArrayList<User> userlist = new ArrayList<>();
     

    public User(String name, int password){
        
        this.name = name;
        this.password = password;
        this.code = numberOfUsers;
        ++numberOfUsers;
        
        userlist.add(this);
    }
    public static User CreaterUser (){
        Scanner input = new Scanner(System.in);
        System.out.println("***********************");
        System.out.println("   CADASTRO DE USUÁRIO  ");
        System.out.println("***********************");

        System.out.print("Digite o nome do usuário: ");
         String name = input.nextLine();

        System.out.print("Digite a senha:");
        int password = input.nextInt();

        return new User(name, password);


        
    }
    public void PrintRegisteredUser(){
        System.out.println("***********************");
        System.out.printf("\nUsuário cadastrado:\tCodigo: %d\n", code);
        System.out.println("Nome: " + name);
        System.out.println("Senha: " + password);
        System.out.println("***********************");
    }
}

