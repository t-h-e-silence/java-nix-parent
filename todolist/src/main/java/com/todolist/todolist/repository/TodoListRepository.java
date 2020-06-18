package com.todolist.todolist.repository;

import com.todolist.todolist.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoListRepository extends JpaRepository<ToDoList, Integer>
{
    List<ToDoList> findByDoneIsFalse();
}
