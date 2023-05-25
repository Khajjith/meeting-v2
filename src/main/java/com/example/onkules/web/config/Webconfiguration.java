package com.example.onkules.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@EnableWebMvc
public class Webconfiguration implements WebMvcConfigurer {
    @Override
    public void addViewControllers(final ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("list");
        registry.addViewController("/list").setViewName("list");
       /* registry.addViewController("/index").setViewName("create");
        registry.addViewController("/index").setViewName("update");
        registry.addViewController("/index").setViewName("list");
        registry.addViewController("/create").setViewName("create");
        registry.addViewController("/update").setViewName("update");
        registry.addViewController("/delete").setViewName("delete");
        registry.addViewController("/list").setViewName("list");
        //registry.addViewController("/meeting").setViewName("list");*/
    }
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                        "/webjars/**",
                        "/img/**",
                        "/css/**",
                        "/js/**")
                .addResourceLocations(
                        "classpath:/META-INF/resources/webjars/",
                        "classpath:/static/img/",
                        "classpath:/static/css/",
                        "classpath:/static/js/");


    }
}
