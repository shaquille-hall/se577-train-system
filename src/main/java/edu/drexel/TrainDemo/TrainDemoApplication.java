package edu.drexel.TrainDemo;

import edu.drexel.TrainDemo.repositories.RouteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TrainDemoApplication {

    private static final Logger log = LoggerFactory.getLogger(TrainDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TrainDemoApplication.class, args);
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