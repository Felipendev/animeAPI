package br.com.devdojo.controller;

import br.com.devdojo.domain.Anime;
import br.com.devdojo.service.AnimeService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("animes")
@Log4j2
@AllArgsConstructor
public class AnimeController {
    private AnimeService animeService;

    public List<Anime> list() {
        return animeService.listAll();
    }
}
