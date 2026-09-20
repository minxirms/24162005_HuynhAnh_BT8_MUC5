package vn.minxi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import vn.minxi.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findAllByOrderByPriceAsc();

	List<Product> findByCategoryId(Long categoryId);

	Page<Product> findByNameContainingIgnoreCase(String keyword, Pageable pageable);
}
