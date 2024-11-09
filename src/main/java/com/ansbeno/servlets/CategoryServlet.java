package com.ansbeno.servlets;

import java.io.IOException;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ansbeno.repositories.CategoryRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet("/categories")
public class CategoryServlet extends HttpServlet {

      private CategoryRepository categoryRepository;

      @Override
      public void init() throws ServletException {
            // Get the Spring WebApplicationContext
            WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
            if (context != null) {
                  // Get the desired Spring bean
                  this.categoryRepository = context.getBean(CategoryRepository.class);
            } else {
                  throw new ServletException("Spring WebApplicationContext not found");
            }
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
