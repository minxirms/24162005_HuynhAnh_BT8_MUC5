package vn.minxi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import lombok.Data;

import vn.minxi.entity.Category;
import vn.minxi.entity.Product;
import vn.minxi.service.CategoryService;
import vn.minxi.service.ProductService;

import java.util.List;

@Controller
public class GraphQLController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Data
	public static class ProductInput {
		private String name;
		private Double price;
		private String images;
		private Long categoryId;
	}

	// ==================== QUERIES ====================
	@QueryMapping
	public List<Product> getProductsSortedByPrice() {
		return productService.getProductsSortedByPrice();
	}

	@QueryMapping
	public List<Product> getProductsByCategory(@Argument Long categoryId) {
		return productService.getProductsByCategoryId(categoryId);
	}

	@QueryMapping
	public Page<Product> searchProducts(@Argument String keyword, @Argument int page, @Argument int size) {
		return productService.searchProducts(keyword, page, size);
	}

	@QueryMapping
	public Page<Category> searchCategories(@Argument String keyword, @Argument int page, @Argument int size) {
		return categoryService.searchCategories(keyword, page, size);
	}

	// ==================== MUTATIONS CATEGORY ====================
	@MutationMapping
	public Category createCategory(@Argument String name, @Argument String images) {
		return categoryService.createCategory(name, images);
	}

	@MutationMapping
	public Category updateCategory(@Argument Long id, @Argument String name, @Argument String images) {
		return categoryService.updateCategory(id, name, images);
	}

	@MutationMapping
	public Boolean deleteCategory(@Argument Long id) {
		return categoryService.deleteCategory(id);
	}

	// ==================== MUTATIONS PRODUCT ====================
	@MutationMapping
	public Product createProduct(@Argument ProductInput input) {
		return productService.createProduct(input);
	}

	@MutationMapping
	public Product updateProduct(@Argument Long id, @Argument ProductInput input) {
		return productService.updateProduct(id, input);
	}

	@MutationMapping
	public Boolean deleteProduct(@Argument Long id) {
		return productService.deleteProduct(id);
	}
}