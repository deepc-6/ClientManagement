package fr.dc.clients.services.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import fr.dc.clients.datamodel.Client;
import fr.dc.clients.services.dao.ClientDAOInterface;

/**
 * This is the implementation class for the data access object which implements
 * all the methods in the data access object interface
 * 
 */
public class ClientDAOImpl implements ClientDAOInterface {

	/**
	 * This is a session factory that has been autowired in the
	 * applicationContext xml file
	 */
	@Autowired
	private SessionFactory factory;

	/**
	 * This method is used to get all clients from the database. This method
	 * overrides the getAll method in the data access object interface.
	 * 
	 * @return <b>clientList</b> The list containing the clients read from the database
	 */
	@Override
	public List<Client> getAll() {
		Session session = factory.openSession();
		@SuppressWarnings("unchecked")
		List<Client> clientList = session.createQuery("from Client").list();
		session.close();
		return clientList;
	}

	/**
	 * This method is used to get a client with matching id from the database.
	 * This method overrides the getById method in the data access object
	 * interface.
	 * 
	 * @param id
	 *            The id of the client to be read from the database
	 * 
	 * @return <b>client</b> The client with the matching id from the database
	 */
	@Override
	public Client getById(int id) {
		Session session = factory.openSession();
		@SuppressWarnings("unchecked")
		List<Client> clientList = session.createQuery("from Client where id = :id").setParameter("id", id).list();
		Client client = clientList.get(0);
		session.close();
		return client;
	}

	/**
	 * This method is used to save a client to the database. This method
	 * overrides the getAll method in the data access object interface.
	 * 
	 * @param client
	 *            The client to be saved to the database
	 */
	@Override
	public void create(Client client) {
		if (client == null)
			return;
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(client);
		tx.commit();
		session.close();
	}

	/**
	 * This method searches for a client from the database whose id matches the
	 * user input and updates it in the database. This method overrides the
	 * getAll method in the data access object interface.
	 * 
	 * @param client
	 *            The client to be updated in the database
	 */
	@Override
	public void update(Client client) {
		Session session = factory.openSession();
		Query query = session
				.createQuery("update Client set businessName = :newBusinessName, interlocuter = :newInterlocuter,"
						+ " address= :newAddress, zipcode = :newZipcode, city = :newCity,"
						+ " phone = :newPhone, email = :newEmail, comment = :newComment where id = :id")
				.setParameter("newBusinessName", client.getBusinessName())
				.setParameter("newInterlocuter", client.getInterlocuter())
				.setParameter("newAddress", client.getAddress()).setParameter("newZipcode", client.getZipCode())
				.setParameter("newCity", client.getCity()).setParameter("newPhone", client.getPhone())
				.setParameter("newEmail", client.getEmail()).setParameter("newComment", client.getComment())
				.setParameter("id", client.getId());
		query.executeUpdate();
		session.close();
	}

	/**
	 * This method deletes a client with the matching id from the database. This
	 * method overrides the getAll method in the data access object interface.
	 * 
	 * @param id
	 *            The id of the client to be deleted from the database
	 */
	@Override
	public void delete(int id) {
		Session session = factory.openSession();
		Query query = session.createQuery("delete Client where id = :id").setParameter("id", id);
		query.executeUpdate();
		session.close();
	}

}
