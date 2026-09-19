package vn.minxi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	// 1. Mở trang chủ
	@GetMapping("/")
	public String home() {
		return "home"; // Trả về templates/home.html
	}

	// 2. Mở trang Quản lý Category
	@GetMapping("/admin/categories")
	public String categories() {
		return "admin/categories"; // Trả về templates/admin/categories.html
	}

	// 3. Mở trang Quản lý Product
	@GetMapping("/admin/products")
	public String products() {
		return "admin/products"; // Trả về templates/admin/products.html
	}
}