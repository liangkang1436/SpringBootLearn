package xyz.xiashuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import xyz.xiashuo.config.MyConfig;
import xyz.xiashuo.domain.Pet;
import xyz.xiashuo.domain.User;

/**
 * 主程序类
 * @SpringBootApplication：这是一个SpringBoot应用
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        //ConfigurableApplicationContext 实际上就是IOC容器
        final ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);
        // 打印容器里的所有组件
        final String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            // System.out.println(name);
        }
        System.out.println("-----------------------------------------------------------------------------------------");

        //配置类也是一个对象
        //注意类声明bean的时候的默认bean名称时类目的首字母转成小写之后的结果，@Component的特性
        MyConfig myConfig = context.getBean("myConfig", MyConfig.class);
        System.out.println(myConfig);

        //这段代码很关键，体现出了被代理和没被代理的区别
        //从容器中拿呢？还是直接调用普通的方法新建呢？
        //如果proxyBeanMethods = true ，这个myConfig本身就是一个代理对象com.liangkang.config.MyConfig$$EnhancerBySpringCGLIB$$7712299a@430fa4ef，代理对象调用方法也是代理方法
        User configUser01 = myConfig.User01();
        User configUser02 = myConfig.User01();

        System.out.println("通过配置类获取bean:" + (configUser01 == configUser02));

        Pet tom01 = context.getBean("Tom", Pet.class);
        Pet tom02 = context.getBean("Tom", Pet.class);
        System.out.println("从容器中获取的两个tom:" + (tom01 == tom02));

        User user01 = context.getBean("User01", User.class);
        User user02 = context.getBean("User01", User.class);
        System.out.println("从容器中获取的两个user:" + (user01 == user02));

        User user03 = context.getBean("User01", User.class);
        System.out.println("从容器中获得的User中获取的Pet和容器中的Pete是否相等" + (user03.getPet() == tom02));

        //结果
        // proxyBeanMethods = false
        //    com.liangkang.config.MyConfig@11a82d0f
        // 通过配置类获取bean:false
        // 从容器中获取的两个tom:true
        // 从容器中获取的两个user:true
        // 从容器中获得的User中获取的Pet和容器中的Pete是否相等false

        //proxyBeanMethods = true
        //    com.liangkang.config.MyConfig$$EnhancerBySpringCGLIB$$7712299a@430fa4ef
        // 通过配置类获取bean:true
        // 从容器中获取的两个tom:true
        // 从容器中获取的两个user:true
        // 从容器中获得的User中获取的Pet和容器中的Pete是否相等true

    }
}
