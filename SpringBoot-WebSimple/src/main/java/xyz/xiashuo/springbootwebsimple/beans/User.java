package xyz.xiashuo.springbootwebsimple.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class User {
    
    private Integer id = 123;
    
    private String name = "xiashuo";
    
    private Integer age;
    
}
