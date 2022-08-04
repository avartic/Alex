package db.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.config.BootstrapMode;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(basePackages = "db.repository",
        entityManagerFactoryRef = "usersEntityManager",
        transactionManagerRef = "usersTransactionManager",
        bootstrapMode = BootstrapMode.LAZY)
public class UsersPersistenceConfig extends AbstractMySQLDatabaseConfig {

    @Bean("usersEntityManager")
    @Override
    public LocalContainerEntityManagerFactoryBean entityManager() {
        return super.createEntityManagerFactory();
    }

    @Bean("usersTransactionManager")
    @Override
    public PlatformTransactionManager transactionManager(EntityManagerFactory usersEntityManager) {
        return super.createTransactionManager(usersEntityManager);
    }

    @Override
    protected String getPackageToScan() {
        return "db.model";
    }
}

