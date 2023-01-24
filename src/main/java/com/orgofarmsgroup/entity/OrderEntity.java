package com.orgofarmsgroup.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
        name = "orders"
)
public class OrderEntity implements Serializable {
    public static final long serialVersionUID = 88771230987L;

    @Id
    private Long oid;
    private String customer;
    private Double amount;
}
