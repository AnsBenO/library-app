package com.ansbeno.controllers;

import java.util.List;

import com.ansbeno.entities.Book;
import com.ansbeno.repositories.BookRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping
    public String getBooks(@RequestParam(value = "category", required = false) String category, Model model) {
        try {
            List<Book> books;
            if (category == null) {
                books = bookRepository.getBooks();
            } else {
                books = bookRepository.getBooksByCategory(category);
            }
            model.addAttribute("books", books);
            return "book/index";
        } catch (Exception e) {
            log.error("Error getting books", e);
            return "error";
        }
    }
}
