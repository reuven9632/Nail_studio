/*
package com.example.Nail_studio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@EnableWebMvc
@Configuration
public class MvcConfig implements WebMvcConfigurer{

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        */
/*test to connect css and js for Alona of templates/app/index.html *//*

        registry.addResourceHandler("css/**")
                .addResourceLocations("classpath:/templates/app/css/");
        registry.addResourceHandler("images/**")
                .addResourceLocations("classpath:/templates/app/img/");
        registry.addResourceHandler("js/**")
                .addResourceLocations("classpath:/templates/app/js/");
        registry.addResourceHandler("fonts/**")
                .addResourceLocations("classpath:/templates/app/fonts/");


        */
/*test to connect css and js for Alona of templates/index.html *//*

        registry.addResourceHandler("app/css/**")*/
/*какой ресурс искать*//*

                .addResourceLocations("classpath:/templates/app/css/");*/
/*где искать нужный ресурс*//*

        registry.addResourceHandler("app/images/**")
                .addResourceLocations("classpath:/templates/app/images/");
        registry.addResourceHandler("app/js/**")
                .addResourceLocations("classpath:/templates/app/js/");

        */
/*test to connect Thymeleaf blocs for Alona of templates/app/index.html *//*

        registry.addResourceHandler("blocs/**")
                .addResourceLocations("classpath:/templates/blocs/");

    }
}







*/
