package tech.donau.quarkify.product;

import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.ResourceProperties;

/**
 * Panache-generated REST resource controller for the Product entity.
 */
@ResourceProperties(path = "/product")
public interface ProductResource extends PanacheEntityResource<Product, Long> {
}