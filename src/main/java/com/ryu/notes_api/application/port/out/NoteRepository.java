package com.ryu.notes_api.application.port.out;

import java.util.List;
import java.util.Optional;

import com.ryu.notes_api.domain.model.Note;

public interface NoteRepository {
    Note save (Note note);
    Optional<Note> findById (Long id);
    void deleteById (Long id);
    List<Note> findAll ();
}
