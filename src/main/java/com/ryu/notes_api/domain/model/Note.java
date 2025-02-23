package com.ryu.notes_api.domain.model;

import java.time.LocalDateTime;

public class Note {
    private Long id;
    private String title;
    private String body;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private boolean important;
    private boolean pending;

    public Note () {}

    public Note (Long id, String title, String body, LocalDateTime creationDate, boolean important, boolean pending) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.creationDate = creationDate;
        this.updateDate = creationDate;
        this.important = important;
        this.pending = pending;
    }

    public Long getId () { return id; }
    public void setId (Long id) {
        this.id = id;
    }

    public String getTitle () { return title; }
    public void setTitle (String title) {
        this.title = title;
    }

    public String getBody () { return body; }
    public void setBody (String body) {
        this.body = body;
    }

    public LocalDateTime getCreationDate () { return creationDate; } 
    public void setCreationDate (LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdateDate () { return updateDate; }
    public void setUpdateDate (LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
    
    public boolean getImportant () { return important; }
    public void setImportant (boolean important) {
        this.important = important;
    }

    public boolean getPending () { return pending; }
    public void setPending (boolean pending) {
        this.pending = pending;
    }

}
