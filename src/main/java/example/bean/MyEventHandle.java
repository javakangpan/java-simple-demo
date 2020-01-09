 package example.bean;

import org.springframework.context.ApplicationListener;

public class MyEventHandle implements ApplicationListener<MyEvent>{

    @Override
    public void onApplicationEvent(MyEvent event) {
         System.out.println(event);
    }

}
