package ie.cit.cloud.appdev.model;

import java.util.UUID;

/**
 * The Class Review
 *
 * @author Caroline Maunsell
 */
public class Review {
	
	/** The id. */
	private String id;
	
	/** The review. */
	private String review;
    
    /** The album id. */
    private String albumId;
    
    /** The member id. */
    private String memberId;
    
    /** The member name. */
    private String name;

    /**
     * Instantiates a new review.
     */
    public Review() {
    	// empty constructor to enable instantiation via reflection API
    	this(null,"","","");
    }

    /**
     * Instantiates a new review.
     *
     * @param id the id
     * @param review the review
     * @param albumId the album id
     * @param name the member name
     */
    public Review(String id, String review, String albumId, String name) {
    	if(id == null)
    		this.id = UUID.randomUUID().toString();
    	else
    		this.id = id;
    	this.review = review;
    	this.albumId = albumId;
    	this.name = name;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
    	return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(String id) {
    	this.id = id;
    }
    
   /**
    * Gets the review.
    *
    * @return the review
    */
   public String getReview() {
    	return review;
    }

    /**
     * Sets the review.
     *
     * @param review the new review
     */
    public void setReview(String review) {
    	this.review = review;
    }
    
    /**
     * Gets the album id.
     *
     * @return the album id
     */
    public String getAlbumId() {
    	return albumId;
    }

    /**
     * Sets the album id.
     *
     * @param albumId the new album id
     */
    public void setAlbumId(String albumId) {
    	this.albumId = albumId;
    }

    /**
     * Sets the member name.
     *
     * @param name the new member name
     */
    public void setName(String name) {
    	this.name = name;
    }

    /**
     * Gets the member name.
     *
     * @return the member name
     */
    public String getName() {
    	return name;
    }
}
