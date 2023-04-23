package com.stonepaperscizor.spsgame.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stonepaperscizor.spsgame.entity.Game;
import com.stonepaperscizor.spsgame.service.GameService;


@RestController
public class GameController {
    
    @Autowired
    private GameService gameService;
    
    
    @GetMapping("/game/play/{choice}")
    public ResponseEntity<String> playGame(@PathVariable String choice) {
        String result = gameService.play(choice);
        return ResponseEntity.ok(result);
    }
    
    @PostMapping("/game/play")
    public ResponseEntity<String> playGame2(@RequestBody Game game) {
        String result = gameService.play(game.getp1Choice());
        return ResponseEntity.ok(result);
    }
    
 
}