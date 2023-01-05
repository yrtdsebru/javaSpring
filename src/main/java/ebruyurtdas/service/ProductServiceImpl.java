package ebruyurtdas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ebruyurtdas.dao.ProductDao;
import ebruyurtdas.entities.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;

	public List<Product> list() {
		return productDao.list();
	}

	public boolean delete(Product prd) {
		return productDao.delete(prd);
	}

	public boolean saveProduct(Product prd) {
		return productDao.saveProduct(prd);
	}

	public Product getProduct(int id) {
		return productDao.getProduct(id);
	}

	public void removeProduct(int id) {
		productDao.removeProduct(id);

	}

	public boolean updateProduct(Product prd) {
		return productDao.updateProduct(prd);
	}

}
