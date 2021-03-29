package com.github.jeffreymzd.spring.boot.graphql.demo.repos;

import com.github.jeffreymzd.spring.boot.graphql.demo.models.SuperCharacter;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by jeffreymzd on 3/28/21
 */
@Slf4j
@Component
public class SuperCharacterRepo {

    private List<SuperCharacter> theCharacters;

    public SuperCharacterRepo() {
        seedCharacters();
        log.info("Init SuperCharacters: {}", this.theCharacters);
    }

    private void seedCharacters() {
        this.theCharacters = new ArrayList<>();

        SuperCharacter c1 = SuperCharacter.builder()
                .id("Char1")
                .name("Super Character1")
                .age(33)
                .build();
        SuperCharacter c2 = SuperCharacter.builder()
                .id("Char2")
                .name("Two is My Name")
                .age(147)
                .build();

        this.theCharacters.add(c1);
        this.theCharacters.add(c2);
    }

    public List<SuperCharacter> getTheCharacters() {
        return theCharacters;
    }

    public SuperCharacter getCharacterById(String id) {
        Optional<SuperCharacter> match = this.theCharacters.stream()
                .filter(x -> x.getId().equals(id))
                .findAny();
        return match.orElse(null);
    }

    public SuperCharacter addCharacter(String name, Integer age) {
        SuperCharacter newCharacter = SuperCharacter.builder()
                .id("Char" + (this.theCharacters.size() + 1))
                .name(name)
                .age(age)
                .build();

        this.theCharacters.add(newCharacter);
        return newCharacter;
    }
}
