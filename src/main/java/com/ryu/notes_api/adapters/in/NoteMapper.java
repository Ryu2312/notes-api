package com.ryu.notes_api.adapters.in;

import com.ryu.notes_api.application.dto.NoteCreateDTO;
import com.ryu.notes_api.domain.model.Note;

public class NoteMapper {
    
    public static Note fromCreateDTO (NoteCreateDTO dto) {
       Note note = new Note();
       note.setTitle(dto.getTitle());
       note.setBody(dto.getBody());
       return note;
    }
}
