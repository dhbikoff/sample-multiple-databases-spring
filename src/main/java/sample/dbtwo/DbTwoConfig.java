package sample.dbtwo;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "dbTwoEntityManager",
        transactionManagerRef = "dbTwoTransactionManager",
        basePackages = "sample.dbtwo"
)
public class DbTwoConfig {

    @Value("${dbtwo.datasource.url}")
    private String url;
    @Value("${dbtwo.datasource.username}")
    private String username;
    @Value("${dbtwo.datasource.password}")
    private String password;

    @Bean
    public DataSource dbTwoDataSource() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL(url);
        mysqlDataSource.setUser(username);
        mysqlDataSource.setPassword(password);

        return mysqlDataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean dbTwoEntityManager() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setDatabase(Database.MYSQL);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

        DataSource dataSource = dbTwoDataSource();
        factory.setDataSource(dataSource);
        factory.setPackagesToScan("sample.dbtwo");
        factory.setJpaVendorAdapter(jpaVendorAdapter);
        factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);

        return factory;
    }

    @Bean
    public PlatformTransactionManager dbTwoTransactionManager() {
        return new JpaTransactionManager(dbTwoEntityManager().getObject());
    }
}
