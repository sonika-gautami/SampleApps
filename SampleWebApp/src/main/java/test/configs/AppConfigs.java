package test.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.List;

@Configuration
public class AppConfigs {

    @Bean
    @Qualifier("noStrs")
    public List<String> data() throws IOException {
        return List.of("one", "two");
    }
}