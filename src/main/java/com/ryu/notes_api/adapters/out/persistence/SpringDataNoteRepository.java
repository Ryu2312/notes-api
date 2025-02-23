package com.ryu.notes_api.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataNoteRepository extends JpaRepository<NoteEntity, Long> {

}
