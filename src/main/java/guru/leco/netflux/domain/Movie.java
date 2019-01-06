package guru.leco.netflux.domain;

import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Movie {

    public Movie(String id, @NonNull String title) {
        this.id = id;
        this.title = title;
    }

    private String id;

    @NonNull
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
