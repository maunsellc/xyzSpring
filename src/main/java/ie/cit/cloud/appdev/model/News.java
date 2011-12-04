package ie.cit.cloud.appdev.model;

import java.sql.Date;
import java.util.UUID;


/**
 * The Class News.
 *
 * @author Caroline Maunsell
 */
public class News {
	
	/** The id. */
	private String id;
	
	/** The title. */
	private String title;
    
    /** The article. */
    private String article;
    
    /** The date. */
    private Date date;

    /**
     * Instantiates a new news.
     */
    public News() {
    	// empty constructor to enable instantiation via reflection API
    	this(null,"","",null);
    }

    /**
     * Instantiates a new news.
     *
     * @param id the id
     * @param title the title
     * @param article the article
     * @param date the date
     */
    public News(String id, String title, String article, Date date) {
    	if(id == null)
    		this.id = UUID.randomUUID().toString();
    	else
    		this.id = id;
    	this.title = title;
    	this.article = article;
    	this.date = date;
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
     * Gets the article.
     *
     * @return the article
     */
    public String getArticle() {
    	return article;
    }

    /**
     * Sets the article.
     *
     * @param article the new article
     */
    public void setArticle(String article) {
    	this.article = article;
    }
    
    /**
     * Gets the date.
     *
     * @return the date
     */
    public Date getDate() {
    	return date;
    }

    /**
     * Sets the date.
     *
     * @param date the new date
     */
    public void setDate(Date date) {
    	this.date = date;
    }
}
