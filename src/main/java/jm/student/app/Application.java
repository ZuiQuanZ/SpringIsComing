package jm.student.app;

import jm.student.services.RoleService;
import jm.student.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "jm.student")
@EntityScan(basePackages = "jm.student.models")

public class Application {
    @Bean(initMethod = "init")
    @Autowired
    public TestDataInit initTestData(UserService userService, RoleService roleService) {
        return new TestDataInit(userService, roleService);
    }

    public static void main(String[] args) {

        SpringApplication.run(Application.class);

    }
}
