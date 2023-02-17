package com.bkrva.UniProject;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bkrva.UniProject.modules.Author;
import com.bkrva.UniProject.modules.Book;
import com.bkrva.UniProject.repos.AuthorRepository;
import com.bkrva.UniProject.repos.BookRepo;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitData implements InitializingBean {

    @Autowired
    private BookRepo bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public void afterPropertiesSet() {
        List<Author> authors = new ArrayList<>();
        Author arthur_conan_doyle = new Author("Arthur", "Conan Doyle");
        authors.add(arthur_conan_doyle);
        Author jack_london = new Author("Jack", "London");
        authors.add(jack_london);
        authorRepository.saveAll(authors);

        List<Book> books = new ArrayList<>();
        books.add(new Book("Sherlock Holms", "3541354",1892,"English").addAuthor(arthur_conan_doyle));
        books.add(new Book("Martin Eden", "43435435",1909,"Russian").addAuthor(jack_london).addAuthor(arthur_conan_doyle));
        books.add(new Book("Alchemist", "54343433",1988,"Turkish").addAuthor(arthur_conan_doyle));
        System.out.println("Before save: " + books);
        bookRepository.saveAll(books);
        System.out.println("After save: "+ books);
        
        

    }
}

