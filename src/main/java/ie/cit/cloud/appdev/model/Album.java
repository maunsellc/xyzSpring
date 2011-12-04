/**
 * 
 */
package ie.cit.cloud.appdev.model;

import java.util.UUID;

/**
 * The Class Album.
 *
 * @author Caroline Maunsell
 */
public class Album {

	    /** The id. */
    	private String id;
	    
    	/** The title. */
    	private String title;
	    
    	/** The artist. */
    	private String artist;
	    
    	/** The label. */
    	private String label;
	    
    	/** The year. */
    	private String year;
	    
    	/** The image. */
    	private String image;
	    
    	/** The comment. */
    	private String comment;
	    
    	/** The votes. */
    	private int votes;

	    /**
    	 * Instantiates a new album.
    	 */
    	public Album() {
	    	// empty constructor to enable instantiation via reflection API
	    	this(null,"","","","","","", 0);
	    }

	    /**
    	 * Instantiates a new album.
    	 *
    	 * @param id the id
    	 * @param title the title
    	 * @param artist the artist
    	 * @param label the label
    	 * @param year the year
    	 * @param image the image
    	 * @param comment the comment
    	 * @param votes the votes
    	 */
    	public Album(String id,
	    		    String title,
	    		    String artist,
	    		    String label,
	    		    String year,
	    		    String image,
	    		    String comment,
	    		    int votes) {
	    	if(id == null)
	    		this.id = UUID.randomUUID().toString();
	    	else
	    		this.id = id;
	    	this.title = title;
	    	this.artist = artist;
	    	this.label = label;
	    	this.year = year;
	    	this.image = image;
	    	this.comment = comment;
	    	this.votes = votes;
	    }

	    /**
    	 * Gets the title.
    	 *
    	 * @return the title
    	 */
    	public String getTitle() {
	    	return title;
	    }

	    /**
    	 * Sets the title.
    	 *
    	 * @param title the new title
    	 */
    	public void setTitle(String title) {
	    	this.title = title;
	    }

	    /**
    	 * Gets the artist.
    	 *
    	 * @return the artist
    	 */
    	public String getArtist() {
	    	return artist;
	    }

	    /**
    	 * Sets the artist.
    	 *
    	 * @param artist the new artist
    	 */
    	public void setArtist(String artist) {
	    	this.artist = artist;
	    }
	    
	    
	    /**
    	 * Gets the label.
    	 *
    	 * @return the label
    	 */
    	public String getLabel() {
	    	return label;
	    }

	    /**
    	 * Sets the label.
    	 *
    	 * @param label the new label
    	 */
    	public void setLabel(String label) {
	    	this.label = label;
	    }
	    
	    
	    /**
    	 * Gets the year.
    	 *
    	 * @return the year
    	 */
    	public String getYear() {
	    	return year;
	    }

	    /**
    	 * Sets the year.
    	 *
    	 * @param year the new year
    	 */
    	public void setYear(String year) {
	    	this.year = year;
	    }
	    
	    
	    /**
    	 * Gets the image.
    	 *
    	 * @return the image
    	 */
    	public String getImage() {
	    	return image;
	    }

	    /**
    	 * Sets the image.
    	 *
    	 * @param image the new image
    	 */
    	public void setImage(String image) {
	    	this.image = image;
	    }
	    
	    
	    /**
    	 * Gets the comment.
    	 *
    	 * @return the comment
    	 */
    	public String getComment() {
	    	return comment;
	    }

	    /**
    	 * Sets the comment.
    	 *
    	 * @param comment the new comment
    	 */
    	public void setComment(String comment) {
	    	this.comment = comment;
	    }
	    
	    /**
    	 * Gets the votes.
    	 *
    	 * @return the votes
    	 */
    	public int getVotes() {
	    	return votes;
	    }

	    /**
    	 * Sets the votes.
    	 *
    	 * @param votes the new votes
    	 */
    	public void setVotes(int votes) {
	    	this.votes = votes;
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
}
