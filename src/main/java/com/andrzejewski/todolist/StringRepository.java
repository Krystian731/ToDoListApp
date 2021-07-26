package com.andrzejewski.todolist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StringRepository extends JpaRepository<StringEntity, Long> {
}
