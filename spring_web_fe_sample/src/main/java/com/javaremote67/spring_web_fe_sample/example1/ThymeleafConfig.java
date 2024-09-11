package com.javaremote67.spring_web_fe_sample.example1;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class ThymeleafConfig {

    @Bean
    public ITemplateResolver templateResolver() {
        // Part 1: initialize config object
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();

        // Part 2: configure config object
        templateResolver.setPrefix("templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCharacterEncoding("UTF-8");

        // Part 3: returne config object
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        // Part 1: initialize config object
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();

        // Part 2: configure config object
        templateEngine.setTemplateResolver(templateResolver());
        // Part 3: returne config object
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        // Part 1: initialize config object
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();

        // Part 2: configure config object
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");

        // Part 3: returne config object
        return viewResolver;
    }
}
