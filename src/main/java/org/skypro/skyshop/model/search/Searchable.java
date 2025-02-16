package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {

    String searchTerm();

    String getTypeContent();

    String getName();

    UUID getId();

    default String getStringRepresentation() {
        return "имя " + searchTerm() + "; тип " + getTypeContent();
    }


}
