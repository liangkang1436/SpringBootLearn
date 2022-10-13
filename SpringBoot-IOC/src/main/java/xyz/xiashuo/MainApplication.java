package xyz.xiashuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationImportFilter;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.support.SpringFactoriesLoader;
import xyz.xiashuo.bean.MyPropertyMapBean;
import xyz.xiashuo.bean.MyPropertyMapBean2;
import xyz.xiashuo.config.MyConfig;
import xyz.xiashuo.domain.Pet;
import xyz.xiashuo.domain.User;

import java.util.List;

/**
 * 主程序类
 *
 * @SpringBootApplication：这是一个SpringBoot应用
 */
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);
    }

    public static void main5(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);
        ServerProperties serverProperties = context.getBean(ServerProperties.class);
        System.out.println(serverProperties.getPort()+serverProperties.getServlet().getContextPath());
    }

    public static void main4(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);
        List<AutoConfigurationImportFilter> autoConfigurationImportFilter = SpringFactoriesLoader.loadFactories(AutoConfigurationImportFilter.class, null);
        System.out.println(autoConfigurationImportFilter.size());
        List<String> enableAutoConfigurations  = SpringFactoriesLoader.loadFactoryNames(EnableAutoConfiguration.class, null);
        System.out.println(enableAutoConfigurations.size());
        try {
            Class<?> aClass = Class.forName(enableAutoConfigurations.get(0));
            Object o = aClass.newInstance();
            System.out.println(o.toString());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main3(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);
        // 原本想直接通过getBean方法获取 AutoConfigurationPackages.BasePackages 类型的ban，但是
        // 根据权限设计和包设计，无法直接获取 AutoConfigurationPackages.BasePackages 类，
        // 算了，直接使用 AutoConfigurationPackages.get 算了
        List<String> strings = AutoConfigurationPackages.get(context);
        System.out.println(strings);
    }

    public static void main2(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class, args);
        MyPropertyMapBean myPropertyMapBean = context.getBean("myPropertyMapBean", MyPropertyMapBean.class);
        System.out.println(myPropertyMapBean.toString());
        MyPropertyMapBean MyPropertyMapBean1 = context.getBean("MyPropertyMapBean1", MyPropertyMapBean.class);
        System.out.println(MyPropertyMapBean1.toString());
        MyPropertyMapBean2 bean = context.getBean(MyPropertyMapBean2.class);
        System.out.println(bean.toString());
    }

    public static void main1(String[] args) {
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
