package xyz.xiashuo.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import xyz.xiashuo.domain.User;

@ConfigurationProperties(prefix = "myprop2")
@Data
public class MyPropertyMapBean2 {

    private String name;

    private Integer age;

    private String gender;

    private User userProperty;
}
