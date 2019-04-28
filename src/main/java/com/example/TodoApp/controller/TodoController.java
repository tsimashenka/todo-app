package com.example.TodoApp.controller;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.TodoApp.service.TodoService;
import com.example.TodoApp.model.Todo;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;


    @RequestMapping(value = "/")
    public String index(ModelMap map) {
        List<Todo> todos = todoService.list();
        Collections.reverse(todos);
        map.addAttribute("todoList", todos);
        return "index";
    }

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
	@ResponseBody
	public List<Todo> getPosts() {
		return todoService.list();
    }
    
    @RequestMapping(value = "/todos/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Todo getPost(@PathVariable("id") Long id) {
		return todoService.findOneById(id);
    }
    
    @RequestMapping(value = "/todos", method = RequestMethod.POST)
	public String savePost(@Valid Todo post) {
		todoService.add(post);
		return "redirect:/";
    }
    
    @RequestMapping(value = "/todos/{id}", method = RequestMethod.DELETE)
	public String deletePost(@PathVariable Long id) {
		todoService.delete(id);
		return "redirect:/";
    }

    @RequestMapping(value = "/todos", method = RequestMethod.PUT)
	public String updatePost(@Valid Todo post) {
		todoService.update(post);
		return "redirect:/";
	}
}