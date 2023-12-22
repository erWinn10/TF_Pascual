package com.cocobolo.t4pascual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.cocobolo.t4pascual.model.service.UserService;

@Configuration
public class SpringSecurityConfig {

    @Autowired
    private UserService userService;

    public static BCryptPasswordEncoder encriptarPassword(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void criptografiaPassword(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(encriptarPassword());
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
        .anyRequest().authenticated()
        .and().formLogin().loginPage("/autenticar/").defaultSuccessUrl("/admin/").permitAll()
        .and().logout().permitAll();
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() throws Exception{
        return (web)->web.ignoring().antMatchers("/","/inicio/","/inicio/Bebitos","/inicio/Bebitas",
        "/inicio/Extras", "/inicio/Accesorios", "/inicio/guardar-pedido","/inicio/guardar-correo","/inicio/Juguetes","/css/**","/js/**","/images/**");
    }
}
