package com.orgofarmsgroup.controller;

import com.orgofarmsgroup.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureGraphQlTester
@Slf4j
class UserGraphQLControllerIntegrationTest {
    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    @DisplayName(value = "controller: users.getById")
    void testQueryUsersGetById() {
        // language=GraphQL
        String queryUsersGetById = """
            query {
                users {
                    getById(uid: 101) {
                        uid
                        name
                        email
                    }
                }
            }
        """;
        GraphQlTester.Entity<UserEntity, ?> responseUser = graphQlTester.document(queryUsersGetById)
                                                        .execute()
                                                        .path("users.getById")
                                                        .entity(UserEntity.class);
        assertEquals(101L, responseUser.get().getUid());
    }
}