package com.niit.OnlineBackend.DAOIMPL;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.OnlineBackend.DAO.UserDAO;
import com.niit.OnlineBackend.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOIMPL implements UserDAO 
{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addUser(User user) 
	{
		try
		{
			sessionFactory.getCurrentSession().persist(user);	
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

}
