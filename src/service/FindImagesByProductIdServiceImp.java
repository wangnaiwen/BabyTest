package service;

import java.util.List;

import dao.ProductImageDAO;
import domain.ProductImage;
import service.dao.BaseProductImageServiceDAO;
import service.dao.FindImagesByProductIdServiceDAO;

public class FindImagesByProductIdServiceImp extends BaseProductImageServiceDAO implements FindImagesByProductIdServiceDAO{

	@Override
	public List<ProductImage> findImagesByProductId(int productId) {
		ProductImageDAO productImageDAO = getProductImageDAO();
		return productImageDAO.findImagesByProductId(productId);
	}

}
