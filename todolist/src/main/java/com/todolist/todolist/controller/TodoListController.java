package com.todolist.todolist.controller;
import com.todolist.todolist.entity.ToDoList;
import com.todolist.todolist.exception.NoteNotFoundException;
import com.todolist.todolist.request.SaveNoteRequest;
import com.todolist.todolist.service.TodoListCRUD;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todolist")
public class TodoListController {
    private final TodoListCRUD todoListCRUD;

    public TodoListController(TodoListCRUD todoListCRUD) {
        this.todoListCRUD = todoListCRUD;
    }

    @GetMapping("/{id}")
    public ToDoList get(@PathVariable Integer id) {
        return todoListCRUD.getbyId(id).orElseThrow(() -> new NoteNotFoundException(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ToDoList create(@RequestBody SaveNoteRequest request)
    {
        return todoListCRUD.create(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody SaveNoteRequest request){
        todoListCRUD.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ToDoList delete(@PathVariable Integer id){
        return todoListCRUD.deleteById(id).orElseThrow(()->new NoteNotFoundException(id));
    }

    @GetMapping
    public List<ToDoList> getNotDone(){
        return todoListCRUD.findNotDone();
    }

    @GetMapping(value = "/all")
    public List<ToDoList> print(){
        return todoListCRUD.printAll();
    }

}


