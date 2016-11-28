package app.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Bipin on 11/28/2016.
 */
@Configuration
@EnableJpaRepositories(basePackages = {"app.repositories"})
@EnableScheduling
public class RepositoryConfiguration {
}

