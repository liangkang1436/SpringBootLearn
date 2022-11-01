package xyz.xiashuo.springbootconfigfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootConfigFileApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootConfigFileApplication.class, args);
        String property = context.getEnvironment().getProperty("spring.application.name");
        System.out.println(property);
    }

}
