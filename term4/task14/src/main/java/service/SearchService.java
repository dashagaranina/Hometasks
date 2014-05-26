package service;

import model.Category;

public interface SearchService {
    Iterable<Category> getAllCategories();
}
