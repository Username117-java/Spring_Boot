package org.skypro.skyshop.model.search;

public class SearchResult {
    private final String id;
    private final String name;
    private final String contentType;


    public SearchResult(String id, String name, String contentType) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
    }

    public static SearchResult fromSearchable(Searchable searchable) {
        return new SearchResult(searchable.getId().toString(), searchable.getName(), searchable.getTypeContent());
    }
}
