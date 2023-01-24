package com.orgofarmsgroup.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(
        name = "users"
)
public class UserEntity implements Serializable {
    public static final long serialVersionUID = -998877665544L;

    @Id
    @SequenceGenerator(
            name = "uid_seq_generator",
            sequenceName = "uid_seq_generator",
            initialValue = 101,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "uid_seq_generator"
    )
    private Long uid;
    private String name;
    private String email;
}
