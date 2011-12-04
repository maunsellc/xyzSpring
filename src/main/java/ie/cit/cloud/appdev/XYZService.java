package ie.cit.cloud.appdev;

import ie.cit.cloud.appdev.model.*;
//import org.springframework.security.annotation.Secured;

import java.util.Collection;

/**
 * Peforms business operation on TODOs.
 * 
 * @author Caroline Maunsell
 */
public interface XYZService {

	//Albums
    /**
	 * Gets the all albums.
	 *
	 * @return the all albums
	 */
	Collection<Album> getAllAlbums();


    /**
     * Gets the album.
     *
     * @param id the id
     * @return the album
     */
    Album getAlbum(String id);

   
    /**
     * Adds the vote for album.
     *
     * @param id the id
     */
    void addVoteForAlbum(String id);

    //Introduction
    /**
     * Gets the all intros.
     *
     * @return the all intros
     */
    Collection<Intro> getAllIntros();
    
  
    // Members
    /**
     * Gets the all members.
     *
     * @return the all members
     */
    Collection<Member> getAllMembers();

    /**
     * Adds the new member.
     *
     * @param member the member
     */
    void addNewMember(Member member);

    /**
     * Gets the member.
     *
     * @param id the id
     * @return the member
     */
    Member getMember(String id);

    /**
     * Update member.
     *
     * @param member the member
     */
    void updateMember(Member member, String name);

    /**
     * Removes the member.
     *
     * @param id the id
     */
    void removeMember(String name);
    
    
    // News
    /**
     * Gets the all news.
     *
     * @return the all news
     */
    Collection<News> getAllNews();

 
    /**
     * Gets the news.
     *
     * @param title the title
     * @return the news
     */
    News getNews(String title);

  
    
    // Reviews
    /**
     * Gets the all reviews.
     *
     * @return the all reviews
     */
    Collection<Review> getAllReviews();

    /**
     * Gets the reviews for album id.
     *
     * @param id the id
     * @return the reviews for album id
     */
    Collection<Review> getReviewsForAlbumId(String id);

    /**
     * Adds the review.
     *
     * @param review the review
     */
    
    //@Secured("ROLE_MEMBER")
    void addReview(Review review);


}