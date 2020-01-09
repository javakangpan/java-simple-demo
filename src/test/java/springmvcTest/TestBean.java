package springmvcTest;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import bean.Config_B;
import bean.HelloWorld;
import bean.Person;
import bean.Simple_Student_Test;
import bean.Simple_techer_Test;
import example.bean.MyEvenPlush;

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
        // ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        HelloWorld helloWorld = (HelloWorld)context.getBean("helloWorld");
        context.registerShutdownHook();
        
        context.start();
        context.stop();

        ApplicationContext ctx = new AnnotationConfigApplicationContext(Person.class);
        Person person = ctx.getBean(Person.class);
        System.out.println(person);
        
        ApplicationContext ctx2 = new AnnotationConfigApplicationContext(Config_B.class);
        Simple_techer_Test techer_Test = ctx2.getBean(Simple_techer_Test.class);
        Simple_Student_Test student_Test = ctx2.getBean(Simple_Student_Test.class);
        
        
        ApplicationContext ctx3 = new ClassPathXmlApplicationContext("bean.xml");
        MyEvenPlush plush = ctx3.getBean(MyEvenPlush.class);
        plush.publish();

        // XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("bean.xml"));
        // HelloWorld obj = (HelloWorld)factory.getBean("helloWorld");
        // obj.getMessage();

    }
}
