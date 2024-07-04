package BrazukasProject.Classes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Gerente extends Usuario implements Serializable  {

    private static final long serialVersionUID = 1L;

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


    public static void GravarTimes(Gerente gerente){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dados.ser"))){
            oos.writeObject(time);
            oos.writeObject(timeReserva);
            oos.writeObject(timeTitular);
            oos.writeInt(Jogador.getQuatidadeDeJogadores());

            System.out.println("Times salvos com sucesso");
        } catch (Exception e) {
            System.out.println("Houve um erro para salvar os times");

            
        }
    }
    public static void CarregarTimes(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dados.ser"))) {
            
            time = (List<Jogador>) ois.readObject();
            timeReserva = (List<Jogador>) ois.readObject();
            timeTitular = (List<Jogador>) ois.readObject();
            
            int QuatidadeDeJogadores = ois.readInt();
            Jogador.setQuatidadeDeJogadores(QuatidadeDeJogadores);

            
            System.out.println("Times carregados com sucessor");
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Houve um erro para carregador os times");
        }
    }
}


