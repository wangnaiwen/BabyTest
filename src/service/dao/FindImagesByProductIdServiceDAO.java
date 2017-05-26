package service.dao;

import java.util.List;

import domain.ProductImage;

public interface FindImagesByProductIdServiceDAO {
	List<ProductImage> findImagesByProductId(int productId);
}
