package co.edu.umb.academia.siajardin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"co.edu.umb.academia.siajardin.repo"})
public class SiajardinApplication {

    public static void main(String[] args) {
        SpringApplication.run(SiajardinApplication.class, args);
    }

}
