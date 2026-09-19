package vn.minxi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import vn.minxi.controller.GraphQLController.ProductInput;
import vn.minxi.entity.Category;
import vn.minxi.entity.Product;
import vn.minxi.repository.CategoryRepository;
import vn.minxi.repository.ProductRepository;
import vn.minxi.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Product> getProductsSortedByPrice() {
		return productRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
	}

	@Override
	public List<Product> getProductsByCategoryId(Long categoryId) {
		return productRepository.findByCategoryId(categoryId);
	}

	@Override
	public Page<Product> searchProducts(String keyword, int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		if (keyword != null && !keyword.trim().isEmpty()) {
			return productRepository.findByNameContainingIgnoreCase(keyword, pageable);
		}
		return productRepository.findAll(pageable);
	}

	@Override
	public Product createProduct(ProductInput input) {
		Product product = new Product();
		product.setName(input.getName());
		product.setPrice(input.getPrice());

		// Gán giá trị đường dẫn/dữ liệu ảnh từ input
		product.setImages(input.getImages());

		if (input.getCategoryId() != null) {
			Category category = categoryRepository.findById(input.getCategoryId()).orElse(null);
			product.setCategory(category);
		}

		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Long id, ProductInput input) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm với ID: " + id));

		product.setName(input.getName());
		product.setPrice(input.getPrice());

		product.setImages(input.getImages());

		if (input.getCategoryId() != null) {
			Category category = categoryRepository.findById(input.getCategoryId()).orElse(null);
			product.setCategory(category);
		}

		return productRepository.save(product);
	}

	@Override
	public Boolean deleteProduct(Long id) {
		if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
			return true;
		}
		return false;
	}
}