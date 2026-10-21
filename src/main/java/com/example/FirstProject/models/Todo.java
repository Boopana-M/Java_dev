package com.example.FirstProject.models;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue
    Long id;

    @Schema(name = "title" , description = "Represents a Todo item",
            example = "complete spring boot")
    @NotBlank
    String title;

    @NotBlank
    String description;

    @NotNull
    Boolean isCompleted;

    @Email
    String email;
}


