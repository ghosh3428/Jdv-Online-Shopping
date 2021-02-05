package com.niit.OnlineBackend.DAOIMPL;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.OnlineBackend.DAO.ProductDAO;
import com.niit.OnlineBackend.model.Product;

@Transactional
@Repository("productDAO")
public class ProductDAOIMPL implements ProductDAO 
{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addProduct(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().persist(product);	
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

}
