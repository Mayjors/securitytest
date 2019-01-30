package com.eu.authtest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

/**
 * security配置
 * @author yuanjie
 * @date 2019/1/30 16:42
 */
@Configuration
public class BrowerSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.formLogin()            // 定义当需要用户登录时，转到的登录页面
                .loginPage("/login.html")
                .loginProcessingUrl("/user/login")
                .and()
                .authorizeRequests()// 定义哪些URL需要被保护，哪些不需要
                // 设置所有人都可以访问登录页面
                .antMatchers("/login.html").permitAll()
                .anyRequest()       // 任何请求，登录后可以访问
                .authenticated()
                .and()
                .csrf().disable()
        ;  // 关闭csrf防护
    }

    /**
     * 密码加密解密
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置TokenRepository
     * @return
     */
//    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }
}
