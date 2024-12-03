package com.cucei.apitest.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.cucei.apitest.models.PlayerModel;
import com.cucei.apitest.repositories.PlayerRepository;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;
    public int terroristCount = 0;
    public int swatCount = 0;

    //obtener todos los jugadores
    public ArrayList<PlayerModel> getPlayers() {
        return (ArrayList<PlayerModel>) playerRepository.findAll();
    }

    //guardar un jugador
    public PlayerModel savePlayer(PlayerModel player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }
            return playerRepository.save(player);
        }

    //actualizar un jugador
    public PlayerModel updatePlayer(PlayerModel player) {
        // Verificar que el jugador exista
        Optional<PlayerModel> existingPlayer = playerRepository.findById(player.getId());
        if (existingPlayer.isPresent()) {
            return playerRepository.save(player);
        }
        throw new RuntimeException("Player not found with id: " + player.getId());
    }

    //obtener un jugador por id
    public Optional<PlayerModel> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    //obtener un jugador por nombre
    public Optional<PlayerModel> getPlayerByName(String name) {
        return playerRepository.findByName(name);
    }

    //Borrar un jugador
    public String deletePlayer(Long id) {
        PlayerModel playerFound = playerRepository.findById(id)
                .orElse(null);
        if (playerFound != null) {
            playerRepository.deleteById(id);
            return "Player deleted successfully";
        } else {
            return "Player not found";
        }
    }
}
