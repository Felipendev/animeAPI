package br.com.devdojo.anime.aplication.api;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Data
public class AnimeRequest {
    private UUID id;
    @NotEmpty
    private String name;
}
