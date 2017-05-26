package dao;

import java.util.List;

import domain.ProductImage;

public interface ProductImageDAO {
	boolean insertProductImage(ProductImage image);
	List<ProductImage> findImagesByProductId(int productId);
}
