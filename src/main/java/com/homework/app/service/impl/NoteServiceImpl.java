package com.homework.app.service.impl;


import com.homework.app.dto.NoteRequest;
import com.homework.app.dto.NoteResponse;
import com.homework.app.entity.Note;
import com.homework.app.mapper.NoteMapper;
import com.homework.app.repository.NoteRepository;
import com.homework.app.service.NoteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public NoteResponse create(NoteRequest request) {
        Note saved = noteRepository.save(NoteMapper.toEntity(request));
        return NoteMapper.toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public NoteResponse getById(Long id) {
        Note n = noteRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Note with id=" + id + " not found"));
        return NoteMapper.toResponse(n);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<NoteResponse> list(Pageable pageable) {
        return noteRepository.findAll(pageable).map(NoteMapper::toResponse);
    }

    @Override
    public NoteResponse update(Long id, NoteRequest request) {
        Note n = noteRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Note with id=" + id + " not found"));
        NoteMapper.updateEntity(n, request);
        return NoteMapper.toResponse(n);
    }

    @Override
    public void delete(Long id) {
        if (!noteRepository.existsById(id)) {
            throw new IllegalArgumentException("Note with id=" + id + " not found");
        }
        noteRepository.deleteById(id);
    }
}
