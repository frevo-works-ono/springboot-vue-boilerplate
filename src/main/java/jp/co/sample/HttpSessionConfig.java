package jp.co.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

@EnableRedisHttpSession
public class HttpSessionConfig {
  @Bean
  HttpSessionStrategy httpSessionStrategy() {
    return new CookieHttpSessionStrategy();
  }
}
