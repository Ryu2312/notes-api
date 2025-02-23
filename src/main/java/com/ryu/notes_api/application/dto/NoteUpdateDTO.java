package com.ryu.notes_api.application.dto;

public class NoteUpdateDTO {
    private Long id;
    private String title;
    private String body;
    
    public NoteUpdateDTO() {}

    public NoteUpdateDTO(Long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Long getId () { return id; }

    public String getTitle () { return title; }
    public void setTitle (String title) {
        this.title = title;
    }

    public String getBody () { return body; }
    public void setBody (String body) {
        this.body = body;
    }
}
