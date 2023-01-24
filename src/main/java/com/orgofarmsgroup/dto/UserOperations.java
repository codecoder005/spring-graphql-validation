package com.orgofarmsgroup.dto;

import com.orgofarmsgroup.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserOperations {
    private List<UserEntity> get;
    private UserEntity post;
}
