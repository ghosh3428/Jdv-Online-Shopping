package com.niit.OnlineBackend.DAOIMPL;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.OnlineBackend.DAO.UserDAO;
import com.niit.OnlineBackend.model.Address;
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

	@Override
	public boolean addAddress(Address address) 
	{
		
		try
		{
			sessionFactory.getCurrentSession().persist(address);	
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User getByEmail(String email)
	{
		String selectQuery = "FROM User WHERE email = :email";
		try {
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectQuery,User.class)
						.setParameter("email",email)
							.getSingleResult();
		}
		
		catch(Exception ex) 
		{
			return null;
		}
	
	}

}
