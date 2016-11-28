package app.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Bipin on 11/28/2016.
 */
@Configuration
@ComponentScan(basePackages = "app")
@EnableWebMvc
public class SpringConfiguration {
}
