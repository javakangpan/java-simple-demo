 package bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(Config_A.class)
 public class Config_B {
    @Bean
    public Simple_techer_Test techer_Test() {
        return new Simple_techer_Test();
    }
}
