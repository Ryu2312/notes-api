package com.ryu.notes_api.application.port.in;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ryu.notes_api.application.dto.NoteCreateDTO;
import com.ryu.notes_api.application.dto.NoteUpdateDTO;
import com.ryu.notes_api.domain.model.Note;

@Service
public interface NoteUseCase {
    Note newNote (NoteCreateDTO noteCreateDTO);
    Note updateNote (NoteUpdateDTO noteUpdateDTO);
    void deleteNote (Long id);
    List <Note> listNote ();
}
