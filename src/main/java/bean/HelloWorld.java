 package bean;



import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString 
@NoArgsConstructor
 public class HelloWorld {
    private String message;
    public void init(){
        System.out.println(this.getClass().getSimpleName() + " : init");
     }
     public void destroy(){
        System.out.println(this.getClass().getSimpleName() + " : destroy");
     }
}
