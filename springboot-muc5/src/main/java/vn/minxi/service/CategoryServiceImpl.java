package vn.minxi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import vn.minxi.entity.Category;
import vn.minxi.repository.CategoryRepository;
import vn.minxi.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(Long id) {
		return categoryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Không tìm thấy Category với ID: " + id));
	}

	@Override
	public Category createCategory(String name, String images) {
		Category category = new Category();
		category.setName(name);
		category.setImages(images); 
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Long id, String name, String images) {
		Category category = getCategoryById(id);
		category.setName(name);
		category.setImages(images); 
		return categoryRepository.save(category);
	}

	@Override
	public Boolean deleteCategory(Long id) {
		categoryRepository.deleteById(id);
		return true;
	}

	@Override
	public Page<Category> searchCategories(String keyword, int page, int size) {
		keyword = (keyword == null) ? "" : keyword;
		return categoryRepository.findByNameContainingIgnoreCase(keyword, PageRequest.of(page, size));
	}
}