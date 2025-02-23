package com.ryu.notes_api.application.service;

import java.time.LocalDateTime;
import java.util.List;

import com.ryu.notes_api.adapters.in.NoteMapper;
import com.ryu.notes_api.application.dto.NoteCreateDTO;
import com.ryu.notes_api.application.dto.NoteUpdateDTO;
import com.ryu.notes_api.application.port.in.NoteUseCase;
import com.ryu.notes_api.application.port.out.NoteRepository;
import com.ryu.notes_api.domain.model.Note;

public class NoteService implements NoteUseCase {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note newNote(NoteCreateDTO noteCreateDTO) {
       Note note = NoteMapper.fromCreateDTO(noteCreateDTO);
       note.setCreationDate(LocalDateTime.now());
       note.setUpdateDate(LocalDateTime.now());
       note.setPending(false);
       note.setImportant(false);

       Note savedNote = noteRepository.save(note);
       return savedNote;
    }

    @Override
    public Note updateNote(NoteUpdateDTO noteUpdateDTO) {
        Note note = noteRepository.findById(noteUpdateDTO.getId())
            .orElseThrow(() -> new IllegalArgumentException("Note not found"));
        
        if (noteUpdateDTO.getTitle() != null) {
            note.setTitle(noteUpdateDTO.getTitle());
        }

        if (noteUpdateDTO.getBody() != null) {
            note.setBody(noteUpdateDTO.getBody());
        }

        Note updateNote = noteRepository.save(note);
        return updateNote;
    }

    @Override
    public void deleteNote (Long id) {
        Note note = noteRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Note not found"));

        noteRepository.deleteById(note.getId());
    }

    @Override
    public List<Note> listNote () {
        return noteRepository.finAll();
    }
    
}
