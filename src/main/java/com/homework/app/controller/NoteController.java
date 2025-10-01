package com.homework.app.controller;

import com.homework.app.dto.NoteRequest;
import com.homework.app.dto.NoteResponse;
import com.homework.app.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NoteResponse create(@RequestBody @Valid NoteRequest request) {
        return noteService.create(request);
    }

    @GetMapping("/{id}")
    public NoteResponse get(@PathVariable Long id) {
        return noteService.getById(id);
    }

    @GetMapping("/list")
    public Page<NoteResponse> list(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return noteService.list(pageable);
    }

    @PutMapping("/{id}")
    public NoteResponse update(@PathVariable Long id, @RequestBody @Valid NoteRequest request) {
        return noteService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        noteService.delete(id);
    }
}
