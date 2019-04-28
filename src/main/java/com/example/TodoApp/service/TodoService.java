package com.example.TodoApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TodoApp.repository.TodoRepository;
import com.example.TodoApp.model.Todo;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> list() {
		return todoRepository.findAll();
	}
	
	public Todo findOneById(Long id) {
		return todoRepository.findOneById(id);
	}
	
	public Todo findOneByTitle(String title) {
		return todoRepository.findOneByTitle(title);
	}
	
	public Todo add(Todo todo) {
		if (this.todoRepository.findOneById(todo.getId()) == null) {
			this.todoRepository.save(todo);
			return todo;
		}else {
			return null;
		}
	}
	
	public Boolean delete(Long id) {
	    	Todo todo = todoRepository.findOneById(id);
	    	if ( todo != null) {
	    		this.todoRepository.delete(todo);
	    		return true;
	    	} else {
	    		return false;
	    	}
	}
	
    public Todo update(Todo todo) {
    		this.todoRepository.updateTodo(
	                    todo.getId(), 
                        todo.getTitle(),
                        todo.getDescription());
    		return todo;
    }
}