package guru.leco.netflux.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Movie {

    public Movie() {
    }

    public Movie(String id, @NonNull String title) {
        this.id = id;
        this.title = title;
    }

    @Id
    private String id;

    @NonNull
    private String title;

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
