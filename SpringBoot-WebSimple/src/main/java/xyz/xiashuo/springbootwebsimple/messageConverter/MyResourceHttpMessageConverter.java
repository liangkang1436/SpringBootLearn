package xyz.xiashuo.springbootwebsimple.messageConverter;


import org.springframework.core.annotation.Order;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class MyResourceHttpMessageConverter extends ResourceHttpMessageConverter {

}
