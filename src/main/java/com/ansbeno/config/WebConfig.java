package com.ansbeno.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan("com.ansbeno.controllers")
public class WebConfig implements WebMvcConfigurer {

      @Bean
      public ViewResolver internalResourceViewResolver() {
            InternalResourceViewResolver bean = new InternalResourceViewResolver();
            bean.setViewClass(JstlView.class);
            bean.setPrefix("/WEB-INF/views/");
            bean.setSuffix(".jsp");
            return bean;
      }

      @Override
      public void addResourceHandlers(@NonNull ResourceHandlerRegistry registry) {
            // Serve static resources from /static or /public
            registry.addResourceHandler("/css/**").addResourceLocations("/css/");
            registry.addResourceHandler("/js/**").addResourceLocations("/js/");
            registry.addResourceHandler("/images/**").addResourceLocations("/images/");
      }
}