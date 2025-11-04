package BrazukasProject.service;

import BrazukasProject.Classes.Jogador;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    private final List<Jogador> players = new ArrayList<>();
    private final List<Jogador> titularPlayers = new ArrayList<>();

    public PlayerService() {
        // Initialize with some dummy data for now
        Jogador neymar = new Jogador("Neymar", 10, "Atacante");
        neymar.setCodigo(1);
        players.add(neymar);

        Jogador thiagoSilva = new Jogador("Thiago Silva", 3, "Defensor");
        thiagoSilva.setCodigo(2);
        players.add(thiagoSilva);
    }

    public List<Jogador> getPlayers() {
        return players;
    }

    public Jogador addPlayer(Jogador player) {
        player.setCodigo(players.size() + 1);
        players.add(player);
        return player;
    }

    public void removePlayer(String name) {
        players.removeIf(player -> player.getNome().equals(name));
    }

    public void removePlayer(int number) {
        players.removeIf(player -> player.getNumero() == number);
    }

    public List<Jogador> getTitularPlayers() {
        return titularPlayers;
    }

    public void addTitularPlayer(String name) {
        players.stream()
                .filter(player -> player.getNome().equals(name))
                .findFirst()
                .ifPresent(titularPlayers::add);
    }

    public void addTitularPlayer(int number) {
        players.stream()
                .filter(player -> player.getNumero() == number)
                .findFirst()
                .ifPresent(titularPlayers::add);
    }

    public void removeTitularPlayer(String name) {
        titularPlayers.removeIf(player -> player.getNome().equals(name));
    }

    public void removeTitularPlayer(int number) {
        titularPlayers.removeIf(player -> player.getNumero() == number);
    }
}
