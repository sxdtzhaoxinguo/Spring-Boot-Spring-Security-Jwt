package boss.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import boss.portal.util.ApplicationUtil;

@SpringBootApplication
public class JwtAuthApplication {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public ApplicationUtil applicationUtil() {
		return new ApplicationUtil();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(JwtAuthApplication.class, args);
	}
}
