package br.com.devdojo.anime.aplication.service;

import br.com.devdojo.anime.aplication.api.AnimeRequest;
import br.com.devdojo.anime.domain.Anime;
import br.com.devdojo.exception.AnimeNotFoundException;
import br.com.devdojo.anime.aplication.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
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
        verificaSeExiste(animeId);
        Optional<Anime> findById = animeRepository.findById(animeId);
        log.info("[Finaliza] AnimeService - findById");
        return findById;
    }

    public Anime save(@RequestBody  @Valid AnimeRequest animeRequest) {
        log.info("[Inicia] AnimeService - save");
        Anime animeSaved = animeRepository.save(Anime.builder().name(animeRequest.getName()).build());
        log.info("[Finaliza] AnimeService - save");
        return animeSaved;
    }

    public void delete(@PathVariable UUID animeId) throws AnimeNotFoundException {
        log.info("[Inicia] AnimeService - delete");
        verificaSeExiste(animeId);
        animeRepository.deleteById(animeId);
        log.info("[Finaliza] AnimeService - delete");
    }

    private Anime verificaSeExiste(UUID animeId) throws AnimeNotFoundException {
        log.info("[Inicio] AnimeService - verificaSeExiste");
        Anime anime = animeRepository.findById(animeId).orElseThrow(() -> new AnimeNotFoundException(animeId));
        log.info("[Finaliza] AnimeService - verificaSeExiste");
        return anime;
    }

    public void update(AnimeRequest animeRequest) throws AnimeNotFoundException {
        verificaSeExiste(animeRequest.getId());
        Optional<Anime> savedAnime = animeRepository.findById(animeRequest.getId());
        Anime anime = Anime.builder()
                .id(savedAnime.get().getId())
                .name(animeRequest.getName())
                .build();
         animeRepository.save(anime);
        }
}
