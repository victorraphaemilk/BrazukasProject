package BrazukasProject.Classes;

import java.util.Iterator;

public class Tecnico extends Usuario {
    public Tecnico() {
        super();
    }

    public void adicionarTitular(String nomeJogador) {
        if (timeTitular.size() < 11) {
            for (Jogador jogador : time) {
                if (jogador.getNome().equals(nomeJogador)) {
                    timeTitular.add(jogador);
                    timeReserva.remove(jogador);
                    return;
                }
            }
        } else {
            System.err.println("Time titular está completo");
        }
    }

    public void adicionarTitular(int numeroJogador) {
        if (timeTitular.size() < 11) {
            for (Jogador jogador : time) {
                if (jogador.getNumero() == numeroJogador) {
                    timeTitular.add(jogador);
                    timeReserva.remove(jogador);
                    return;
                }
            }
        } else {
            System.err.println("Time titular está completo");
        }
    }

    public void removerTitular(String nomeJogador) {
        if (!timeTitular.isEmpty()) {
            Iterator<Jogador> iterator = timeTitular.iterator();
            while (iterator.hasNext()) {
                Jogador jogador = iterator.next();
                if (jogador.getNome().equals(nomeJogador)) {
                    timeReserva.add(jogador);
                    iterator.remove();
                    return;
                }
            }
        } else {
            System.out.println("Não há jogadores cadastrados");
        }
    }

    public void removerTitular(int numeroJogador) {
        if (!timeTitular.isEmpty()) {
            Iterator<Jogador> iterator = timeTitular.iterator();
            while (iterator.hasNext()) {
                Jogador jogador = iterator.next();
                if (jogador.getNumero() == numeroJogador) {
                    timeReserva.add(jogador);
                    iterator.remove();
                    return;
                }
            }
        } else {
            System.out.println("Não há jogadores cadastrados");
        }
    }


    @Override
    public void mostrarJogadores() {
        System.out.println("Jogadores titular: ");
        for (Jogador jogador : timeTitular) {
            System.out.println(jogador.toString());
        }
        System.out.println("Jogadores reservar: ");
        for (Jogador jogador : timeReserva) {
            System.out.println(jogador.toString());
        }
    }
}
