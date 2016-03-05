package br.com.equipejr.dao;

import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.equipejr.entity.User;

@Named("userDAO")
@SessionScoped
public class UserDAO {

	private EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("equipePU");
	private EntityManager manager = factory.createEntityManager();

	public User getUser(String email) {
		Query query = manager
				.createQuery("select u from User as u where u.email = :email ");
		query.setParameter("email", email);

		return (User) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<String> getAllUserMails() {
		Query query = manager
				.createQuery("select u.email from User as u order by u.email");

		return query.getResultList();
	}
}
