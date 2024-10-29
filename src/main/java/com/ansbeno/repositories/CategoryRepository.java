package com.ansbeno.repositories;

import java.util.List;

import com.ansbeno.entities.Category;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class CategoryRepository {

      @PersistenceContext(unitName = "demo")
      private EntityManager entityManager;

      public List<Category> getCategories() {
            TypedQuery<Category> query = entityManager.createQuery("SELECT c FROM Category c", Category.class);
            return query.getResultList();
      }

}
