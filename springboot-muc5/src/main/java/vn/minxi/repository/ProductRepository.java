package vn.minxi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import vn.minxi.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
	// 1. Lấy tất cả sắp xếp theo giá từ thấp đến cao
	List<Product> findAllByOrderByPriceAsc();

	// 2. Lấy tất cả Product theo Category ID
	List<Product> findByCategoryId(Long categoryId);

	// 3. Tìm kiếm phân trang
	Page<Product> findByNameContainingIgnoreCase(String keyword, Pageable pageable);
}
