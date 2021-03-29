package com.github.jeffreymzd.spring.boot.graphql.demo.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.github.jeffreymzd.spring.boot.graphql.demo.models.Orientation;
import com.github.jeffreymzd.spring.boot.graphql.demo.models.SuperCharacter;
import com.github.jeffreymzd.spring.boot.graphql.demo.models.SuperGroup;
import com.github.jeffreymzd.spring.boot.graphql.demo.repos.SuperCharacterRepo;
import com.github.jeffreymzd.spring.boot.graphql.demo.repos.SuperGroupRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by jeffreymzd on 3/28/21
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class Mutation implements GraphQLMutationResolver {

    private final SuperCharacterRepo superCharacterRepo;
    private final SuperGroupRepo superGroupRepo;

    public SuperCharacter addCharacter(String name, Integer age, String groupName) {
        return superCharacterRepo.addCharacter(name, age, groupName);
    }

    public SuperCharacter removeCharacter(String id) {
        return superCharacterRepo.removeCharacter(id);
    }

    public SuperGroup addGroup(String name, Orientation orientation) {
        return superGroupRepo.addGroup(name, orientation);
    }
}
