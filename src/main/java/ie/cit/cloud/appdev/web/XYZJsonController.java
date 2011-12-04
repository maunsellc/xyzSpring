package ie.cit.cloud.appdev.web;
/**
 * Database 'RESTfull' JSON Controller
 * 
 * @author Caroline Maunsell
 */

import ie.cit.cloud.appdev.XYZService;
import ie.cit.cloud.appdev.model.*;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;

/**
 * The Class XYZJsonController.
 */
@Controller
@RequestMapping("db")
public class XYZJsonController {
    
    /** The xyz service. */
    @Autowired
    private XYZService xyzService;

    /**
     * Gets the albums.
     *
     * @return the albums
     */
    @RequestMapping("/albums")
    @ResponseBody
    public Collection<Album> getAlbums() {
    	return xyzService.getAllAlbums();
    }

    /**
     * Creates the review.
     *
     * @param review the review
     * @param request the request
     * @param response the response
     */
    @RequestMapping(value = "/review", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createReview(@RequestBody Review review, HttpServletRequest request,
	    HttpServletResponse response) {
    	xyzService.addReview(review);
    	response.addHeader("Location",
    			getLocationForChildResource(request, review.getId()));
    }
    
    /**
     * Gets the members.
     *
     * @return the members
     */
    @RequestMapping("/members")
    @ResponseBody
    public Collection<Member> getMembers() {
    	return xyzService.getAllMembers();
    }
    
    /**
     * Creates the member.
     *
     * @param member the member
     * @param request the request
     * @param response the response
     */
    @RequestMapping(value = "/member", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createMember(@RequestBody Member member, HttpServletRequest request,
	    HttpServletResponse response) {
    	xyzService.addNewMember(member);
    	response.addHeader("Location",
    			getLocationForChildResource(request, member.getName()));
    }

    /**
     * Update the member.
     *
     * @param member the member
     * @param request the request
     * @param response the response
     */
    @RequestMapping(value = "/member/{name}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMember(@RequestBody Member member, @PathVariable("name") String name) {
    	xyzService.updateMember(member, name);
    }

    /**
     * Delete the member.
     *
     * @param member the member
     * @param request the request
     * @param response the response
     */
    @RequestMapping(value = "/member/{name}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMember(@PathVariable("name") String name) {
    	xyzService.removeMember(name);
    }


    /**
     * Empty result.
     */
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public void emptyResult() {
	// no code needed
    }

    /**
     * Gets the location for child resource.
     *
     * @param request the request
     * @param childIdentifier the child identifier
     * @return the location for child resource
     */
    private String getLocationForChildResource(HttpServletRequest request,
	    Object childIdentifier) {
	// get the current URL from the reguest
	final StringBuffer url = request.getRequestURL();
	// append the /xyz to the URL and make it a UriTemplate
	final UriTemplate template = new UriTemplate(url.append("/{childId}")
		.toString());
	return template.expand(childIdentifier).toASCIIString();
    }
}
