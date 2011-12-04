package ie.cit.cloud.appdev;


import ie.cit.cloud.appdev.model.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


/**
 * The Class XYZServiceImplTest.
 */
public class XYZServiceImplTest {

    /** The tested. */
    private XYZServiceImpl tested;
    
    /** The repo. */
    private XYZRepository repo;

    /**
     * Setup.
     */
    @Before
    public void setup() {
    	repo = Mockito.mock(XYZRepository.class);
    	tested = new XYZServiceImpl(repo);
    }

  
    
    /**
     * Test get album.
     */
    @Test
    public void testGetAlbum() {
    	Album album = new Album();
    	tested.getAlbum(album.getId());
    	Mockito.verify(repo).getAlbum(album.getId());
    }
    
   
    
    
    /**
     * Test add member.
     */
    @Test
    public void testAddMember() {
    	Member m = new Member();
    	tested.addNewMember(m);
    	Mockito.verify(repo).create(m);
    }
    
    /**
     * Test update member.
     */
    @Test
    public void testUpdateMember() {
    	Member m = new Member();
    	tested.updateMember(m,m.getName());
    	Mockito.verify(repo).update(m,m.getName());
    }
    
    /**
     * Test remove member.
     */
    @Test
    public void testRemoveMember() {
    	Member m = new Member();
    	tested.removeMember(m.getName());
    	Mockito.verify(repo).deleteMember(m.getName());
    }
    
    /**
     * Test get member.
     */
    @Test
    public void testGetMember() {
    	Member m = new Member();
    	tested.getMember(m.getName());
    	Mockito.verify(repo).getMember(m.getName());
    }
    
    /**
     * Test get news.
     */
    @Test
    public void testGetNews() {
    	News n = new News();
    	tested.getNews("New Album");
    	Mockito.verify(repo).getNews(n.getTitle());
    }
    
    
    
    /**
     * Test remove news.
     */
    @Test
    public void testRemoveNews() {
    	Member m = new Member();
    	tested.getMember(m.getName());
    	Mockito.verify(repo).getMember(m.getName());
    }
    
}

