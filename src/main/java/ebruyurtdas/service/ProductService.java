package ebruyurtdas.service;
import java.util.List;

import ebruyurtdas.entities.Product;

public interface ProductService {
	
		public List<Product> list();

		public boolean delete(Product prd);

		public boolean saveProduct(Product prd);

		public boolean updateProduct(Product prd);

		public Product getProduct(int id);

		public void removeProduct(int id);
		
}
