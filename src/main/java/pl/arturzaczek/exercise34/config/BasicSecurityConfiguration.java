package pl.arturzaczek.exercise34.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class BasicSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/post/add").hasAnyRole("USER", "ADMIN")
                .antMatchers("/post/*/comment/add").hasAnyRole("USER", "ADMIN")
                .antMatchers("/post/comment/add").hasAnyRole("USER", "ADMIN")
                .anyRequest().permitAll()
            .and()
                //h2 database requires for proper operation
                .csrf().disable()
                .headers().frameOptions().disable()
            .and()
                .formLogin()
                .loginPage("/user/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .failureUrl("/user/login?status=error")
                .loginProcessingUrl("/login-post-by-spring")
                .defaultSuccessUrl("/");
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT u.email, u.password_hash, 1 FROM user u WHERE u.email = ? ")
                .authoritiesByUsernameQuery("SELECT u.email, r.role_name " +
                        "FROM USER u " +
                        "JOIN user_role ur ON u.id = ur.user_id " +
                        "JOIN role r ON ur.ROLE_SET_ID = r.id " +
                        "WHERE u.email = ?")
                .passwordEncoder(passwordEncoder)

        ;
    }
}
