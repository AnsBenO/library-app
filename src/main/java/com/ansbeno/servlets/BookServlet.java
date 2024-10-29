package com.ansbeno.servlets;

import java.io.IOException;
import java.util.List;

import com.ansbeno.entities.Book;
import com.ansbeno.repositories.BookRepository;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/books")
public class BookServlet extends HttpServlet {

    private final transient BookRepository bookRepository;

    @Inject
    public BookServlet(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String category = null;
        try {
            category = req.getParameter("category");

            List<Book> books;
            if (category == null) {
                books = bookRepository.getBooks();
            } else {
                books = bookRepository.getBooksByCategory(category);
            }

            req.setAttribute("books", books);
            req.getRequestDispatcher("/book/index.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
