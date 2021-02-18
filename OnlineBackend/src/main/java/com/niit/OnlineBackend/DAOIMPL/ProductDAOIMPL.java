package com.niit.OnlineBackend.DAOIMPL;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.OnlineBackend.DAO.ProductDAO;
import com.niit.OnlineBackend.model.Category;
import com.niit.OnlineBackend.model.Product;

@Transactional
@Repository("productDAO")
public class ProductDAOIMPL implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addProduct(Product product) 
	{
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Product> getActiveProduct() {
		String selectActiveProduct = "FROM Product WHERE active = :active";

		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProduct);

		query.setParameter("active", true);

		return query.getResultList();

	}

	@Override
	public List<Product> getCategoryProduct(int categoryId) {
		String selectActiveProduct = "FROM Product WHERE active = :active and categoryId = :categoryId";

		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProduct);

		query.setParameter("active", true);
		query.setParameter("categoryId", categoryId);

		return query.getResultList();
	}

	@Override
	public Product getSingleProduct(int id) 
	{
		return sessionFactory.getCurrentSession().get(Product.class, id);
	}

}
