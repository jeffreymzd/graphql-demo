package com.github.jeffreymzd.spring.boot.graphql.demo.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.github.jeffreymzd.spring.boot.graphql.demo.models.SuperCharacter;
import com.github.jeffreymzd.spring.boot.graphql.demo.models.SuperGroup;
import com.github.jeffreymzd.spring.boot.graphql.demo.repos.SuperCharacterRepo;
import com.github.jeffreymzd.spring.boot.graphql.demo.repos.SuperGroupRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jeffreymzd on 3/28/21
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class Query implements GraphQLQueryResolver {

    private final SuperCharacterRepo superCharacterRepo;
    private final SuperGroupRepo superGroupRepo;

    public List<SuperCharacter> characters() {
        return superCharacterRepo.getTheCharacters();
    }

    public List<SuperGroup> groups() {
        return superGroupRepo.getTheGroups();
    }

    public SuperCharacter characterById(String id) {
        return superCharacterRepo.getCharacterById(id);
    }

    public SuperGroup groupByName(String name) {
        return superGroupRepo.getGroupByName(name);
    }
}
