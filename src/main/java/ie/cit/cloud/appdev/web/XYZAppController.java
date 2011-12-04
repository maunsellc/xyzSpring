package ie.cit.cloud.appdev.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import ie.cit.cloud.appdev.XYZService;
import ie.cit.cloud.appdev.model.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.security.core.context.SecurityContextHolder;


/**
 * Application 'RESTless' Controller.
 *
 * @author Caroline Maunsell
 */
@Controller
public class XYZAppController {
    
    /** The xyz service. */
    @Autowired
    private XYZService xyzService;

    /**
     * Index page.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = { "" }, method = GET)
    public String indexPage(Model model) {
    	return "redirect:/index.html";
    }

    /**
     * Main page.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = { "main" }, method = GET)
    public String mainPage(Model model) {
    	model.addAttribute("intros", xyzService.getAllIntros());
    	return "main";
    }
    
    /**
     * News page.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = { "news" }, method = GET)
    public String newsPage(Model model) {
    	model.addAttribute("news", xyzService.getAllNews());
    	return "news";
    }
    
   /**
    * Album page.
    *
    * @param model the model
    * @return the string
    */
   @RequestMapping(value = { "albums" }, method = GET)
    public String albumPage(Model model) {
    	model.addAttribute("memberid", "1");
    	return "albums";
    }

   /**
    * Join page.
    *
    * @param model the model
    * @return the string
    */
   @RequestMapping(value = { "join" }, method = GET)
   public String joinPage(Model model) {
   	return "join";
   }

   /**
    * Adds the review page.
    *
    * @param title the title
    * @param album the album
    * @param member the member
    * @param model the model
    * @return the string
    */
   @RequestMapping(value = { "addreview" }, method = GET)
    public String addReviewPage(@RequestParam("title") String title, @RequestParam("album") String album, @RequestParam("member") String member, Model model) {
    	model.addAttribute("title", title);
    	model.addAttribute("album", album);
    	model.addAttribute("member", member);
   	return "addreview";
    }

    /**
     * See reviews page.
     *
     * @param title the title
     * @param id the id
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = { "seereviews" }, method = GET)
    public String seeReviewsPage(@RequestParam("title") String title, @RequestParam("album") String id, Model model) {
    	model.addAttribute("title", title);
    	model.addAttribute("reviews", xyzService.getReviewsForAlbumId(id));
    	return "seereviews";
    }

    /**
     * See reviews page.
     *
     * @param id the id
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = { "vote" }, method = POST)
    public String seeReviewsPage(@RequestParam("album") String id, Model model) {
    	xyzService.addVoteForAlbum(id);
    	model.addAttribute("memberid", "1");
    	return "albums";
    }

    /**
     * Login page.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = { "login" }, method = GET)
    public String loginPage(@RequestParam(value="status", defaultValue = "none") String status, Model model) {
    	model.addAttribute("status", status);
    	return "login";
    }

    /**
     * Members page.
     *
     * @param model the model
     * @return the string
     */
    @RequestMapping(value = { "members" }, method = GET)
    public String loginPage(Model model) {
    	String username = SecurityContextHolder.getContext().getAuthentication().getName();
    	Member member = xyzService.getMember(username);
    	model.addAttribute("name", member.getName());
    	model.addAttribute("email", member.getEmail());
    	model.addAttribute("address", member.getAddress());
    	model.addAttribute("homepage", member.getHomepage());
    	model.addAttribute("password", member.getPassword());

    	return "members";
    }


    /**
    * Empty result.
    */
   @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public void emptyResult() {
	// no code needed
    }
}

