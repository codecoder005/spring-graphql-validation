package com.orgofarmsgroup.controller;

import com.google.gson.Gson;
import com.orgofarmsgroup.dto.ValidationInputFieldsObject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ValidationGraphQLController {
    private final Gson jsonHelper;

    @MutationMapping(name = "validation")
    public ValidationInputFieldsObject validation(@Valid @NotNull(message = "validation object is required") @Argument(name = "object") ValidationInputFieldsObject object) {
        log.info("validation accessed: "+object);
        return object;
    }

    @MutationMapping(name = "check")
    public String check(
            @NotBlank(message = "name can not be empty")
            @Argument(name = "name") String name) {
        log.info(name);
        return name;
    }

    @MutationMapping(name = "list")
    public List<Long> list(
            @Argument(name = "sids")
            @Size.List(value = @Size(min = 1, message = "sids list can not be empty"))
            List<@Min(value = 130001L, message = "sid starts from 130001") Long> sids) {
        return sids;
    }
}
