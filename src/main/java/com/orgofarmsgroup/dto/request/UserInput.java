package com.orgofarmsgroup.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInput implements Serializable {
    public static final long serialVersionUID = -90908080101L;

    @NotNull(message = "{1001}")
    @Pattern(regexp = "[a-zA-Z ]{3,50}", message = "{1002}")
    private String name;
    @NotNull(message = "{1010}")
    @Email(message = "{1011}")
    private String email;
}
