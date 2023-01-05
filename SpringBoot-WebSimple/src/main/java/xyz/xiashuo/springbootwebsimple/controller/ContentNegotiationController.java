package xyz.xiashuo.springbootwebsimple.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.xiashuo.springbootwebsimple.domain.XiaShuoMessage;

@RestController
@RequestMapping("/ContentNegotiation")
public class ContentNegotiationController {

    /**
     * 能处理 XiaShuoMessage 类型返回值且将其转化为 application/xs 类型的 MediaType 的只有 XiaShuoMessageConverter
     */
    @RequestMapping("/XiaShuo")
    public XiaShuoMessage getXiaShuoMessage() {
        XiaShuoMessage xiaShuoMessage = new XiaShuoMessage();
        xiaShuoMessage.setName("xiashuo");
        xiaShuoMessage.setAge(20);
        xiaShuoMessage.setInfo("这是我的自定义的协议");
        return xiaShuoMessage;
    }

}