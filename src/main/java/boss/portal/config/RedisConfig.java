package boss.portal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @FileName: RedisConfig
 * @Author: zhaoxinguo
 * @Date: 2019/3/20 17:07
 * @Description: Redis配置类
 */
@Configuration
@ComponentScan("boss.portal.config")
public class RedisConfig {

    @Bean
    JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(10);
        jedisPoolConfig.setMaxTotal(10);
        return jedisPoolConfig;
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
        jedisConFactory.setHostName("192.168.0.213");
        jedisConFactory.setPort(6379);
        jedisConFactory.setPassword("ydw@123");
        jedisConFactory.setPoolConfig(jedisPoolConfig());
        jedisConFactory.setDatabase(7);
        return jedisConFactory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        return template;
    }

}
