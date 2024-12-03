package com.cucei.apitest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import lombok.Data;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Data
@Entity
@Table(name = "players", 
       uniqueConstraints = @UniqueConstraint(columnNames = {"number", "team"}))
       
public class PlayerModel {
    
    public enum Team {
        TERRORIST,
        SWAT
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    @Min(value = 1, message = "Player number must be at least 1")
    @Max(value = 5, message = "Player number cannot exceed 5")
    private Integer number;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Team team;
}