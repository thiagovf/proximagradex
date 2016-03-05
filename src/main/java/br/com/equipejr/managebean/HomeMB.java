package br.com.equipejr.managebean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import br.com.equipejr.dao.UserDAO;

@ManagedBean
@Named("homeMB")
@RequestScoped
public class HomeMB {

	private UserDAO userDAO = new UserDAO();
	private List<String> emails;

	@PostConstruct
	public void test() {
		emails = userDAO.getAllUserMails();
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
	
}
