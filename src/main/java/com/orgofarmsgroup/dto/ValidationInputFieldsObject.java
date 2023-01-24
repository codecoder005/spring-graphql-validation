package com.orgofarmsgroup.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidationInputFieldsObject implements Serializable {
    public static final long serialVersionUID = -89763565127L;

    @NotNull(message = "sid is required")
    @Min(value = 20230001L, message = "minimum sid is 130937")
    private Long sid;
    private String name;

    private Character gender;
    @Email(message = "invalid email")
    private String email;
    private Integer age;
    private Double salary;
    private Boolean isMarried;
}
