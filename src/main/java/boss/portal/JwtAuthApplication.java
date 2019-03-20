package boss.portal;

import boss.portal.util.ApplicationUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
