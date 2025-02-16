package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public List<Searchable> search(String pattern) {
        List<Searchable> searchResult = storageService.getAllSearchable().stream()
                .filter(x -> x.searchTerm().toLowerCase().contains(pattern.toLowerCase()))
                .collect(Collectors.toList());

        if (searchResult.isEmpty()) {
            System.out.println("Результатов поиска по запросу '" + pattern + "' не найдено.");
        }
        return searchResult;
    }
}


