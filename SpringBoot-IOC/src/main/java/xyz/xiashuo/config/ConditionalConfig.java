package xyz.xiashuo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import xyz.xiashuo.domain.MyBean;
import xyz.xiashuo.domain.Pet;

@Configuration
//这里手动导入 "classpath:application.properties" 是为了方便 测试
// 在通过 MainApplication 启动的时候，不需要手动导入，
@PropertySource("classpath:application.properties")
// 一般不建议在 @Configuration 上使用 @ConditionalOnBean， 因为`@Configuration`的加载顺序不好控制，
@ConditionalOnClass(value = MyBean.class)
public class ConditionalConfig {

    @Bean("myBean1")
    @ConditionalOnBean(name = "Tom33")
    public MyBean getMyBean1() {
        MyBean myBean = new MyBean();
        myBean.setName("myBean1");
        return myBean;
    }

    @Bean("myBean2")
    @ConditionalOnClass(value = Pet.class)
    public MyBean getMyBean2() {
        MyBean myBean = new MyBean();
        myBean.setName("myBean2");
        return myBean;
    }

    @Bean("myBean3")
    @ConditionalOnProperty(prefix = "system", name = "beanFlag", havingValue = "2")
    public MyBean getMyBean3() {
        MyBean myBean = new MyBean();
        myBean.setName("myBean3");
        return myBean;
    }

    @Bean("myBean4")
    @ConditionalOnResource(resources = "testConfig/aaa.properties")
    public MyBean getMyBean4() {
        MyBean myBean = new MyBean();
        myBean.setName("myBean4");
        return myBean;
    }


}
