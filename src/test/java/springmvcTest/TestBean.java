package springmvcTest;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import bean.HelloWorld;

/**
 * @see org.springframework.beans.BeansException.BeanFactoryAware
 * @see DisposableBean
 * @see InitializingBean
 * @author 康盼Java开发工程师
 */
public class TestBean {

    @SuppressWarnings("resource")
    @Test
    public void testHelloWorldBean() {
        //ApplicationContext context = new  ClassPathXmlApplicationContext("bean.xml");
        AbstractApplicationContext context = new  ClassPathXmlApplicationContext("bean.xml");
        HelloWorld helloWorld = (HelloWorld)context.getBean("helloWorld");
        context.registerShutdownHook();
        

//        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("bean.xml"));
//        HelloWorld obj = (HelloWorld)factory.getBean("helloWorld");
//        obj.getMessage();
//        
        
    }
}
