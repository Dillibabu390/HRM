package com.demo.authserver.entity;


import com.demo.authserver.annotation.ValidateRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UserCredential")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserEntity {

    @Id
    private String id;

    @NotNull(message = "username not to null")
    private String name;
    @Email
    @NotNull(message = "email not to be null")
    private String email;

    @ValidateRole
    private String role;

    @NotNull(message = "password not to be null")
    private String password;
}
