/*
 * 
 */
package ie.cit.cloud.appdev;

import ie.cit.cloud.appdev.model.Album;
import ie.cit.cloud.appdev.model.Intro;
import ie.cit.cloud.appdev.model.Member;
import ie.cit.cloud.appdev.model.News;
import ie.cit.cloud.appdev.model.Review;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * The Class XYZJdbcRepository.
 *
 * @author Caroline Maunsell
 */
@Repository
public class XYZJdbcRepository implements XYZRepository {

	/** The tmpl. */
	private JdbcTemplate tmpl;

	/**
	 * Instantiates a new xYZ jdbc repository.
	 *
	 * @param dataSource the data source
	 */
	@Autowired
	public XYZJdbcRepository(DataSource dataSource) {
		tmpl = new JdbcTemplate(dataSource);
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZRepository#getAlbum(java.lang.String)
	 */
	public Album getAlbum(String id) {
		Album album = findAlbumById(id);
		if (album == null)
			throw new EmptyResultDataAccessException(1);
		return album;
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZRepository#vote(java.lang.String)
	 */
	public void vote(String id) {
		tmpl.update(
				"update Albums set votes=1+(select votes from Albums where id=?) where id=?",
				id, id);
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZRepository#findAllAlbums()
	 */
	public List<Album> findAllAlbums() {
		return tmpl.query("select * from Albums", new AlbumRowMapper());
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZRepository#findAlbumById(java.lang.String)
	 */
	public Album findAlbumById(String id) {
		return tmpl.queryForObject("select * from Albums where id=?",
				new AlbumRowMapper(), id);
	}

	/**
	 * The Class AlbumRowMapper.
	 */
	public static class AlbumRowMapper implements RowMapper<Album> {
		
		/* (non-Javadoc)
		 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
		 */
		public Album mapRow(ResultSet rs, int rowNum) throws SQLException {
			Album a = new Album(rs.getString("id"), rs.getString("title"),
					rs.getString("artist"), rs.getString("label"),
					rs.getString("year"), rs.getString("image"),
					rs.getString("comment"), rs.getInt("votes"));
			return a;
		}
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZRepository#getAllIntros()
	 */
	public Collection<Intro> getAllIntros() {
		return tmpl.query("select intro from Intros", new IntroRowMapper());
	}

	/**
	 * The Class IntroRowMapper.
	 */
	public static class IntroRowMapper implements RowMapper<Intro> {
		
		/* (non-Javadoc)
		 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
		 */
		public Intro mapRow(ResultSet rs, int rowNum) throws SQLException {
			Intro a = new Intro(rs.getString("intro"));
			return a;
		}
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZRepository#getMember(java.lang.String)
	 */
	public Member getMember(String name) {
		Member member = findMemberByName(name);
		if (member == null)
			throw new EmptyResultDataAccessException(1);
		return member;
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZRepository#create(ie.cit.cloud.appdev.model.Member)
	 */
	public void create(Member member) {
		tmpl.update(
				"insert into Members (name, email,address,homepage,password) values(?,?,?,?,?)",
				member.getName(), member.getEmail(),
				member.getAddress(), member.getHomepage(), member.getPassword());
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZRepository#update(ie.cit.cloud.appdev.model.Member)
	 */
	public void update(Member member, String name) {
		tmpl.update(
				"update Members set email=?, address=?, homepage=?, password=? where name=?",
				member.getEmail(), member.getAddress(),
				member.getHomepage(), member.getPassword(), name);
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZRepository#delete(ie.cit.cloud.appdev.model.Member)
	 */
	public void deleteMember(String name) {
		tmpl.update("delete from Members where name=?", name);
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZRepository#findAllMembers()
	 */
	public Collection<Member> findAllMembers() {
		return tmpl.query("select * from Members", new MemberRowMapper());
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZRepository#findMemberById(java.lang.String)
	 */
	public Member findMemberByName(String name) {
		return tmpl.queryForObject("select * from Members where name=?",
				new MemberRowMapper(), name);
	}

	/**
	 * The Class MemberRowMapper.
	 */
	public static class MemberRowMapper implements RowMapper<Member> {
		
		/* (non-Javadoc)
		 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
		 */
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
			Member a = new Member(rs.getString("name"),
					rs.getString("email"), rs.getString("address"),
					rs.getString("homepage"), rs.getString("password"));
			return a;
		}
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZRepository#getNews(java.lang.String)
	 */
	public News getNews(String id) {
		News news = findNewsById(id);
		if (news == null)
			throw new EmptyResultDataAccessException(1);
		return news;
	}


	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZRepository#findAllNews()
	 */
	public Collection<News> findAllNews() {
		return tmpl.query("select * from News", new NewsRowMapper());
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZRepository#findNewsById(java.lang.String)
	 */
	public News findNewsById(String id) {
		return tmpl.queryForObject(
				"select * from News where id=? order by date asc",
				new NewsRowMapper(), id);
	}

	/**
	 * The Class NewsRowMapper.
	 */
	public static class NewsRowMapper implements RowMapper<News> {
		
		/* (non-Javadoc)
		 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
		 */
		public News mapRow(ResultSet rs, int rowNum) throws SQLException {
			News a = new News(rs.getString("id"), rs.getString("title"),
					rs.getString("article"), rs.getDate("date"));
			return a;
		}
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZRepository#create(ie.cit.cloud.appdev.model.Review)
	 */
	public void create(Review review) {
		tmpl.update(
				"insert into Reviews (id, review, albumId, name) values(?,?,?,?)",
				review.getId(), review.getReview(), review.getAlbumId(),
				review.getName());
	}



	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZRepository#findAllReviews()
	 */
	public Collection<Review> findAllReviews() {
		return tmpl.query("select * from Reviews", new ReviewsRowMapper());
	}

	/* (non-Javadoc)
	 * @see ie.cit.cloud.appdev.XYZRepository#findReviewsByAlbumId(java.lang.String)
	 */
	public Collection<Review> findReviewsByAlbumId(String id) {
		return tmpl
				.query("select * from Reviews where albumId=?",
						new ReviewsRowMapper(), id);
	}

	/**
	 * The Class ReviewsRowMapper.
	 */
	public static class ReviewsRowMapper implements RowMapper<Review> {
		
		/* (non-Javadoc)
		 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
		 */
		public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
			Review a = new Review(rs.getString("id"),
					rs.getString("review"),
					rs.getString("albumId"),
					rs.getString("name"));
			return a;
		}
	}

}