 package example.bean;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import lombok.Data;

@Data
public class MyEvenPlush implements ApplicationEventPublisherAware{
    
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
    
    public void publish() {
       MyEvent myEven = new MyEvent(this); 
       applicationEventPublisher.publishEvent(myEven);
    }

}
