package br.com.devdojo.service;

import br.com.devdojo.domain.Anime;
import br.com.devdojo.repository.AnimeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class AnimeService {

    private AnimeRepository animeRepository;

    public List<Anime> listAll() {
        return null;
    }
}
