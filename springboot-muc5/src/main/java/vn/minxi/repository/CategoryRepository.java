package vn.minxi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import vn.minxi.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	Page<Category> findByNameContainingIgnoreCase(String keyword, Pageable pageable);
}