package fr.dc.clients.datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is the datamodel class for the entity Client
 * 
 */

@Entity
@Table(name = "Client")
public class Client {

	/**
	 * This is the default constructor for the class Client with no parameters
	 */
	public Client() {

	}

	/**
	 * This is the id for each client in the database. It is auto generated when
	 * a new client is created.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/**
	 * This is the business name of the client in the database.
	 */
	private String businessName;

	/**
	 * This is the interlocuter name of the client in the database.
	 */
	private String interlocuter;

	/**
	 * This is the address of the client in the database.
	 */
	private String address;

	/**
	 * This is the postal code of the client in the database.
	 */
	private String zipcode;

	/**
	 * This is the city name of the client in the database.
	 */
	private String city;

	/**
	 * This is the phone number of the client in the database.
	 */
	private String phone;

	/**
	 * This is the email of the client in the database.
	 */
	private String email;

	/**
	 * This is the comment about the client in the database.
	 */
	private String comment;

	/**
	 * This is a constructor for the class Client with parameters businessName,
	 * interlocuter, address, zipcode, city, phone, email, comment
	 * 
	 * @param id
	 *            The id of the identity. Data type: <b>int</b>
	 * @param businessName
	 *            The business name of the identity. Data type: <b>String</b>
	 * @param interlocuter
	 *            The interlocuter name of the identity. Data type:
	 *            <b>String</b>
	 * @param address
	 *            The address of the identity. Data type: <b>String</b>
	 * @param zipcode
	 *            The postal code of the identity. Data type: <b>String</b>
	 * @param city
	 *            The city name of the identity. Data type: <b>String</b>
	 * @param phone
	 *            The phone number of the identity. Data type: <b>String</b>
	 * @param email
	 *            The email of the identity. Data type: <b>String</b>
	 * @param comment
	 *            The comment about the identity. Data type: <b>String</b>
	 */
	public Client(int id, String businessName, String interlocuter, String address, String zipcode, String city,
			String phone, String email, String comment) {
		this.id = id;
		this.businessName = businessName;
		this.interlocuter = interlocuter;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.phone = phone;
		this.email = email;
		this.comment = comment;
	}

	/**
	 * This method returns the output to the console in the following format:
	 * <p>
	 * [ID [Business Name, Interlocuter, Address, Zipcode, City, Phone, E-mail
	 * address, Comment]
	 * <p>
	 * This method overrides the {@link java.lang.Object#toString()} method.
	 * <p>
	 * 
	 * @return <b>id</b> The id of the client. Data type: <b>int</b>
	 *         <p>
	 *         <b>businessName</b> The business name of the client. Data type:
	 *         <b>String</b>
	 *         <p>
	 *         <b>interlocuter</b> The interlocuter name of the client. Data
	 *         type: <b>String</b>
	 *         <p>
	 *         <b>address</b> The address of the client. Data type:
	 *         <b>String</b>
	 *         <p>
	 *         <b>zipcode</b> The postal code of the client. Data type:
	 *         <b>String</b>
	 *         <p>
	 *         <b>city</b> The city name of the client. Data type: <b>String</b>
	 *         <p>
	 *         <b>phone</b> The phone number of the client. Data type:
	 *         <b>String</b>
	 *         <p>
	 *         <b>email</b> The e-mail of the client. Data type: <b>String</b>
	 *         <p>
	 *         <b>comment</b> The comment about the client. Data type:
	 *         <b>String</b>
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return "\n" + "ID=" + id + " Business Name=" + businessName + ", Interlocuter=" + interlocuter + ", Address="
				+ address + ", Zipcode=" + zipcode + ", City=" + city + ", Telephone=" + phone + ", E-mail address="
				+ email + ", Comment=" + comment;
	}

	/**
	 * This method returns the business name of the client
	 * 
	 * @return <b>businessName</b> The business name of the identity
	 */
	public final String getBusinessName() {
		return businessName;
	}

	/**
	 * This method sets the business name of the client
	 * 
	 * @param businessName
	 *            The business name of the client. Data type: <b>String</b>
	 */
	public final void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	/**
	 * This method returns the interlocuter name of the client
	 * 
	 * @return <b>interlocuter</b> The interlocuter name of the client
	 */
	public final String getInterlocuter() {
		return interlocuter;
	}

	/**
	 * This method sets the interlocuter name of the client
	 * 
	 * @param interlocuter
	 *            The interlocuter name of the client. Data type: <b>String</b>
	 */
	public final void setInterlocuter(String interlocuter) {
		this.interlocuter = interlocuter;
	}

	/**
	 * This method returns the address of the client
	 * 
	 * @return <b>address</b> The address of the client
	 */
	public final String getAddress() {
		return address;
	}

	/**
	 * This method sets the address of the client
	 * 
	 * @param address
	 *            The address of the client. Data type: <b>String</b>
	 */
	public final void setAddress(String address) {
		this.address = address;
	}

	/**
	 * This method returns the postal code of the client
	 * 
	 * @return <b>zipcode</b> The postal code of the client
	 */
	public final String getZipCode() {
		return zipcode;
	}

	/**
	 * This method sets the postal code of the client
	 * 
	 * @param zipcode
	 *            The postal code of the client. Data type: <b>String</b>
	 */
	public final void setZipCode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * This method returns the city name of the client
	 * 
	 * @return <b>city</b> The city name of the client
	 */
	public final String getCity() {
		return city;
	}

	/**
	 * This method sets the city name of the client
	 * 
	 * @param city
	 *            The city name of the client. Data type: <b>String</b>
	 */
	public final void setCity(String city) {
		this.city = city;
	}

	/**
	 * This method returns the phone number of the client
	 * 
	 * @return <b>phone</b> The phone number of the client
	 */
	public final String getPhone() {
		return phone;
	}

	/**
	 * This method sets the phone number of the client
	 * 
	 * @param phone
	 *            The phone number of the client. Data type: <b>String</b>
	 */
	public final void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * This method returns the email address of the client
	 * 
	 * @return <b>email</b> The email address of the client
	 */
	public final String getEmail() {
		return email;
	}

	/**
	 * This method sets the email address of the client
	 * 
	 * @param email
	 *            The email address of the client. Data type: <b>String</b>
	 */
	public final void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This method returns the comment about the client
	 * 
	 * @return <b>comment</b> The comment about the client
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * This method sets the comment about the client
	 * 
	 * @param comment
	 *            The comment about the client. Data type: <b>String</b>
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * This method returns the id of the client
	 * 
	 * @return <b>id</b> The id of the client
	 */
	public int getId() {
		return id;
	}

	/**
	 * This method sets the id of the client
	 * 
	 * @param id
	 *            The id of the client. Data type: <b>String</b>
	 */
	public void setId(int id) {
		this.id = id;
	}

}
