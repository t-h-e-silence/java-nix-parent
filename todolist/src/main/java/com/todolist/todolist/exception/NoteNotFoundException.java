package com.todolist.todolist.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoteNotFoundException extends ResponseStatusException {
    public NoteNotFoundException(Integer id) {
        super(HttpStatus.NOT_FOUND, "Message not found!");
    }
}
