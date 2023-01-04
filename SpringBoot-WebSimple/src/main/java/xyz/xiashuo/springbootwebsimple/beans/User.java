package xyz.xiashuo.springbootwebsimple.beans;

import lombok.Data;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Data
@Order(2)
public class User {
    
    private Integer id = 123;
    
    private String name = "xiashuo";
    
    private Integer age;
    
}
