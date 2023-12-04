package xyz.starsoc.cloudojinfo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                //可选 "DELETE", "OPTIONS"
                .allowedMethods("GET", "POST", "PUT")
                .allowedHeaders("Content-Type", "Authorization","token");
    }
}
