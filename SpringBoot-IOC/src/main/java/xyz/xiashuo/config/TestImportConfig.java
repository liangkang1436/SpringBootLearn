package xyz.xiashuo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import xyz.xiashuo.domain.Pet;
import xyz.xiashuo.domain.User;

@Import({Pet.class, User.class})
@Configuration
public class TestImportConfig {
}
