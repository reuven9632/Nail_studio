package com.example.Nail_studio.security;

import com.example.Nail_studio.role.Permissions;
import com.example.Nail_studio.role.Role;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/a", "/css/**", "/js/**", "/images/**", "/fonts/**").permitAll()
                .antMatchers("/admin/**").hasRole(Role.ADMINISTRATOR.name())
                .antMatchers(HttpMethod.GET, "/management/**").hasAnyRole(Role.SPECIALIST.name(), Role.ADMINISTRATOR.name())
                .antMatchers(HttpMethod.POST, "/management/**").hasAuthority(Permissions.DIARY_WRITE.getPermission())
                .antMatchers(HttpMethod.DELETE, "/management/**").hasAnyAuthority(Permissions.ORDER_DROP.getPermission(), Permissions.OPTION_EXTRA.getPermission())  // TODO: 1/8/2023   check if I steel need this option  -> Permissions.OPTION_EXTRA.name()    before production
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
}


/*@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/**", "/registration", "/activate/*", "/css/**", "/images/**", "/js/**", "/fonts/**").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        *//**
         * his options located on: service/UserService and need @Autowired   private UserService userService;
         *//*
        auth.userDetailsService(userService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}*/

