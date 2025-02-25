package com.mandu.productManagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


//This is the entry point for spring security. This class is responsible for authenticating the user
//@EnableWebSecurity annotation is used to enable web security in the application

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
    @Autowired
    private UserDetailsService userDetailsService;

    //This method is used to configure the security filter chain. It is used to configure the security filter chain that is responsible for authenticating the user
    //http.authorizeHttpRequests is used to authorize the requests. It is used to authorize the requests based on the URL patterns.
    //In this case, we have authorized all the requests using anyRequest().authenticated()
    //http.formLogin is used to configure the form login. It is used to configure the form login page, login processing URL, default success URL, and failure URL
    //http.httpBasic is used to configure the HTTP basic authentication. It is used to configure the HTTP basic authentication
    //all API calls are also authenticated using httpBasic(Customizer.withDefaults())
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(AbstractHttpConfigurer::disable)
//
//                //This is to enable my own login page and invalidate HTTP session on logout and clear all authentication on logout
//                .formLogin(Customizer.withDefaults())
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .invalidateHttpSession(true)
//                        .clearAuthentication(true)
//                        .logoutSuccessUrl("/logout.jsp")
//                )
//                .authorizeHttpRequests(authorizeRequests ->
//                        authorizeRequests
//                                .requestMatchers("/login.jsp").permitAll()
//                                .anyRequest().authenticated()
//                );

            .authorizeHttpRequests(request -> request.anyRequest().authenticated())
            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }


//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//
//                .authorizeHttpRequests(authorizeRequests ->
//                        authorizeRequests
//                                .requestMatchers("/login.jsp", "/logout.jsp").permitAll()
//                                .anyRequest().authenticated()
//                )
//                .formLogin(formLogin ->
//                        formLogin
//                                .loginPage("/login.jsp")
//                                .loginProcessingUrl("/login")
//                                .defaultSuccessUrl("/", true)
//                                .failureUrl("/login.jsp?error=true")
//                )
//                .logout(logout ->
//                        logout
//                                .logoutUrl("/logout")
//                                .logoutSuccessUrl("/logout.jsp")
//                );
//        return http.build();
//    }

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
        //provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

    //here we have used BCryptPasswordEncoder to encode the password.
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
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