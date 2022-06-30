package br.com.devdojo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AnimeNotFoundException extends Exception{
    public AnimeNotFoundException(UUID id) {
        super("O Anime com o ID " + id + " não foi encontrado");
    }
}
