package org.example.learnhubproject.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("LearnHub API")
                        .description("개발자 학습 자료 큐레이션 북마크 서비스 API 문서")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("LearnHub Team")
                                .email("learnhub@example.com")));
    }
}
