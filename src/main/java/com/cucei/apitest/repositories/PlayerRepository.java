package com.cucei.apitest.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cucei.apitest.models.PlayerModel;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.lang.NonNull;

@Repository
public interface PlayerRepository extends CrudRepository<PlayerModel, Long> {
    @NonNull
    public abstract Optional<PlayerModel> findById(@NonNull Long id);
    public abstract Optional<PlayerModel> findByName(String name);
    ArrayList<PlayerModel> findByTeamAndNumberGreaterThan(PlayerModel.Team team, Integer number);


}
