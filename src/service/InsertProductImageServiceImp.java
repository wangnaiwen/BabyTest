package service;

import dao.ProductImageDAO;
import domain.ProductImage;
import service.dao.BaseProductImageServiceDAO;
import service.dao.InsertProductImageServiceDAO;

public class InsertProductImageServiceImp extends BaseProductImageServiceDAO implements InsertProductImageServiceDAO{
	@Override
	public boolean insertProductImage(ProductImage image) {
		ProductImageDAO productImageDAO = getProductImageDAO();
		return productImageDAO.insertProductImage(image);
	}
}
