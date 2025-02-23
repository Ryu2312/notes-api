package com.ryu.notes_api.adapters.out.persistence;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "notes")
public class NoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String body;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    private boolean important;
    private boolean pending;

    
    public NoteEntity() {
    }

    public Long getId() { 
        return id; 
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() { 
        return title; 
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() { 
        return body; 
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getCreationDate() { 
        return creationDate; 
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdateDate() { 
        return updateDate; 
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public boolean getImportant() { 
        return important; 
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    public boolean getPending() { 
        return pending; 
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }
}
