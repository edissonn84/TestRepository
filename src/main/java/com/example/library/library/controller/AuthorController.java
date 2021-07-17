package com.example.library.library.controller;

import com.example.library.library.model.Author;
import com.example.library.library.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;
import java.util.Collections;

@Controller
@RequestMapping("/references")
public class AuthorController {

    @GetMapping("/authors")
    public String getAll(Model model) {
        Author author = new Author(1L, "Иван", "Иванович", "Иванов", Calendar.getInstance().getTime(), "М");
        model.addAttribute("authors", Collections.singletonList(author));
        return "references/author/author";
    }
}
