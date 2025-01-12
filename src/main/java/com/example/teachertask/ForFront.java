package com.example.teachertask;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class ForFront implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // API'lerinizi belirtiyorsunuz
                .allowedOrigins("http://localhost:3000")  // Frontend adresinizi buraya ekliyorsunuz
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // İzin verilen HTTP yöntemleri
                .allowedHeaders("*")  // Tüm başlıklara izin verir
                .allowCredentials(true);  // Çerezler ve kimlik doğrulama bilgileri
    }

}

