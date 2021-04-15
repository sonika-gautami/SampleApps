package test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "test")
@Slf4j
public class RestApp {

    public static void main(String[] args) {
        log.info("-------------------------------------");
        log.info("--------------SpringBoot App----------------");
        log.info("-------------------------------------");
        SpringApplication.run(RestApp.class);
    }
}
