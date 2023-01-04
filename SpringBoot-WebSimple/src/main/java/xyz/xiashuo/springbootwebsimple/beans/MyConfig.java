package xyz.xiashuo.springbootwebsimple.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * 使用SpringBoot自动配置，同时自己自定义Web
 */
@Configuration(proxyBeanMethods = false)
public class MyConfig implements WebMvcConfigurer {

    @Bean
    public HiddenHttpMethodFilter myHiddenHttpMethodFilter() {
        HiddenHttpMethodFilter filter = new HiddenHttpMethodFilter();
        filter.setMethodParam("_m");
        return filter;
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper pathHelper = new UrlPathHelper();
        pathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(pathHelper);
    }

    @Bean
    @Order(1)
    public User myBean() {
        User user = new User();
        user.setId(456);
        user.setName("aaa");
        user.setAge(20);
        return user;
    }

}
