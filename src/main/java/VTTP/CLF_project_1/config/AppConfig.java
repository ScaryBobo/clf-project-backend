package VTTP.CLF_project_1.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.logging.Logger;

@Configuration
public class AppConfig {

    private Logger logger = Logger.getLogger(AppConfig.class.getName());

    @Value("${cors.pathMapping}")
    String pathMapping;

    @Value("${cors.origins}")
    String origins;

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        logger.info("pathMapping: %s, Origins: %s".formatted(pathMapping,origins));
        return new CORSConfiguration(pathMapping, origins);
    }
}
