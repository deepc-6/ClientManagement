package fr.dc.clients.services.servlets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import fr.dc.clients.datamodel.Client;
import fr.dc.clients.services.dao.ClientDAOInterface;

/**
 * This is the class for the service which handles requests and responses from
 * the angular controller with the spring web MVC framework and REST API
 *
 */
@RestController
public class ClientService {

	/**
	 * This is an instance of the data access object interface that is autowired
	 * in the applicationContext xml file
	 */
	@Autowired
	ClientDAOInterface daoInterface;

	/**
	 * This method is the GET request to retrieve all clients from the database
	 * 
	 * @return <b>readList</b> The list containing the clients read from the database
	 * 		   <p>
	 * 		   <b>HttpStatus</b> The http status of the request
	 * 
	 */
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> listAllUsers() {
		List<Client> readList = daoInterface.getAll();
		if (readList.isEmpty()) {
			return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Client>>(readList, HttpStatus.OK);
	}

	/**
	 * This method is the GET request to retrieve a client with matching id from
	 * the database
	 * 
	 * @param id
	 *            The id of the client to be read from the database
	 * 
	 * @return <b>client</b> The client with the matching id from the database
	 * 		   <p>
	 * 		   <b>HttpStatus</b> The http status of the request
	 * 
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> getUser(@PathVariable("id") int id) {
		Client client = daoInterface.getById(id);
		if (client == null) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

	/**
	 * This method is the POST request to insert a new client to the database
	 * 
	 * @param id
	 *            The id of the client to be saved to the database
	 * 
	 * @param client
	 *            The client to be saved to the database
	 * 
	 * @param ucBuilder
	 *            The UriComponentsBuilder instance to encode the uri template
	 *            variables and inject it into the Spring Controller method
	 * 
	 * @return <b>idString</b> The string containing the id of the client saved in the database
	 * 		   <p>
	 * 		   <b>headers</b> The http headers for the request
	 * 		   <p>
	 * 		   <b>HttpStatus</b> The http status of the request
	 * 
	 */
	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(String id, @RequestBody Client client, UriComponentsBuilder ucBuilder) {
		daoInterface.create(client);
		HttpHeaders headers = new HttpHeaders();
		int clientId = client.getId();
		String idString = Integer.toString(clientId);
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(client.getId()).toUri());
		return new ResponseEntity<String>(idString, headers, HttpStatus.CREATED);
	}

	/**
	 * This method is the PUT request to update a client with matching id in the
	 * database
	 * 
	 * @param id
	 *            The id of the client to be updated in the database
	 * 
	 * @param client
	 *            The client to be updated in the database
	 * 
	 * @return <b>client</b> The client updated in the database
	 * 		   <p>
	 * 		   <b>HttpStatus</b> The http status of the request
	 * 
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Client> updateUser(@PathVariable("id") int id, @RequestBody Client client) {
		daoInterface.update(client);
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}

	/**
	 * This method is the DELETE request to delete a client with matching id
	 * from the database
	 * 
	 * @param id
	 *            The id of the client to be deleted from the database
	 * 
	 * @return <b>HttpStatus</b> The http status of the request
	 * 
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Client> deleteUser(@PathVariable("id") int id) {
		daoInterface.delete(id);
		return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
	}

}
