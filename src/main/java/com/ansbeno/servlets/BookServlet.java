package com.ansbeno.servlets;

import java.io.IOException;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ansbeno.entities.Book;
import com.ansbeno.repositories.BookRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/books")
public class BookServlet extends HttpServlet {

    private BookRepository bookRepository;

    @Override
    public void init() throws ServletException {
        // Get the Spring WebApplicationContext
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        if (context != null) {
            this.bookRepository = context.getBean(BookRepository.class);
        } else {
            throw new ServletException("Spring WebApplicationContext not found");
        }
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
