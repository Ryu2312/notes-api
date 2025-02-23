package com.ryu.notes_api.application.dto;

public class NoteCreateDTO {
    private String title;
    private String body;

    public NoteCreateDTO() {}

    public NoteCreateDTO(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle () { return title; }
    public void setTitle (String title) {
        this.title = title;
    }

    public String getBody () { return body; }
    public void setBody (String body) {
        this.body = body;
    }
}
