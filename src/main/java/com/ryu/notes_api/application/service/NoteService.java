package com.ryu.notes_api.application.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ryu.notes_api.adapters.in.rest.NoteMapper;
import com.ryu.notes_api.application.dto.NoteCreateDTO;
import com.ryu.notes_api.application.dto.NoteUpdateDTO;
import com.ryu.notes_api.application.port.in.NoteUseCase;
import com.ryu.notes_api.application.port.out.NoteRepository;
import com.ryu.notes_api.domain.model.Note;
import com.ryu.utils.Utils;

@Service
public class NoteService implements NoteUseCase  {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note newNote(NoteCreateDTO noteCreateDTO) {
       Note note = NoteMapper.fromCreateDTO(noteCreateDTO);
       note.setCreationDate(LocalDateTime.now());
       note.setUpdateDate(LocalDateTime.now());
       note.setPending(true);
       note.setImportant(false);

       Note savedNote = noteRepository.save(note);
       return savedNote;
    }


    @Override
    public Note updateNote(NoteUpdateDTO noteUpdateDTO) {
        Note note = noteRepository.findById(noteUpdateDTO.getId())
            .orElseThrow(() -> new IllegalArgumentException("Note not found"));

        // Copia solo las propiedades no nulas
        BeanUtils.copyProperties(noteUpdateDTO, note, Utils.getNullPropertyNames(noteUpdateDTO));
        note.setUpdateDate(LocalDateTime.now());
        return noteRepository.save(note);
    }

    @Override
    public void deleteNote (Long id) {
        Note note = noteRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Note not found"));

        noteRepository.deleteById(note.getId());
    }

    @Override
    public List<Note> listNote () {
        return noteRepository.findAll();
    }
    
}
