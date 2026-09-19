package vn.minxi.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "category_name", nullable = false)
	private String name;

	@Column(name = "images")
	private String images;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Product> products;
}