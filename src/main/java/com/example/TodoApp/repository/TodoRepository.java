package com.example.TodoApp.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.TodoApp.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Serializable> {

    Todo findOneById(Long id);
    Todo findOneByTitle(String title);

    @Modifying
    @Transactional
    @Query("UPDATE Todo t SET t.description = :description, t.title = :title WHERE t.id = :id")

    int updateTodo(
        @Param("id") Long id,
        @Param("description") String description,
        @Param("title") String title
    );
}