package guru.leco.netflux.repositories;

import guru.leco.netflux.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
}
