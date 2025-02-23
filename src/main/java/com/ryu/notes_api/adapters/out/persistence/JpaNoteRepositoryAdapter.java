package com.ryu.notes_api.adapters.out.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ryu.notes_api.application.port.out.NoteRepository;
import com.ryu.notes_api.domain.model.Note;

@Repository
public class JpaNoteRepositoryAdapter implements NoteRepository {

    private final SpringDataNoteRepository jpaRepository;

    @Autowired
    public JpaNoteRepositoryAdapter(SpringDataNoteRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    private NoteEntity toEntity (Note note) {
        NoteEntity entity = new NoteEntity();
        entity.setId(note.getId());
        entity.setTitle(note.getTitle());
        entity.setBody(note.getBody());
        entity.setCreationDate(note.getCreationDate());
        entity.setUpdateDate(note.getUpdateDate());
        entity.setImportant(note.getImportant());
        entity.setPending(note.getPending());
        return entity;
    }

    private Note toDomain (NoteEntity entity) {
        Note note = new Note();
        note.setId(entity.getId());
        note.setTitle(entity.getTitle());
        note.setBody(entity.getBody());
        note.setCreationDate(entity.getCreationDate());
        note.setUpdateDate(entity.getUpdateDate());
        note.setImportant(entity.getImportant());
        note.setPending(entity.getPending());
        return note;
    }

    @Override
    public Note save(Note note) {
        NoteEntity entity = toEntity(note);
        NoteEntity savedEntity = jpaRepository.save(entity);
        return toDomain(savedEntity);
    }

    @Override
    public Optional<Note> findById(Long id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<Note> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
}

