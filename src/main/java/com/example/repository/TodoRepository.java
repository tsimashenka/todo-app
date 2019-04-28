package com.example.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Serializable> {

    Todo findOneById(Long id);
    Todo findOneByTitle(String title);

    @Modifying
    @Transactional
    @Query("update Todo t set t.title = :title AND t.description = :description "
    + "where t.id = :id")

    int updateTodo(
        @Param("id") Long id,
        @Param("title") String title,
        @Param("description") String description
    );
}