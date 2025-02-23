package com.ryu.notes_api.application.dto;

public class NoteUpdateDTO {
    private Long id;
    private String title;
    private String body;
    private boolean pending;
    private boolean important;
    
    public NoteUpdateDTO() {}

    public NoteUpdateDTO(Long id, String title, String body, boolean pending, boolean important) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.pending = pending;
        this.important = important;
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

    public boolean getPending () { return pending; }
    public void setPending (boolean pending) {
        this.pending = pending;
    }
    
    public boolean getImportant () { return important; }
    public void setImportant (boolean important) {
        this.important = important;
    }
}
