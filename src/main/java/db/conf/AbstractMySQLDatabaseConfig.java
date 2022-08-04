package db.conf;

import config.ConfigProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

@Slf4j
@Configuration
@EnableTransactionManagement
public abstract class AbstractMySQLDatabaseConfig {

    protected abstract LocalContainerEntityManagerFactoryBean entityManager();

    protected abstract PlatformTransactionManager transactionManager(EntityManagerFactory invoiceEntityManager);

    protected abstract String getPackageToScan();

    protected LocalContainerEntityManagerFactoryBean createEntityManagerFactory() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource(ConfigProvider.DB_URL, ConfigProvider.DB_USERNAME, ConfigProvider.DB_PASSWORD);
        final HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter() {{
            setShowSql(log.isDebugEnabled());
            setGenerateDdl(false);
            setDatabase(Database.MYSQL);
        }};

        return new LocalContainerEntityManagerFactoryBean() {{
            setDataSource(new LazyConnectionDataSourceProxy(dataSource));
            setJpaVendorAdapter(adapter);
            setPackagesToScan(getPackageToScan());
        }};

    }

    protected PlatformTransactionManager createTransactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
