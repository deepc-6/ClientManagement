package fr.dc.clients.services.dao;

import java.util.List;

import fr.dc.clients.datamodel.Client;

/**
 * This is an interface of the Data Access Object which links the main class to
 * the Data Access Object classes used to represent the Identity
 * 
 */
public interface ClientDAOInterface {

	/**
	 * This method is used to get all clients from the database
	 * 
	 * @return <b>clientList</b> The list containing the clients read from the database
	 */
	public List<Client> getAll();

	/**
	 * This method is used to get a client with matching id from the database
	 * 
	 * @param id
	 *            The id of the client to be read from the database
	 * 
	 * @return <b>client</b> The client with the matching id from the database
	 */
	public Client getById(int id);

	/**
	 * This method is used to save a client to the database
	 * 
	 * @param client
	 *            The client to be saved to the database
	 */
	public void create(Client client);

	/**
	 * This method searches for a client from the database whose id matches the
	 * user input and updates it in the database
	 * 
	 * @param client
	 *            The client to be updated in the database
	 */
	public void update(Client client);

	/**
	 * This method deletes a client with the matching id from the database
	 * 
	 * @param id
	 *            The id of the client to be deleted from the database
	 */
	public void delete(int id);

}