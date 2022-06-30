package br.com.devdojo.repository;

import br.com.devdojo.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnimeRepository extends JpaRepository<Anime, UUID> {


}
