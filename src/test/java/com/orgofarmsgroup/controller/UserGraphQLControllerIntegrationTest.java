package com.orgofarmsgroup.controller;

import com.orgofarmsgroup.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureGraphQlTester
@Slf4j
@Sql(
        statements = {
                "insert into users(uid, name, email) values (102, 'test_user', 'test_user@email.com');",
                "select next value for uid_seq_generator;"
        }
)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class UserGraphQLControllerIntegrationTest {
    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    @DisplayName(value = "controller: users.getById")
    @Order(value = 1)
    void testQueryUsersGetById() {
        Long uid = 102L;
        // language=GraphQL
        String queryUsersGetById = """
            query {
                users {
                    getById(uid: 102) {
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
        assertEquals(102L, responseUser.get().getUid());
    }

    @Test
    @DisplayName(value = "controller: users")
    @Order(value = 2)
    void testQueryUsers() {
        Long uid = 102L;
        // language=GraphQL
        String queryUsersGetById = """
            query {
                users {
                    get {
                        uid
                        name
                        email
                    }
                }
            }
        """;
        GraphQlTester.EntityList<UserEntity> responseUser = graphQlTester.document(queryUsersGetById)
                .execute()
                .path("users.get")
                .entityList(UserEntity.class);
        assertEquals(101L, responseUser.get().get(0).getUid());
    }
}