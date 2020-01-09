 package bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
 public class Config_A {
    @Bean
    public Simple_Student_Test geTest() {
        return new Simple_Student_Test();
    }
}
