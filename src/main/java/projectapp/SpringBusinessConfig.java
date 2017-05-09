package projectapp;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;

@SuppressWarnings("unused")
@Configuration
@ComponentScan(basePackages = { "projectapp" }, excludeFilters = {
        @Filter(type = FilterType.REGEX, pattern = "projectapp\\.web\\..*") })
//@ImportResource({"classpath:/applicationContext.xml"})//,"classpath:/database-config.xml"})
public class SpringBusinessConfig {

/*    @Autowired
    DataSource dataSource;
    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }*/
}