package ebruyurtdas.dao;

import java.util.List;

import ebruyurtdas.entities.Product;

public interface ProductDao {
	
	public List<Product> list();

	public boolean delete(Product prd);

	public Product getProduct(int id);

	public void removeProduct(int id);

	public boolean saveProduct(Product prd);

	public boolean updateProduct(Product prd);

}
