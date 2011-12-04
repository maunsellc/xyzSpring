/**
 * 
 */
package ie.cit.cloud.appdev.model;


/**
 * The Class Intro.
 *
 * @author Caroline Maunsell
 */
public class Intro {
	
	/** The text. */
	private String text;
 
   	/**
	    * Instantiates a new intro.
	    */
	   public Intro() {
       // empty constructor to enable instantiation via reflection API
	   this("");
   	}

   	/**
	    * Instantiates a new intro.
	    *
	    * @param text the text
	    */
	   public Intro(String text) {
   		this.text = text;
   	}

    /**
     * Gets the text.
     *
     * @return the text
     */
    public String getText() {
    	return text;
	}
	
	/**
	 * Sets the text.
	 *
	 * @param text the new text
	 */
	public void setText(String text) {
		this.text = text;
	}
}
