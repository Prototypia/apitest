package com.cucei.apitest.controllers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.cucei.apitest.models.PlayerModel;
import com.cucei.apitest.services.PlayerService;
import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/player")
@CrossOrigin
public class PlayerController {

    @Autowired
    PlayerService playerService;

    //get
    @GetMapping()
    public ArrayList<PlayerModel> getPlayers() {
        return playerService.getPlayers();
    }

    //find by id
    @CrossOrigin
    @GetMapping("/findById")

    public Optional<PlayerModel> getPlayerById(@RequestParam("id") Long id) {
        return playerService.getPlayerById(id);
    }

    //find by name
    @CrossOrigin
    @GetMapping("/findByName")
    public Optional<PlayerModel> getPlayerByName(@RequestParam("name") String name) {
        return playerService.getPlayerByName(name);
    }

    //delete

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
        //public String deletePlayer(@RequestParam("id") Long id, @RequestBody PlayerModel player) {
        public String deletePlayer(@PathVariable Long id) {
        return playerService.deletePlayer(id);
    }

    //post
    @PostMapping()
    public ResponseEntity<PlayerModel> savePlayer(@RequestBody PlayerModel playerModel) {
        PlayerModel savedPlayer = playerService.savePlayer(playerModel);
        return ResponseEntity.ok(savedPlayer);
    }

    //edit
  
    @CrossOrigin
    @PutMapping("/update/{id}")
    public PlayerModel updatePlayer(@PathVariable Long id, @RequestBody PlayerModel player) {
    player.setId(id);
    return playerService.updatePlayer(player);
    }

}
