package vn.minxi.service;

import org.springframework.data.domain.Page;
import vn.minxi.entity.Category;

import java.util.List;

public interface CategoryService {
	List<Category> getAllCategories();

	Category getCategoryById(Long id);

	Category createCategory(String name, String images);

	Category updateCategory(Long id, String name, String images);

	Boolean deleteCategory(Long id);

	Page<Category> searchCategories(String keyword, int page, int size);
}