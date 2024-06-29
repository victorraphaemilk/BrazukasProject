package BrazukasProject.Classes;

import java.util.Iterator;

public class Gerente extends Usuario{

    public Gerente() {
        super();
    }

    public void adicionarAoTime(Jogador jogador) {
        time.add(jogador);
        timeReserva.add(jogador);
    }

    public void removerDoTime(String nomeJogador) {
        Iterator<Jogador> iterator = time.iterator();
        while (iterator.hasNext()) {
            Jogador jogador = iterator.next();
            if (jogador.getNome().equals(nomeJogador)) {
                iterator.remove();
                time.remove(jogador);
                timeTitular.remove(jogador);
                timeReserva.remove(jogador);
            }
        }
    }

    public void removerDoTime(int numeroJogador) {
        Iterator<Jogador> iterator = time.iterator();
        while (iterator.hasNext()) {
            Jogador jogador = iterator.next();
            if (jogador.getNumero() == numeroJogador) {
                iterator.remove();
                time.remove(jogador);
                timeTitular.remove(jogador);
                timeReserva.remove(jogador);
            }
        }
    }

}

