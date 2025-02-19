package com.mandu.productManagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


//This is the entry point for spring security. This class is responsible for authenticating the user
//@EnableWebSecurity annotation is used to enable web security in the application

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
    @Autowired
    private UserDetailsService userDetailsService;
    //authenticationProvider() method is used to authenticate the user. It uses the userDetailsService to get the user details and NoOpPasswordEncoder to encode the password
    //we have created a MyUserDetailsService class that implements UserDetailsService interface. This class is used to get the user details from the database
    //We have also created a MyUserDetailsService class that implements UserDetails interface. This class is used to get the user details from the database
    //Within MyUserDetailsService, we have created a method loadUserByUsername() that takes the username as an argument and returns the user details
    //We have also created a UserPrincipal class that implements UserDetails interface. This class is used to get the user details from the database
    //Within UserPrincipal, we have created a method getAuthorities() that returns the authorities of the user
    //Username and passwords entered by the user is compared with the database values using the authenticationProvider() method
    //authenticationProvider() method is used to authenticate the user. It uses the userDetailsService to get the user details and NoOpPasswordEncoder to encode the password
    //We have also created a UserDetailsService class that implements UserDetailsService interface. This class is used to get the user details from the database

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }


//    @Bean
//    public UserDetailsService userDetailsService() {
//        List<UserDetails> users = new ArrayList<>();
//        users.add(User.withDefaultPasswordEncoder().username("mandu").password("mandu").roles("USER").build());
//        return new InMemoryUserDetailsManager(users);
//    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests(authorizeRequests ->
//                        authorizeRequests.anyRequest().authenticated()
//                )
//                .formLogin(withDefaults());
//        return http.build();
//    }
}