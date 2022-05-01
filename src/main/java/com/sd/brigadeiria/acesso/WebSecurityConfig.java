package com.sd.brigadeiria.acesso;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        .anyRequest().authenticated().and()
              /*  .authorizeRequests((authorize) -> authorize
                        .antMatchers("/css/**").permitAll()
                        .antMatchers("/cliente/**").hasRole("ADMIN")
                        .antMatchers("/produto/**").hasRole("ADMIN")
                        .antMatchers("/api/**").permitAll()     )*/       
                .formLogin(form -> form
                  .loginPage("/login")
                  .permitAll()
                  .defaultSuccessUrl("/home", true)
                )

                .logout(logout -> logout.logoutUrl("/logout") );
              
                //.and()
                //.headers().frameOptions().sameOrigin()
               // .and()
                //.csrf().ignoringAntMatchers("/h2-console/**","/admin/config");
//                .and()
//                .passwordManagement(Customizer.withDefaults());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/css/**")
                .antMatchers("/api/**");
    }
}


