package xyz.xiashuo.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import xyz.xiashuo.domain.MyBean;

import java.util.Arrays;

@SpringJUnitConfig(classes = ConditionalConfig.class)
class ConditionalConfigTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void setUp() throws Exception {
        String[] beanNamesForType = context.getBeanNamesForType(MyBean.class);
        System.out.println(Arrays.toString(beanNamesForType));
    }

}