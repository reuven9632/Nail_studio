package com.example.Nail_studio.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        /**test to connect css and js for Alona of templates/app/index.html*/
        registry.addResourceHandler("css/**")
                /*need add / to path on html*/
                .addResourceLocations("classpath:/templates/app/css/");
        registry.addResourceHandler("images/**")
                .addResourceLocations("classpath:/templates/app/images/");
        registry.addResourceHandler("js/**")
                .addResourceLocations("classpath:/templates/app/js/");
        registry.addResourceHandler("fonts/**")
                .addResourceLocations("classpath:/templates/app/fonts/");


        /**test to connect css and js for Alona of templates/index.html
         * .addResourceHandler("app/css/**")     какой ресурс искать
         * .addResourceLocations("classpath:/templates/app/css/");    где искать нужный ресурс*/
        registry.addResourceHandler("app/css/**")
                .addResourceLocations("classpath:/templates/app/css/");
        registry.addResourceHandler("app/images/**")
                .addResourceLocations("classpath:/templates/app/images/");
        registry.addResourceHandler("app/js/**")
                .addResourceLocations("classpath:/templates/app/js/");
        registry.addResourceHandler("app/fonts/**")
                .addResourceLocations("classpath:/templates/app/fonts/");


        /**test to connect Thymeleaf blocs for Alona of templates/app/index.html */
        registry.addResourceHandler("blocs/**")
                .addResourceLocations("classpath:/templates/blocs/");

    }
}








