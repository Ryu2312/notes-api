package com.ryu.notes_api.adapters.in.rest;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ryu.notes_api.application.dto.NoteCreateDTO;
import com.ryu.notes_api.application.dto.NoteUpdateDTO;
import com.ryu.notes_api.application.port.in.NoteUseCase;
import com.ryu.notes_api.domain.model.Note;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteUseCase noteUseCase;

    public NoteController (NoteUseCase noteUseCase) {
        this.noteUseCase = noteUseCase;
    }

    @PostMapping
    public ResponseEntity<Note> createNote (@RequestBody NoteCreateDTO dto) {
        Note note = noteUseCase.newNote(dto);
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(note.getId())
            .toUri();
        return ResponseEntity.created(location).body(note);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote (@PathVariable Long id, @RequestBody NoteUpdateDTO dto) {
        dto.setId(id);
        Note note = noteUseCase.updateNote(dto);
        return ResponseEntity.ok(note);
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<Void> deletedNote (@PathVariable Long id) {
        noteUseCase.deleteNote(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Note>> getListNote () {
        List<Note> notes = noteUseCase.listNote();
        return ResponseEntity.ok(notes);
    }
}
