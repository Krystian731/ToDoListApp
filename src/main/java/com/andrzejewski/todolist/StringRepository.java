package com.andrzejewski.todolist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StringRepository extends CrudRepository<StringEntity, Long> {
}
