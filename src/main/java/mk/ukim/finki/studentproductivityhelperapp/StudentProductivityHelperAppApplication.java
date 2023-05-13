package mk.ukim.finki.studentproductivityhelperapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//@EnableNeo4jRepositories("com.digital.api.repositories")
//@EnableJpaRepositories(basePackages = "mk.ukim.finki.studentproductivityhelperapp.model")
@EnableJpaRepositories(basePackages = "mk.ukim.finki.studentproductivityhelperapp.model")
@EntityScan
@EnableAutoConfiguration
@ComponentScan("mk.ukim.finki.studentproductivityhelperapp.repository")
public class StudentProductivityHelperAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentProductivityHelperAppApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}



}
