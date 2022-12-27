package xyz.xiashuo.springbootwebsimple.beans;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@Component
public class UserObjectProviderTest {

    public UserObjectProviderTest(ObjectProvider<User> users) {
        users.ifAvailable((user) -> System.out.println(user.toString()));
    }
}
