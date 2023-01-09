package ua.in.ip.notespgs.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import ua.in.ip.notespgs.services.UserService;

@Configuration
@EnableWebSecurity
//@RequiredArgsConstructor
//@EnableGlobalMethodSecurity(prePostEnabled = true) для захисту окремого методу
public class SecurityConfig {

    @Autowired
    private UserService userService;

    @Bean
    @Order(1)
    public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http)
            throws Exception {
        http
//                .csrf().disable() можливо відключення csrf
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/", "/home", "/user/registration").permitAll()
                                .requestMatchers("/authenticated/**").authenticated()
                                .requestMatchers("/only_for_admins/**, /admin/**").hasRole("ADMIN")
                                .requestMatchers("/read_profile/**").hasAuthority("READ_PROFILE")
//                        .antMatchers("/authenticated**").auth
                                .anyRequest().authenticated()
//                                .requestMatchers("/admin/**").hasAnyRole("ADMIN", "SUPERADMIN")
//                                .requestMatchers("/profile/**").authenticated()
                )
                .formLogin()
//                .loginProcessingUrl("/hellologin") якщо є бажання відправити запит на свий адрес
                .and()
                .logout().logoutSuccessUrl("/");
//                .loginPage("/auth/login").permitAll()
//                .defaultSuccessUrl("/auth/success");

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setPasswordEncoder(userService.getPasswordEncoder());
        authenticationProvider.setUserDetailsService(userService);
        return authenticationProvider;
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
//        userService.setPasswordEncoder(passwordEncoder);
//        return passwordEncoder;
//    }
}
