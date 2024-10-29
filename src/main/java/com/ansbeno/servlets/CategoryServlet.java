package com.ansbeno.servlets;

import java.io.IOException;

import com.ansbeno.repositories.CategoryRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/categories")
public class CategoryServlet extends HttpServlet {

      private static final Logger log = LoggerFactory.getLogger(CategoryServlet.class);

      private final transient CategoryRepository categoryRepository;

      @Inject
      public CategoryServlet(CategoryRepository categoryRepository) {
            this.categoryRepository = categoryRepository;
      }

      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                  throws ServletException, IOException {
            try {
                  log.debug("Categories: {}", categoryRepository.getCategories());
                  req.setAttribute("categories", categoryRepository.getCategories());
                  req.getRequestDispatcher("/category/index.jsp").forward(req, resp);
            } catch (ServletException | IOException e) {
                  log.error("Error getting categories", e);
            }
      }
}
