package com.bkrva.UniProject.repos;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bkrva.UniProject.modules.Book;


  @Repository
public interface BookRepo extends CrudRepository<Book,Long> {
  Set<Book> findAll();
  Book findByIsbn(String isbn);

}
