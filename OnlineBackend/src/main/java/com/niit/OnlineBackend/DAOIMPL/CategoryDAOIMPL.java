package com.niit.OnlineBackend.DAOIMPL;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.OnlineBackend.DAO.CategoryDAO;
import com.niit.OnlineBackend.model.Category;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOIMPL implements CategoryDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addCategory(Category category) 
	{
		try
		{
			sessionFactory.getCurrentSession().persist(category);	
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<Category> getActiveCategories() 
	{
		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
						
		return query.getResultList();
		
	}

	@Override
	public Category getCategory(int id) 
	{
		return sessionFactory.getCurrentSession().get(Category.class, id);
	}
}
