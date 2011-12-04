package ie.cit.cloud.appdev;

import ie.cit.cloud.appdev.model.*;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * The Class XYZServiceImpl.
 * @author Caroline Maunsell
 */
@Service
@Transactional
public class XYZServiceImpl implements XYZService {

    /** The repo. */
    private final XYZRepository repo;

    /**
     * Instantiates a new xYZ service impl.
     *
     * @param XYZRepository the xYZ repository
     */
    @Autowired
    public XYZServiceImpl(XYZRepository XYZRepository) {
    	this.repo = XYZRepository;
    }

    /* (non-Javadoc)
     * @see ie.cit.cloud.appdev.XYZService#getAllAlbums()
     */
    public Collection<Album> getAllAlbums() {
    	return repo.findAllAlbums();
    }


    /* (non-Javadoc)
     * @see ie.cit.cloud.appdev.XYZService#getAlbum(java.lang.String)
     */
    public Album getAlbum(String id) {
    	return repo.findAlbumById(id);
    }


    /* (non-Javadoc)
     * @see ie.cit.cloud.appdev.XYZService#addVoteForAlbum(java.lang.String)
     */
    @Secured("ROLE_MEMBER")
    public void addVoteForAlbum(String albumId) {
    	repo.vote(albumId);
    }


	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZService#getAllIntros()
	 */
	public Collection<Intro> getAllIntros() {
		return repo.getAllIntros();
	}


	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZService#getAllMembers()
	 */
	public Collection<Member> getAllMembers() {
		return repo.findAllMembers();
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZService#addNewMember(ie.cit.cloud.appdev.model.Member)
	 */
	public void addNewMember(Member member) {
		repo.create(member);
		
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZService#getMember(java.lang.String)
	 */
	public Member getMember(String id) {
		return repo.getMember(id);
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZService#updateMember(ie.cit.cloud.appdev.model.Member)
	 */
	public void updateMember(Member member, String name) {
		repo.update(member, name);
		
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZService#removeMember(ie.cit.cloud.appdev.model.Member)
	 */
	public void removeMember(String name) {
		repo.deleteMember(name);
		
	}
	

	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZService#getAllNews()
	 */
	@Secured("ROLE_MEMBER")
	public Collection<News> getAllNews() {
		return repo.findAllNews();
	}


	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZService#getNews(java.lang.String)
	 */
	public News getNews(String title) {
		return repo.getNews(title);
	}
	

	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZService#getAllReviews()
	 */
	public Collection<Review> getAllReviews() {
		return repo.findAllReviews();
	}
	
	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZService#getReviewsForAlbumId(java.lang.String)
	 */
	public Collection<Review> getReviewsForAlbumId(String id) {
		return repo.findReviewsByAlbumId(id);
	}

	
	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZService#addReview(ie.cit.cloud.appdev.model.Review)
	 */
	@Secured("ROLE_MEMBER")
	public void addReview(Review review) {
		repo.create(review);
		
	}

	
}