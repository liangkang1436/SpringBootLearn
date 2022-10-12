package xyz.xiashuo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.xiashuo.bean.MyPropertyMapBean;
import xyz.xiashuo.bean.MyPropertyMapBean2;

@Configuration
@EnableConfigurationProperties(MyPropertyMapBean2.class)
public class ConfigurationPropertyConfig {

    @Bean("MyPropertyMapBean1")
    @ConfigurationProperties(prefix = "myprop1")
    public MyPropertyMapBean getBean() {
        return new MyPropertyMapBean();
    }

}
