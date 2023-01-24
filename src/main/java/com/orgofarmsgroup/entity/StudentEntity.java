package com.orgofarmsgroup.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(
        name = "students"
)
public class StudentEntity implements Serializable {
    public static final long serialVersionUID = -746351573639857L;

    @Id
    @SequenceGenerator(
            name = "students_sid_seq_gen",
            sequenceName = "students_sid_seq_gen",
            initialValue = 130001,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "students_sid_seq_gen"
    )
    private Long sid;
    private String name;
//    @Column(columnDefinition = "timestamp default current_timestamp")
    private Date createdDateTime;
//    @Column(columnDefinition = "timestamp default current_timestamp")
    private Date lastUpdatedDateTime;
}
