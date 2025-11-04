package BrazukasProject.Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Usuario implements Serializable {
    protected static List<Jogador> time;
    protected static List<Jogador> timeTitular;
    protected static List<Jogador> timeReserva;

    public Usuario() {
        this.time = new ArrayList<Jogador>();
        this.timeTitular = new ArrayList<Jogador>();
        this.timeReserva = new ArrayList<Jogador>();
    }

    public void mostrarJogadores(){
        if (time.isEmpty()){
            System.err.println("Não há jogadores cadastrados");
        } else {
            for (Jogador jogador : time) {
                System.out.println(jogador.toString());
            }
        }
    }

    public void buscarJogador(String nome){
        for (Jogador jogador : time) {
            if(jogador.getNome().equals(nome)){
                System.out.println(jogador.toString());
            }
        }
    }

    public void buscarJogador(int numero){
        for (Jogador jogador : time) {
            if(jogador.getNumero() == numero){
                System.out.println(jogador.toString());
            }
        }
    }

}
