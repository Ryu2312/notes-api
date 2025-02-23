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

    public Note (Long id, String title, String body, LocalDateTime creationDate, boolean important, boolean pending) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.creationDate = creationDate;
        this.updateDate = creationDate;
        this.important = important;
        this.pending = pending;
    }

    public Long getId () {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public LocalDateTime getCreationDate () {
        return creationDate;
    }

    public LocalDateTime getUpdateDate () {
        return updateDate;
    } 
    
    public boolean getImportant () {
        return important;
    }

    public boolean getPending () {
        return pending;
    }

}
