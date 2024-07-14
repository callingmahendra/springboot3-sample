package me.mahendra.spring_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.mahendra.spring_demo.entities.Todo;
import me.mahendra.spring_demo.repository.TodoRepository;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public List<Todo> getCompletedTodos() {
        return todoRepository.findAllByCompleted(true);
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id, Todo todo) {
        return todoRepository.findById(id)
                   .map(existingTodo -> {
                       existingTodo.setTitle(todo.getTitle());
                       existingTodo.setCompleted(todo.isCompleted());
                       return todoRepository.save(existingTodo);
                   })
                   .orElse(null); // Or throw an exception here.
    }

    

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}

