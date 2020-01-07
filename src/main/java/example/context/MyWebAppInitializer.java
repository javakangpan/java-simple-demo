 package example.context;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;
/**
 * @see WebApplicationInitializer
 * @See AbstractAnnotationConfigDispatcherServletInitializer
 * Spring MVC提供了一个WebApplicationInitializer接口，
 * 实现这个接口能保证你的配置能自动被检测到并应用于Servlet 3容器的初始化中。
 * WebApplicationInitializer有一个实现，是一个抽象的基类，
 * 名字叫AbstractDispatcherServletInitializer。
 * 有了它，要配置DispatcherServlet将变得更简单，
 * 你只需要覆写相应的方法，在其中提供servlet映射、DispatcherServlet所需配置的位置即可：
 */
public class MyWebAppInitializer {
    
}


//基于代码的Servlet容器初始化 
//public class MyWebAppInitializer extends AbstractDispatcherServletInitializer{
//
//    @Override
//    protected WebApplicationContext createServletApplicationContext() {
//        // TODO Auto-generated method stub
//         return null;
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[] { "/" };
//    }
//
//    @Override
//    protected WebApplicationContext createRootApplicationContext() {
//        XmlWebApplicationContext cxt = new XmlWebApplicationContext();
//        cxt.setConfigLocation("/WEB-INF/HelloWeb-servlet.xml");
//        return cxt;
//    }
//
//
//
//}
