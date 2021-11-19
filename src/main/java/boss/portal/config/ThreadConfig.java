package boss.portal.config;

import boss.portal.util.ApplicationUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @FileName: ThreadConfig
 * @Author: zhaoxinguo
 * @Date: 2019/3/20 18:24
 * @Description: 线程池配置
 */
@Configuration
public class ThreadConfig {

    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(100);
        executor.setKeepAliveSeconds(30000);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("default_task_executor_thread");
        executor.initialize();
        return executor;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ApplicationUtil applicationUtil() {
        return new ApplicationUtil();
    }

}
