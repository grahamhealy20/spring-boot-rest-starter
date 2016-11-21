package app;

import app.model.user.CustomUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@RestController
@EnableResourceServer
public class ResourceServerConfiguration extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(ResourceServerConfiguration.class);
        SpringApplication.run(ResourceServerConfiguration.class, args);
    }

    @RequestMapping("/user")
    public CustomUser user(@AuthenticationPrincipal CustomUser activeUser) {
        return activeUser;
    }

}
