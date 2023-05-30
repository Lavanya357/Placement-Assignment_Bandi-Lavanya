package ineuron.SpringBoot03;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter 
{
	@Override
    protected void configure(HttpSecurity http) throws Exception 
	{
        http
            .authorizeRequests()
                .antMatchers("/register", "/login").permitAll() // Allow access to registration and login pages
                .anyRequest().authenticated() // Require authentication for other requests
                .and()
            .formLogin()
                .loginPage("/login") // Use the custom login page
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
        // Configure your authentication provider, e.g., in-memory, JDBC, or custom
        // For simplicity, an in-memory authentication example is shown here
        auth
            .inMemoryAuthentication()
                .withUser("user")
                    .password("{noop}password") 
                    .roles("USER");
    }
}
