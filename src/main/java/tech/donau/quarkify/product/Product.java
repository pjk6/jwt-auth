package tech.donau.quarkify.product;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Prodyct Entity
 *
 * @author pjk
 */
@Entity
@Table(name = "product")
public class Product extends PanacheEntityBase {
	@Id
	public long id;
	public String name;
	public String category;
	public String description;
	@Column(precision = 10, scale = 2)
	public BigDecimal price;
	public Integer quantity;
	public LocalDateTime created_at;
}
