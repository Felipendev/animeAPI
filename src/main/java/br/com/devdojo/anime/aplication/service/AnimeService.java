package br.com.devdojo.service;

import br.com.devdojo.domain.Anime;
import br.com.devdojo.exception.AnimeNotFoundException;
import br.com.devdojo.repository.AnimeRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class AnimeService {

    private final AnimeRepository animeRepository;

    public List<Anime> listAll() {
        log.info("[Inicia] AnimeService - listAll");
        List<Anime> animeList = animeRepository.findAll();
        log.info("[Finaliza] AnimeService - listAll");
        return animeList;
    }

    public Optional<Anime> findById(@PathVariable UUID animeId) throws AnimeNotFoundException {
        log.info("[Inicia] AnimeService - findById");
        Optional<Anime> findById = animeRepository.findById(animeId);
        log.info("[Finaliza] AnimeService - findById");
        return Optional.of(findById.orElseThrow(() -> new AnimeNotFoundException(animeId)));
    }

    public Anime save(Anime anime) {
        log.info("[Inicia] AnimeService - save");
        Anime animeSaved = animeRepository.save(anime);
        log.info("[Finaliza] AnimeService - save");
        return animeSaved;
    }

    public void delete(@PathVariable UUID animeId) throws AnimeNotFoundException {
        log.info("[Inicia] AnimeService - delete");
        animeRepository.deleteById(animeId);
        log.info("[Finaliza] AnimeService - delete");
    }

//    public Anime update(UUID id, Anime anime) {
//        Optional<Anime> animePorId = animeRepository.findById( );
//        animePorId = animeRepository.delete(anime);
//        return updateAnime;
//    }
}
