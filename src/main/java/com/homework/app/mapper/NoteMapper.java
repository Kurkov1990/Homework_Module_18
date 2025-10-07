package com.homework.app.mapper;


import com.homework.app.dto.NoteRequest;
import com.homework.app.dto.NoteResponse;
import com.homework.app.entity.Note;

public class NoteMapper {
    private NoteMapper() {}

    public static Note toEntity(NoteRequest req) {
        Note n = new Note();
        updateEntity(n, req);
        return n;
    }

    public static void updateEntity(Note entity, NoteRequest req) {
        entity.setTitle(req.title());
        entity.setContent(req.content());
        entity.setTags(req.tags());
    }

    public static NoteResponse toResponse(Note n) {
        return new NoteResponse(
                n.getId(), n.getTitle(), n.getContent(), n.getTags(), n.getCreatedAt(), n.getUpdatedAt()
        );
    }
}
