package com.example.Nail_studio.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.Nail_studio.role.Role.ADMINISTRATOR;

@AllArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)     //for use @PostAuthorize on _Controller for implementing ROLE and PERMISSIONS
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private PasswordEncoder passwordEncoder;

    /**
     * <p>When I use .antMatchers()  it checks it step by step, if one of them fails all of below is not executing
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/a", "/css/**", "/js/**", "/images/**", "/fonts/**", "app/index").permitAll()
//                .antMatchers("/admin/**").hasRole(ADMINISTRATOR.name())
//                .antMatchers(HttpMethod.GET, "/management/**").hasAnyRole(SPECIALIST.name(), ADMINISTRATOR.name())
//                .antMatchers(HttpMethod.POST, "/management/**").hasAuthority(DIARY_WRITE.getPermission())
//                .antMatchers(HttpMethod.DELETE, "/management/**").hasAnyAuthority(ORDER_DROP.getPermission(), OPTION_EXTRA.getPermission())  // TODO: 1/8/2023   check if I steel need this option  -> Permissions.OPTION_EXTRA.name()    before production
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }


    // TODO: 1/9/2023 just for test, need delete before deploy
    @Bean(name = "WebSecurityConfig__UserDetailsService")
    @Override
    protected UserDetailsService userDetailsService(){
        UserDetails greg = User.builder()
                .username("Greg")
                .password(passwordEncoder.encode("password"))
                .roles(ADMINISTRATOR.name())
                .authorities(ADMINISTRATOR.getGrantedAuthorities())
                .build();
        return new InMemoryUserDetailsManager(greg);
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

