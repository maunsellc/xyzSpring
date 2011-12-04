package ie.cit.cloud.appdev.model;


/**
 * The Class Member
 *
 * @author Caroline Maunsell
 */
public class Member {
	
    /** The name. */
    private String name;
	
	/** The email. */
	private String email;
	
	/** The address. */
	private String address;
	
	/** The homepage. */
	private String homepage;
	
	/** The password. */
	private String password;

	/**
	 * Instantiates a new member.
	 */
	public Member() {
	   // empty constructor to enable instantiation via reflection API
	   this(null,"","","","");
	}

	/**
	 * Instantiates a new member.
	 *
	 * @param id the id
	 * @param name the name
	 * @param email the email
	 * @param address the address
	 * @param homepage the homepage
	 * @param password the password
	 */
	public Member( String name, 
       		       String email, 
    		       String address,
    		       String homepage,
    		       String password) {
		  this.name = name;
		  this.email = email;
		  this.address = address;
		  this.homepage = homepage;
		  this.password = password;
	}
    
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
	    return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
    	this.name = name;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
    	return email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
    	this.email = email;
    }

    /**
     * Gets the address.
     *
     * @return the address
     */
    public String getAddress() {
    	return address;
    }

    /**
     * Sets the address.
     *
     * @param address the new address
     */
    public void setAddress(String address) {
    	this.address = address;
    }
    
    /**
     * Gets the homepage.
     *
     * @return the homepage
     */
    public String getHomepage() {
    	return homepage;
    }

    /**
     * Sets the homepage.
     *
     * @param homepage the new homepage
     */
    public void setHomepage(String homepage) {
    	this.homepage = homepage;
    }
    
    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
    	return password;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
    	this.password = password;
    }
}
