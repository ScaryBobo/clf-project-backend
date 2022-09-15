package VTTP.CLF_project_1.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CORSConfiguration implements WebMvcConfigurer {

    private String path;
    private String origin;
    public CORSConfiguration (String p, String o){
        path = p;
        origin = o;
    }
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry){
        corsRegistry.addMapping(path).allowedOrigins(origin);
    }

}
