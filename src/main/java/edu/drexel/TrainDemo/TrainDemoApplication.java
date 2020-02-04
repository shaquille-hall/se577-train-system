package edu.drexel.TrainDemo;

import edu.drexel.TrainDemo.repositories.RouteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@SpringBootApplication
@RestController
public class TrainDemoApplication extends WebSecurityConfigurerAdapter {

    private static final Logger log = LoggerFactory.getLogger(TrainDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TrainDemoApplication.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(a -> a
                        .antMatchers("/", "/error", "/webjars/**", "/css/**", "/js/**").permitAll()
                        .anyRequest().authenticated()
                )
                .exceptionHandling(e -> e
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                )
                .logout(l -> l
                        .logoutSuccessUrl("/").permitAll()
                )
                .csrf(c -> c
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                )
                .oauth2Login();
    }

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }

    @Bean
    public CommandLineRunner demo(RouteRepository repo) {
        return (args) -> {
            log.info("Attempting to find routes with repo.findAll()...");
            for (var route : repo.findAll()) {
                log.info(route.toString());
            }

            var id = 96L;
            log.info("Attempting to find route with id " + id + "...");
            var entity = repo.findById(id);
            if (entity.isPresent()) {
                log.info("Found route with id " + id);
                log.info(entity.get().toString());
            } else {
                log.info("Could not find route with id " + id);
            }

            var agencyId = 51;
            log.info("Attempting to get all routes by the agency id " + agencyId + "...");
            var routes = repo.findByAgency_Id(agencyId);
            for (var route : routes) {
                log.info(route.toString());
            }
        };
    }
}