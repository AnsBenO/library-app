package com.ansbeno.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ansbeno.entities.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class BookRepository implements Serializable {

      private final transient EntityManager entityManager;

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
