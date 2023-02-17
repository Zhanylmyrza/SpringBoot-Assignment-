package com.bkrva.UniProject.controller;




import jakarta.validation.Valid;
import com.bkrva.UniProject.modules.Book;
import com.bkrva.UniProject.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "books", method = { RequestMethod.GET, RequestMethod.POST })
public class BookController {

    @Autowired
    private BookRepo bookRepository;
    @GetMapping("addBook")
    public String showForm(Book book) {
        return "add-book";
    }

    @GetMapping("list")
    public String showBookList(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "main";
    }
    @PostMapping("add")
    public String addBook(@Valid Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-book";
        }

        bookRepository.save(book);
        return "redirect:/main";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model){
        Book book = bookRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid book id: " + id ));
        model.addAttribute("book",book);
        return "update-book";

    }
    @GetMapping("update/{id}")
    public String updateBooks(@PathVariable("id") long id, Book book, BindingResult result, Model model){
        if(result.hasErrors()){
            book.setId(id);
            return "update-book";
        }
        bookRepository.save(book);
        model.addAttribute("books",bookRepository.findAll());
        return "main";
    }

    @GetMapping("delete/{id}")
    public String deleteBook(@PathVariable("id") long id, Model model ){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book id: " + id ));
        bookRepository.delete(book);
        model.addAttribute("book", bookRepository.findAll());
        return "redirect:/main";

    }

}

