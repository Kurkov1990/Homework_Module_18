package com.homework.app.service;

import com.homework.app.dto.NoteRequest;
import com.homework.app.dto.NoteResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoteService {
    NoteResponse create(NoteRequest request);
    NoteResponse getById(Long id);
    Page<NoteResponse> list(Pageable pageable);
    NoteResponse update(Long id, NoteRequest request);
    void delete(Long id);
}
