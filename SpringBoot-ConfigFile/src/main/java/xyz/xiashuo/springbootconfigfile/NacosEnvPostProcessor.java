package xyz.xiashuo.springbootconfigfile;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.logging.DeferredLog;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 注意，在高版本的SpringBoot中，这个操作可能不行，比如在2.7.4中，就不行
 * 在 2.7.4 ConfigFileApplicationListener 甚至开始被弃用
 */
public class NacosEnvPostProcessor implements EnvironmentPostProcessor, ApplicationListener<ApplicationEvent>, Ordered {

    /**
     * 这个时候Log系统还没有初始化  使用DeferredLog来记录  并在onApplicationEvent进行回放
     */
    private static final DeferredLog LOGGER = new DeferredLog();

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        LOGGER.info("打印日志");
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        LOGGER.replayTo(NacosEnvPostProcessor.class);
    }
}