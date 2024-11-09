package com.ansbeno.controllers;

import com.ansbeno.repositories.CategoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/categories")
public class CategoryController {

      private final CategoryRepository categoryRepository;

      @GetMapping
      public String getCategories(Model model) {
            try {
                  log.debug("Categories: {}", categoryRepository.getCategories());
                  model.addAttribute("categories", categoryRepository.getCategories());
                  return "category/index";
            } catch (Exception e) {
                  log.error("Error getting categories", e);
                  return "error";
            }
      }
}
