package com.lq.plat.link.config;

import com.lq.plat.link.PlatFormCorsConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/16
 */
@Configuration
public class CorsConfig extends PlatFormCorsConfig {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT","OPTIONS")
                .maxAge(3600);
    }
}