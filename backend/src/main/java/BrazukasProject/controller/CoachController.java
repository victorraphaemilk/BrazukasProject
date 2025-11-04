package BrazukasProject.controller;

import BrazukasProject.Classes.Jogador;
import BrazukasProject.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coach")
public class CoachController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    public List<Jogador> getPlayers() {
        return playerService.getPlayers();
    }

    @GetMapping("/titular")
    public List<Jogador> getTitularPlayers() {
        return playerService.getTitularPlayers();
    }

    @PostMapping("/titular/name/{name}")
    public void addTitularPlayer(@PathVariable String name) {
        playerService.addTitularPlayer(name);
    }

    @PostMapping("/titular/number/{number}")
    public void addTitularPlayer(@PathVariable int number) {
        playerService.addTitularPlayer(number);
    }

    @DeleteMapping("/titular/name/{name}")
    public void removeTitularPlayer(@PathVariable String name) {
        playerService.removeTitularPlayer(name);
    }

    @DeleteMapping("/titular/number/{number}")
    public void removeTitularPlayer(@PathVariable int number) {
        playerService.removeTitularPlayer(number);
    }
}
