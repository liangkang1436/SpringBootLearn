package xyz.xiashuo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.xiashuo.domain.Pet;
import xyz.xiashuo.domain.User;

/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理bean的方法
 * Full(proxyBeanMethods = true)、【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 * Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
 * 组件依赖必须使用Full模式默认。其他默认是否Lite模式
 */
//告诉SpringBoot这是一个配置类 == 配置文件
@Configuration(proxyBeanMethods = true)
public class MyConfig {

    //给容器中添加组件。以方法名作为组件的id。返回类型就是组件类型。返回的值，就是组件在容器中的实例
    @Bean
    public User User01() {
        User zhagnsan = new User("zhagnsan", 18);
        zhagnsan.setPet(Tom());
        return zhagnsan;
    }

    @Bean
    public Pet Tom() {
        return new Pet("tomcat");
    }

}