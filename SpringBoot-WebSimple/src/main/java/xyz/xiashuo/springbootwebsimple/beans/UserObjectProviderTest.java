package xyz.xiashuo.springbootwebsimple.beans;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UserObjectProviderTest {

    @Autowired
    //只注入 id为user的Userbean。
    @Qualifier("user")
    ObjectProvider<User> users;

    @PostConstruct
    public void init() {
        users.ifAvailable((user) -> System.out.println(user.toString()));
    }

    //public UserObjectProviderTest(ObjectProvider<User> users) {
    //    // 会直接报错？
    //    //users.ifAvailable((user) -> System.out.println(user.toString()));
    //    User ifUnique = users.getIfUnique();
    //    System.out.println(ifUnique == null);
    //    //ObjectProvider 支持迭代器 iterator
    //    // 按照注册顺序输出
    //    for (User user : users) {
    //        System.out.println(user);
    //    }
    ////    orderedStream 会使用 @Order排序，输出
    //    users.orderedStream().forEach((user) -> {
    //        System.out.println(user);
    //    });
    //}

    //public UserObjectProviderTest(ObjectProvider<User> users) {
    //    //ObjectProvider 支持迭代器 iterator
    //    // 按照注册顺序输出
    //    System.out.println("------------ iterator() 方法输出 ------------------");
    //    for (User user : users) {
    //        System.out.println(user);
    //    }
    //    System.out.println("------------ orderedStream() 方法输出 ------------------");
    //    // orderedStream 会使用 @Order排序，输出
    //    users.orderedStream().forEach((user) -> {
    //        System.out.println(user);
    //    });
    //}

    //public UserObjectProviderTest(ObjectProvider<User> users) {
    //    User ifUnique = users.getIfUnique();
    //    if (ifUnique != null) {
    //        System.out.println(ifUnique);
    //    }else{
    //        System.out.println("返回null");
    //    }
    //}


}
