package br.com.devdojo.anime.aplication.api;

import br.com.devdojo.anime.domain.Anime;
import br.com.devdojo.exception.AnimeNotFoundException;
import br.com.devdojo.anime.aplication.service.AnimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("animes")
@Table(name = "animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {

    @Autowired
    private final AnimeService animeService;

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<Anime> list() {
        log.info("[Inicia] AnimeController - list");
        List<Anime> allAnimes = animeService.listAll();
        log.info("[Finaliza] AnimeController - list");
        return allAnimes;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Anime> findById(@PathVariable UUID id ) throws AnimeNotFoundException {
        log.info("[Inicia] AnimeController - findById");
        Optional<Anime> findById = animeService.findById(id);
        log.info("[Finaliza] AnimeController - findById");
        return findById;
    }

    @PostMapping
    public ResponseEntity<Anime> save( @RequestBody @Valid AnimeRequest animeRequest) {
        log.info("[Inicia] AnimeController - save");
        ResponseEntity<Anime> savedAnime = new ResponseEntity<>(animeService.save(animeRequest), HttpStatus.CREATED);
        log.info("[Finaliza] AnimeController - save");
        return savedAnime;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody AnimeRequest animeRequest) throws AnimeNotFoundException {
        log.info("[Inicia] AnimeController - save");
        animeService.update(animeRequest);
        log.info("[Finaliza] AnimeController - save");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) throws AnimeNotFoundException{
        log.info("[Inicia] AnimeController - delete");
        animeService.delete(id);
        log.info("[Finaliza] AnimeController - delete");
    }
}
