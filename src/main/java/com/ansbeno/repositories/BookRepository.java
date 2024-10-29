package com.ansbeno.repositories;

import java.util.List;

import com.ansbeno.entities.Book;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class BookRepository {
      @PersistenceContext(unitName = "demo")
      private EntityManager entityManager;

      public List<Book> getBooksByCategory(String category) {
            String queryString = "SELECT b FROM Book b";
            queryString += " WHERE b.category.name = :category";
            TypedQuery<Book> query = entityManager.createQuery(queryString, Book.class);
            query.setParameter("category", category);
            return query.getResultList();
      }

      public List<Book> getBooks() {
            String queryString = "SELECT b FROM Book b";
            TypedQuery<Book> query = entityManager.createQuery(queryString, Book.class);
            return query.getResultList();

      }

}
