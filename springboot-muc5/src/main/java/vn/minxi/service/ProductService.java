package vn.minxi.service;

import org.springframework.data.domain.Page;

import vn.minxi.controller.GraphQLController.ProductInput;
import vn.minxi.entity.Product;

import java.util.List;

public interface ProductService {
	List<Product> getProductsSortedByPrice();

	List<Product> getProductsByCategoryId(Long categoryId);

	Page<Product> searchProducts(String keyword, int page, int size);

	Product createProduct(ProductInput input);

	Product updateProduct(Long id, ProductInput input);

	Boolean deleteProduct(Long id);
}