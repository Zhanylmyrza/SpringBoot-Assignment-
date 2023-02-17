package com.bkrva.UniProject.repos;

import com.bkrva.UniProject.modules.Author;
import org.springframework.data.repository.CrudRepository;


import java.util.Set;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    Set<Author> findAll();
}
