 package bean;



import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString 
@NoArgsConstructor
 public class HelloWorld {
    private String message;
    
    @PostConstruct
    public void init(){
        System.out.println(this.getClass().getSimpleName() + " : init");
     }
    @PreDestroy
     public void destroy(){
        System.out.println(this.getClass().getSimpleName() + " : destroy");
     }
}
