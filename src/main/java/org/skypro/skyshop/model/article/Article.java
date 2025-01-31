package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public class Article implements Searchable {
    private String nameArticle;
    private String textArticle;
    private final UUID id;

    public Article(String nameArticle, String textArticle, UUID id) {
        this.nameArticle = nameArticle;
        this.textArticle = textArticle;
        this.id = id;
    }

    @Override
    public UUID getId() {
        return id;
    }


    @Override
    public String toString() {
        return nameArticle + " " + textArticle;
    }

    @JsonIgnore
    @Override
    public String searchTerm() {
        return toString();
    }

    @JsonIgnore
    @Override
    public String getTypeContent() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return nameArticle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(nameArticle, article.nameArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameArticle);
    }
}
