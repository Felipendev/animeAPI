package br.com.devdojo.anime.aplication.api;

import lombok.Data;

import javax.persistence.Column;
import java.util.UUID;

@Data
public class AnimeRequest {
    private UUID id;
    @Column(nullable = false)
    private String name;
}
