 package example.bean;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

public class ContextCloseTest implements ApplicationListener<ContextClosedEvent>{

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("context close doing...");
    }

}
