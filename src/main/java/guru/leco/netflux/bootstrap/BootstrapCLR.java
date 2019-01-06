package guru.leco.netflux.bootstrap;

import guru.leco.netflux.domain.Movie;
import guru.leco.netflux.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
public class BootstrapCLR implements CommandLineRunner {

    private final MovieRepository movieRepository;

    @Autowired
    public BootstrapCLR(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        movieRepository.deleteAll().thenMany(
                Flux.just("Silence of the Lambdas",
                        "Back to the Future",
                        "Lord of the flux",
                        "Enter the Mono<Void>",
                        "The Fluxxinator")
                        .map(title -> new Movie(UUID.randomUUID().toString(), title)))
                .flatMap(movieRepository::save)
                .subscribe(null, null, () -> {
                    movieRepository.findAll().subscribe(System.out::println);
                });
    }
}
