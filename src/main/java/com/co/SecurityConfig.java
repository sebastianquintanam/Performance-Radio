package com.co;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    auth.inMemoryAuthentication()
            .withUser("admin")
                .password("{noop}1234")
                    .roles("ADMIN","USER")
                .and()
                    .withUser("user")
                        .password("{noop}123")
                            .roles("USER")
                           ;
        }            
@Override
protected void configure(HttpSecurity http) throws Exception{

        //Aqui voy a autorizar las paginas a las que puede acceder el rol adminstrador
        //http.authorizeRe va a autorizar acceso a lo siguiente:
        http.authorizeRequests()
                .antMatchers("/loginadmin")//Acceso a la web loginadmin
                    .hasRole("ADMIN")//rol permitido para acceder
                .and()//ademas permite:
                    .formLogin()//por medio del formulario login que entre por el controlador:
                        .loginPage("/login") //controlador login
                        .defaultSuccessUrl("/loginadmin")// va a ir a la web de login admin
                        .permitAll()//si se logea y puede entrar a todas las paginas
                ;                  
    }
}