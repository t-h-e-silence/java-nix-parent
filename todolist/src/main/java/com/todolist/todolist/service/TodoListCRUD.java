package com.todolist.todolist.service;

import com.todolist.todolist.entity.ToDoList;
import com.todolist.todolist.request.SaveNoteRequest;

import java.util.List;
import java.util.Optional;

public interface TodoListCRUD {

    ToDoList create(SaveNoteRequest request);

    Optional<ToDoList> getbyId(Integer id);

    Optional<ToDoList> deleteById(Integer id);

    List<ToDoList> printAll();

    List<ToDoList> findNotDone();

    void update(Integer id, SaveNoteRequest request);

}


