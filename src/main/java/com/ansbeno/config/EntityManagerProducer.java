package com.ansbeno.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@Configuration
public class EntityManagerProducer {

      private EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");

      @Bean
      public EntityManager produceEntityManager() {
            return emf.createEntityManager();
      }

}