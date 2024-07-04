package BrazukasProject.Classes;

import java.io.Serializable;
import java.util.Scanner;

public class Jogador implements Serializable {
    private static int QuatidadeDeJogadores;
    private String nome;
    private int numero;
    private int codigo;
    private String posicao;

    public Jogador(String nome, int numeroDaCamisa, String posicao) {
        this.nome = nome;
        this.numero = numeroDaCamisa;
        this.codigo = QuatidadeDeJogadores;
        this.posicao = posicao;
        ++QuatidadeDeJogadores;

        //Usuario.time.add(this);
    }
    public static int getQuatidadeDeJogadores() {
        return QuatidadeDeJogadores;
    }
    
    public static void setQuatidadeDeJogadores(int quatidadeDeJogadores) {
        QuatidadeDeJogadores = quatidadeDeJogadores;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getPosicao() {
        return posicao;
    }

    public static Jogador CriarJogador() {
        Scanner input = new Scanner(System.in);
        System.out.println("***********************");
        System.out.println("   CADASTRO DE JOGADOR  ");
        System.out.println("***********************");

        System.out.print("Digite o nome do jogador: ");
        String nome = input.nextLine();

        System.out.println("Digite o numero da camisa:");
        int numeroDaCamisa = input.nextInt();

        System.out.println("Escolha a sua respectiva posição: ");
        System.out.println("1 - Atacante ");
        System.out.println("2 - Defensor ");
        System.out.println("3 - Meio Campo");
        System.out.println("4 - Goleiro");
        int DecisaoDaPosição = input.nextInt();

        String posicao = "";

        switch (DecisaoDaPosição) {
            case 1:
                posicao = "Atacante";
                break;
            case 2:
                posicao = "Defensor";
                break;
            case 3:
                posicao = "Meio Campo";
                break;
            case 4:
                posicao = "Goleiro";
                break;
            default:
                System.out.println("Escolha uma posição");
        }
        return new Jogador(nome, numeroDaCamisa, posicao);
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", numeroDaCamisa=" + numero +
                ", codigo=" + codigo +
                ", posicao='" + posicao + '\'' +
                '}';
    }
}



