package vn.minxi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/admin/categories")
	public String categories() {
		return "admin/categories";
	}

	@GetMapping("/admin/products")
	public String products() {
		return "admin/products";
	}
}