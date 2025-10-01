package com.homework.app.dto;

import java.time.Instant;

public record NoteResponse(
        Long id,
        String title,
        String content,
        String tags,
        Instant createdAt,
        Instant updatedAt
) {}
