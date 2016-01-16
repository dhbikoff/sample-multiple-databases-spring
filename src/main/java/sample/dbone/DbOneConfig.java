package sample.dbone;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "dbOneEntityManager",
        transactionManagerRef = "dbOneTransactionManager",
        basePackages = "sample.dbone"
)
@ComponentScan
@EnableTransactionManagement
public class DbOneConfig {

    @Value("${dbone.datasource.url}")
    private String url;
    @Value("${dbone.datasource.username}")
    private String username;
    @Value("${dbone.datasource.password}")
    private String password;

    @Bean
    public DataSource dbOneDataSource() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL(url);
        mysqlDataSource.setUser(username);
        mysqlDataSource.setPassword(password);

        return mysqlDataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean dbOneEntityManager() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setDatabase(Database.MYSQL);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

        DataSource dataSource = dbOneDataSource();
        factory.setDataSource(dataSource);
        factory.setPackagesToScan("sample.dbone");
        factory.setJpaVendorAdapter(jpaVendorAdapter);
        factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);

        return factory;
    }

    @Bean
    public PlatformTransactionManager dbOneTransactionManager() {
        return new JpaTransactionManager(dbOneEntityManager().getObject());
    }
}
