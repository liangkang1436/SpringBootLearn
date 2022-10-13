package xyz.xiashuo.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "myprop")
@Data
public class MyPropertyMapBean {

    private String name;

    private Integer age;

    private String gender;

}
