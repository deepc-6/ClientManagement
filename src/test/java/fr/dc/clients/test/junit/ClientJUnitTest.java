package fr.dc.clients.test.junit;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import junit.framework.TestCase;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.dc.clients.datamodel.Client;

/**
 * This is the test class which uses junit for testing
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class ClientJUnitTest extends TestCase {

	/**
	 * This is an instance of the session factory that is autowired in the
	 * applicationContext xml file
	 */
	@Autowired
	SessionFactory factory;

	/**
	 * This is an instance of the data source that is autowired in the
	 * applicationContext xml file
	 */
	@Autowired
	DataSource ds;

	/**
	 * This is the default constructor for the class JUnitTest with no
	 * parameters
	 */
	public ClientJUnitTest() {

	}

	/**
	 * This is the test method that is used to connect to the database through a
	 * datasource object which is autowired in the applicationContext xml file
	 * 
	 * @throws SQLException
	 *             Signals that a database error has been reached unexpectedly
	 */
	@Test
	public void selfCheck() throws SQLException {
		ds.getConnection();
	}

	/**
	 * This is the test method to get all clients from the database. This method
	 * overrides the getAll method in the data access object interface.
	 */
	@Test
	public void getAll() {
		Session session = factory.openSession();
		@SuppressWarnings("unchecked")
		List<Client> readAllClientsList = session.createQuery("from Client").list();
		session.close();
		System.out.println(readAllClientsList);
	}

	/**
	 * This is the test method to get a client with matching id from the
	 * database. This method overrides the getById method in the data access
	 * object interface.
	 */
	@Test
	public void getById() {
		Session session = factory.openSession();
		@SuppressWarnings("unchecked")
		List<Client> readOneClientList = session.createQuery("from Client where id = :id").setParameter("id", 1).list();
		if (readOneClientList.size() == 0) {
			System.out.println("No clients found");
		} else {
			Client readClient = readOneClientList.get(0);
			System.out.println(readClient);
		}
		session.close();
	}

	/**
	 * This is the test method to save a client to the database. This method
	 * overrides the create method in the data access object interface.
	 */
	@Test
	public void create() {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Client createClient = new Client(0, "BusinessName1", "Interlocuter1", "Address1", "PostalCode1", "City1",
				"1234567890", "Email1@Email1.com", "Comment1");
		session.saveOrUpdate(createClient);
		tx.commit();
		session.close();
	}

	/**
	 * This is the test method that searches for a client from the database
	 * whose id matches the user input and updates it in the database. This
	 * method overrides the update method in the data access object interface.
	 */
	@Test
	public void update() {
		Session session = factory.openSession();
		Client updateClient = new Client(1, "BusinessName2", "Interlocuter2", "Address2", "PostalCode2", "City2",
				"0987654331", "Email2@Email2.com", "Comment2");
		Query query = session
				.createQuery("update Client set businessName = :newBusinessName, interlocuter = :newInterlocuter,"
						+ " address= :newAddress, zipcode = :newZipcode, city = :newCity,"
						+ " phone = :newPhone, email = :newEmail, comment = :newComment where id = :id")
				.setParameter("newBusinessName", updateClient.getBusinessName())
				.setParameter("newInterlocuter", updateClient.getInterlocuter())
				.setParameter("newAddress", updateClient.getAddress())
				.setParameter("newZipcode", updateClient.getZipCode()).setParameter("newCity", updateClient.getCity())
				.setParameter("newPhone", updateClient.getPhone()).setParameter("newEmail", updateClient.getEmail())
				.setParameter("newComment", updateClient.getComment()).setParameter("id", updateClient.getId());
		query.executeUpdate();
		session.close();
	}

	/**
	 * This is the test method that deletes a client with the matching id from
	 * the database. This method overrides the delete method in the data access
	 * object interface.
	 */
	@Test
	public void delete() {
		Session session = factory.openSession();
		Query query = session.createQuery("delete Client where id = :id").setParameter("id", 1);
		query.executeUpdate();
		session.close();
	}

}
