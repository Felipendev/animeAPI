package br.com.devdojo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.Generated;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
}
