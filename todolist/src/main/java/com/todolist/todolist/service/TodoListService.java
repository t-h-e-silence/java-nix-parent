package com.todolist.todolist.service;
import com.todolist.todolist.entity.ToDoList;
import com.todolist.todolist.exception.NoteNotFoundException;
import com.todolist.todolist.repository.TodoListRepository;
import com.todolist.todolist.request.SaveNoteRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TodoListService implements TodoListCRUD{
    private final TodoListRepository listRepository;

    public TodoListService(TodoListRepository listRepository) {
        this.listRepository = listRepository;
    }

    @Override
    public ToDoList create(SaveNoteRequest request) {
        var note = new ToDoList();
        note.setDone(request.getDone());
        note.setText(request.getText());
        return listRepository.save(note);
    }

    @Override
    public Optional<ToDoList> getbyId(Integer id) {
        return listRepository.findById(id);
    }

    @Override
    public Optional<ToDoList> deleteById(Integer id) {
        var note = listRepository.findById(id);
        note.ifPresent(listRepository::delete);
        return note;
    }


    @Override
    public void update(Integer id, SaveNoteRequest request) {
        var note = listRepository.findById(id).orElseThrow(() -> new NoteNotFoundException(id));
        note.setText(request.getText());
        note.setDone(request.getDone());
        listRepository.save(note);
    }

    @Override
    public List<ToDoList> printAll() {
         var list= listRepository.findAll();
        return list;
    }

    @Override
    public List<ToDoList> findNotDone() {
        List note = Collections.singletonList(listRepository.findByDoneIsFalse());
        return note;
    }


}
