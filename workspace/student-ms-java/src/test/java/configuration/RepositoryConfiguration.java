package configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by rzhou on 10/08/2017.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"ms_student_score.core"})
@EnableJpaRepositories(basePackages = {"ms_student_score.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {

}
