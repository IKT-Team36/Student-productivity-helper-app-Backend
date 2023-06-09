package mk.ukim.finki.studentproductivityhelperapp.security.config;



import lombok.AllArgsConstructor;
import mk.ukim.finki.studentproductivityhelperapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;



@EnableWebSecurity
@AllArgsConstructor
@Configuration
public class WebSecurityConfig {
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


        @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            CorsConfiguration corsConfig = new CorsConfiguration();
            corsConfig.addAllowedOrigin("*"); // Allow requests from any origin
            corsConfig.addAllowedMethod("*"); // Allow all HTTP methods
            corsConfig.addAllowedHeader("*"); // Allow all headers

            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", corsConfig);

            CorsFilter corsFilter = new CorsFilter(source);
            http.addFilterBefore(corsFilter, ChannelProcessingFilter.class);
        http.csrf().disable();
        http.authorizeHttpRequests((authz) -> authz.requestMatchers("/api/v*/registration/*","/api",
                                "/login","/api/v1/registration","/api/v*/login","/api/v1/test/*","/api/v1/confirm",
                                "/api/v1/registration/confirm?token=*","api/v1/test/add","" +
                                        "/api/v1/attachment/*","/api/v1/attachment/add",
                                "/api/v1/attachment/delete","/api/v1/attachment/delete/{id}","" +
                                        "/api/v1/attachment/delete/*","/api/v1/attachment/edit/{id}",
                                "/api/v1/attachment/edit/*","/api/v1/attachment/edit/*","/api/v1/toDo",
                                "/api/v1/toDo/*",
                                "/api/v1/toDo/add","/api/v1/toDo/edit/*","/api/v1/toDo/delete/*","/api/v1/topic","/api/v1/topic/*","/api/v1/topic/edit","/api/v1/topic/edit/{id}",
                                "/api/v1/topic/edit/*","/api/v1/topic/delete","/api/v1/topic/delete/{id}","/api/v1/topic/delete/*","/**").permitAll()
                        .anyRequest().authenticated())
                .formLogin();


        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService); // Make sure userService implements UserDetailsService
        authProvider.setPasswordEncoder(bCryptPasswordEncoder);

        List<AuthenticationProvider> providers = List.of(authProvider);

        return new ProviderManager(providers);
    }
}