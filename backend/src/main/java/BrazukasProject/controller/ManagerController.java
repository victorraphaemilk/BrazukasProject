package BrazukasProject.controller;

import BrazukasProject.Classes.Jogador;
import BrazukasProject.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    public List<Jogador> getPlayers() {
        return playerService.getPlayers();
    }

    @PostMapping("/players")
    public Jogador addPlayer(@RequestBody Jogador player) {
        return playerService.addPlayer(player);
    }

    @DeleteMapping("/players/name/{name}")
    public void removePlayer(@PathVariable String name) {
        playerService.removePlayer(name);
    }

    @DeleteMapping("/players/number/{number}")
    public void removePlayer(@PathVariable int number) {
        playerService.removePlayer(number);
    }
}
