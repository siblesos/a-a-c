package com.adc.da.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;

/**
 * 网关做资源服务器
 *
 */

@Configuration
@EnableResourceServer
public class ADCResourceConfigurerAdapter extends ResourceServerConfigurerAdapter {
    @Autowired
    private OAuth2WebSecurityExpressionHandler expressionHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http
            .authorizeRequests()
            .antMatchers("/auth/oauth/token_key").denyAll()
            .antMatchers(
                "/auth/**",
                "/admin/user/info",
                "/admin/menu/userMenu",
                "/*/swagger-ui.html",
                "/*/swagger-resources/**",
                "/*/v2/api-docs",
                "/*/swagger/api-docs",
                "/*/webjars/**").permitAll()
            .anyRequest()
            .access("@permissionService.hasPermission(request, authentication)");
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.expressionHandler(expressionHandler);
    }

    /**
     * 异常问题
     * #oauth2.throwOnError(@permissionService.hasPermission(request, authentication))
     * https://github.com/spring-projects/spring-security-oauth/issues/730
     *
     * @param applicationContext ApplicationContext
     * @return OAuth2WebSecurityExpressionHandler
     */
    @Bean
    public OAuth2WebSecurityExpressionHandler oAuth2WebSecurityExpressionHandler(ApplicationContext applicationContext) {
        OAuth2WebSecurityExpressionHandler expressionHandler = new OAuth2WebSecurityExpressionHandler();
        expressionHandler.setApplicationContext(applicationContext);
        return expressionHandler;
    }
}
