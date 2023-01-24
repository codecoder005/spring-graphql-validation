package com.orgofarmsgroup.controller;

import com.google.gson.Gson;
import com.orgofarmsgroup.dto.UserOperations;
import com.orgofarmsgroup.entity.UserEntity;
import com.orgofarmsgroup.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserGraphQLController {
    private final Gson jsonHelper;
    private final UserRepository userRepository;

    @QueryMapping(name = "users")
    public UserOperations usersQuery() {
        log.info("UserGraphQLController.usersQuery");
        return new UserOperations();
    }
    @MutationMapping(name = "users")
    public UserOperations usersMutation() {
        log.info("UserGraphQLController.usersMutation");
        return new UserOperations();
    }
    @SchemaMapping(typeName = "UserOperations", field = "get")
    public List<UserEntity> get() {
        log.info("UserGraphQLController.users.get");
        return userRepository.findAll();
    }
    @SchemaMapping(typeName = "UserOperations", field = "getById")
    public UserEntity getById(@Argument(name = "uid") Long uid) {
        log.info("UserGraphQLController.users.get.uid");
        Optional<UserEntity> optionalUser = userRepository.findById(uid);
        return optionalUser.orElse(null);
    }
    @SchemaMapping(typeName = "UserOperations", field = "post")
    public UserEntity post(@Argument(name = "user") UserEntity user) {
        log.info("UserGraphQLController.users.post");
        return user;
    }
}
