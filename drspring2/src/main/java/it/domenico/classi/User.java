package it.domenico.classi;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;


@Entity
@Table(name = "User")
public class User {
	
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("domenicoMysql");
	
	@Id
	@Column(name = "username", unique = true)
	private String username;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "messaggio", nullable = false)
	private String messaggio;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessaggio() {
		return messaggio;
	}
	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
	
	public void create(User u) {
		EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction transaction = null;

		try {

			transaction = manager.getTransaction();

			transaction.begin();
			
			manager.persist(u);
			transaction.commit();
			
		} catch (Exception ex) {

			if (transaction != null) {
				transaction.rollback();
			}

			ex.printStackTrace();
		} finally {

			manager.close();
		}
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", messaggio=" + messaggio + "]";
	} 
	
	
}
