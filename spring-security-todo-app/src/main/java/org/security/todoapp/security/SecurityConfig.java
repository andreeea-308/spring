package org.security.todoapp.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${spring.security.user.name}")
    private String propsUserName;
    @Value("${spring.security.user.password}")
    private String propsPassword;

    @Autowired

}
    /*
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails genericUser = User.builder()
                .username(propsUserName)
                .password(passwordEncoder().encode(propsPassword))
                .roles("USER")
                .build();

        UserDetails genericAdmin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin123"))
                .roles("ADMIN")
                .build();

        UserDetails genericGuest = User.builder()
                .username("guest")
                .password(passwordEncoder().encode("guest123"))
                .roles("GUEST")
                .build();

        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(genericUser);
        userDetailsManager.createUser(genericAdmin);
        userDetailsManager.createUser(genericGuest);
        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(
                        ahrIt -> ahrIt
                                .requestMatchers("/", "/login", "/sing-up", "/webjars/**", "/h2-console/**")
                                .permitAll().anyRequest().authenticated()
                )
                .formLogin(
                        flIt -> flIt
                                .loginPage("/login")
                                .defaultSuccessUrl("/todo-list", true)
                                .permitAll()
                )
                .logout(
                        loIt -> loIt
                                .logoutSuccessUrl("/login")
                                .permitAll()
                )
                .csrf(
                        csrfIt -> csrfIt.disable()
                )
                .headers(
                        headersIt ->headersIt.frameOptions(
                                foIt -> foIt.disable()
                        )
                );

        return httpSecurity.build();
    }
*/


