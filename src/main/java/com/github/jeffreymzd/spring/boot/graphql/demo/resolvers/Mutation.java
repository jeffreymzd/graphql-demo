package com.github.jeffreymzd.spring.boot.graphql.demo.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.github.jeffreymzd.spring.boot.graphql.demo.models.SuperCharacter;
import com.github.jeffreymzd.spring.boot.graphql.demo.repos.SuperCharacterRepo;
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

    public SuperCharacter addCharacter(String name, Integer age) {
        return superCharacterRepo.addCharacter(name, age);
    }
}
