package ebruyurtdas.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ebruyurtdas.entities.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{
	@Autowired
	SessionFactory sessionFactory;

	private static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

	@SuppressWarnings("unchecked")
	public List<Product> list() {
		return sessionFactory.getCurrentSession().createCriteria(Product.class).list();

	}

	public boolean delete(Product prd) {
		try {
			sessionFactory.getCurrentSession().delete(prd);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public boolean saveProduct(Product prd) {
		sessionFactory.getCurrentSession().save(prd);
		return true;
	}

	public Product getProduct(int id) {
		Session session = this.sessionFactory.getCurrentSession();

		// get user
		@SuppressWarnings("removal")
		Product user = (Product) session.get(Product.class, new Integer(id));
		return user;
	}

	public void removeProduct(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("removal")
		Product p = (Product) session.load(Product.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("Product deleted successfully, Product details=" + p);
	}

	public boolean updateProduct(Product prd) { 
		sessionFactory.getCurrentSession().update(prd); 
		return true;
	}
}
