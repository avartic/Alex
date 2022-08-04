package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"ui", "db"})
public class SpringConfig {

    @Bean
    ObjectMapper objectMapper(){
        return new ObjectMapper().findAndRegisterModules();
    }
}
