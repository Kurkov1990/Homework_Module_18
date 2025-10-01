package com.homework.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record NoteRequest(
        @NotBlank @Size(max = 255) String title,
        @NotBlank String content,
        String tags
) {}
