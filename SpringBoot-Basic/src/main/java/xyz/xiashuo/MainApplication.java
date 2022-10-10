package xyz.xiashuo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序类
 *
 * @SpringBootApplication：这是一个SpringBoot应用
 */
@SpringBootApplication
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("xyz.xiashuo")
public class MainApplication {

    public static void main(String[] args) {
        //SpringApplication.run(MainApplication.class,args);
        // 1. 返回IOC容器 ConfigurableApplicationContext 实际上就是IOC容器
        // ConfigurableApplicationContext 接口实现了ApplicationContext接口，实际上就是当前应用中Spring上下文的具体实现类
        final ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        // 2. 打印容器里的所有组件的名称
        // 上面的那些组件都默认包含在输出结果里
        // 当然也包括我们自己写的一些业务组件
        final String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            //System.out.println(name);
        }
    }
}
