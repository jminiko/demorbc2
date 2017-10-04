package info.iniko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class BackApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BackApplication.class, args);
    }

}
