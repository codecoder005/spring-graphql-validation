package com.orgofarmsgroup.controller;

import com.google.gson.Gson;
import com.orgofarmsgroup.entity.OrderEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@AutoConfigureGraphQlTester
@Slf4j
@ActiveProfiles(profiles = {"unit-test", "h2"})
class OrderGraphQLControllerIntegrationTest {
    @Autowired
    private GraphQlTester graphQlTester;
    @Autowired
    private Gson jsonHelper;

    @Test
    @DisplayName(value = "controller: query orders")
    void testQueryOrders() {
        // language=GraphQL
        String query = """
            query {
               orders {
                   oid
                   amount
                   customer
               }
            }
        """;

        GraphQlTester.EntityList<OrderEntity> entityList= graphQlTester.document(query)
                .execute()
                .path("orders")
                .entityList(OrderEntity.class);
        log.info(jsonHelper.toJson(entityList.get()));
    }
}