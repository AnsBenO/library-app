package com.ansbeno.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ansbeno.entities.Category;

import jakarta.persistence.EntityManager;

import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CategoryRepository implements Serializable {

      private final transient EntityManager entityManager;

      public List<Category> getCategories() {
            TypedQuery<Category> query = entityManager.createQuery("SELECT c FROM Category c", Category.class);
            return query.getResultList();
      }

}
