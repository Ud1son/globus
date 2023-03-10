package ru.udisondev.globus.claim.api;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final CORSInterceptor corsInterceptor;
    private final LoggingInterceptor loggingInterceptor;

    public WebConfig(CORSInterceptor corsInterceptor, LoggingInterceptor loggingInterceptor) {
        this.corsInterceptor = corsInterceptor;
        this.loggingInterceptor = loggingInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(corsInterceptor);
        registry.addInterceptor(loggingInterceptor);
    }
}
