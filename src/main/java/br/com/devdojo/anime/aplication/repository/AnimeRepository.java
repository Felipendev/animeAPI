package br.com.devdojo.anime.aplication.repository;

import br.com.devdojo.anime.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnimeRepository extends JpaRepository<Anime, UUID> {


}
