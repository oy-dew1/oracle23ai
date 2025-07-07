package com.oliveyoung.oracle23ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.r2dbc.core.DatabaseClient;

@SpringBootApplication(
		exclude = {
				org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class,
				org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration.class,
				org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration.class
		}
)
public class Oracle23aiApplication {

	private final DatabaseClient db;

	public Oracle23aiApplication(DatabaseClient db) {
		this.db = db;
	}

	public static void main(String[] args) {
		SpringApplication.run(Oracle23aiApplication.class, args);
	}

}
