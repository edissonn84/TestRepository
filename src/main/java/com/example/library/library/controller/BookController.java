package com.example.library.library.controller;

import com.example.library.library.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@RequestMapping("/references")
public class BookController {

    @GetMapping("/books")
    public String getAll(Model model) {
        Book book = new Book(1L, "Ведьмак", "фентази",
                "Сапковский", 1000L, 5L);
        book.setTotalOfBooks(50L);
        model.addAttribute("books", Collections.singletonList(book));
        return "references/book/book";
    }
}
