package xyz.xiashuo.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import xyz.xiashuo.domain.Pet;
import xyz.xiashuo.domain.User;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(classes = TestImportConfig.class)
class MyConfigTest {

    @Autowired
    ApplicationContext context;

    @Test
    public void test() throws Exception {
        Pet pet = context.getBean(Pet.class);
        User user = context.getBean(User.class);
        assertNotNull(pet);
        System.out.println("Pet 组件的名称："+ Arrays.toString(context.getBeanNamesForType(Pet.class)));
        System.out.println("Pet 组件的内容："+pet);
        assertNotNull(user);
        System.out.println("User 组件的名称："+Arrays.toString(context.getBeanNamesForType(User.class)));
        System.out.println("User 组件的内容："+user);
    }

}