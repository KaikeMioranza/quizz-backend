package com.back_end.Quizz.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayAfterHibernate {
    // Criar manualmente o bean do Flyway

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public Flyway flyway() {
        return Flyway.configure()
                .dataSource(
                        url,
                        username,
                        password
                )
                .locations("classpath:db/migration")
                .baselineOnMigrate(true)
                .load();
    }
    @Bean
    public ApplicationRunner runFlywayAfterHibernate(Flyway flyway) {
        return args -> {
            flyway.migrate();
            System.out.println("✅ Migrações Flyway executadas após o Hibernate.");
        };
    }
}