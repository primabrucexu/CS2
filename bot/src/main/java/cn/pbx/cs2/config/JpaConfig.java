package cn.pbx.cs2.config;

import cn.hutool.core.io.FileUtil;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author BruceXu
 */
@Configuration
public class JpaConfig {

    private static final String DB_PATH = System.getProperty("user.home") + File.separator + "cs2.db";
    private static final boolean EXIST_DATABASE = FileUtil.exist(DB_PATH);


    @Bean
    public DataSource dataSource() {
        DataSourceBuilder<HikariDataSource> builder = DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .driverClassName("org.sqlite.JDBC")
                .url("jdbc:sqlite:" + DB_PATH);

        HikariDataSource dataSource = builder.build();
        dataSource.setMaximumPoolSize(8);
        return dataSource;
    }

    @Bean
    public JpaProperties jpaProperties(JpaProperties properties) {
        Map<String, String> map = new HashMap<>();
        map.put("hibernate.hbm2ddl.auto", EXIST_DATABASE ? "update" : "create");
        map.put("hibernate.dialect", "org.hibernate.community.dialect.SQLiteDialect");
        properties.setGenerateDdl(true);
        properties.setShowSql(true);
        properties.setProperties(map);
        return properties;
    }
}
