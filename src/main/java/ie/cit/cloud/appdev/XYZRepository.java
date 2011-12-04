package ie.cit.cloud.appdev;

import ie.cit.cloud.appdev.model.Album;
import ie.cit.cloud.appdev.model.Intro;
import ie.cit.cloud.appdev.model.Member;
import ie.cit.cloud.appdev.model.News;
import ie.cit.cloud.appdev.model.Review;

import java.util.Collection;


/**
 * The Interface XYZRepository.
 * 
 * @author Caroline Maunsell
 */
public interface XYZRepository {
  
	// Album 
    /**
	 * Gets the album.
	 *
	 * @param id the id
	 * @return the album
	 */
	Album getAlbum(String id);
    
    
    /**
     * Vote.
     *
     * @param id the id
     */
    void vote(String id);
    
    /**
     * Find all albums.
     *
     * @return the collection
     */
    Collection<Album> findAllAlbums();
    
    /**
     * Find album by id.
     *
     * @param id the id
     * @return the album
     */
    Album findAlbumById(String id);
    
    // Intro
    /**
     * Gets the all intros.
     *
     * @return the all intros
     */
    Collection<Intro>  getAllIntros();
    
    
    //Member
    /**
     * Gets the member.
     *
     * @param id the id
     * @return the member
     */
    Member getMember(String name);  
    
    /**
     * Creates the.
     *
     * @param member the member
     */
    void create(Member member);
    
    /**
     * Update.
     *
     * @param member the member
     */
    void update(Member member, String name); 
    
    /**
     * Delete.
     *
     * @param member the member
     */
    void deleteMember(String name); 
    
    /**
     * Find all members.
     *
     * @return the collection
     */
    Collection<Member> findAllMembers();
    
    /**
     * Find member by id.
     *
     * @param id the id
     * @return the member
     */
    Member findMemberByName(String name);
    
   //News
    /**
    * Gets the news.
    *
    * @param id the id
    * @return the news
    */
   News getNews(String id);
    
    
    /**
     * Find all news.
     *
     * @return the collection
     */
    Collection<News> findAllNews();
    
    /**
     * Find news by id.
     *
     * @param title the title
     * @return the news
     */
    News findNewsById(String title);
    
    //Reviews
	/**
     * Creates the.
     *
     * @param review the review
     */
    void create(Review review);
	
	
	/**
	 * Find all reviews.
	 *
	 * @return the collection
	 */
	Collection<Review> findAllReviews();
	
	/**
	 * Find reviews by album id.
	 *
	 * @param name the name
	 * @return the collection
	 */
	Collection<Review> findReviewsByAlbumId(String name); 

}