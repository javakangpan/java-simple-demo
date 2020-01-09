 package example.bean;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class ContextStartTest implements ApplicationListener<ContextStartedEvent>{

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        
        System.out.println("context start begin doing...");
         
    }

}
