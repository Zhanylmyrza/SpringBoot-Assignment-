package com.bkrva.UniProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bkrva.UniProject.modules.Book;
import com.bkrva.UniProject.repos.BookRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class MainController {
    

    @Autowired
    private BookRepo bookRepository;

    @GetMapping({"/","/main"})
    public String hello(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "main";
    }
    

    @GetMapping("/isbn/{isbn}")
    public Book getByIsbn(@PathVariable(name = "isbn") String isbn) {
        return bookRepository.findByIsbn(isbn);
    }
    
}
