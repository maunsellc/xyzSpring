package ie.cit.cloud.appdev.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * The Class xyzDBTracing.
 * 
 *  @author Caroline Maunsell
 */

@Aspect
@Component
public class xyzDBTracing {

    /** The log. */
    Log log = LogFactory.getLog(xyzDBTracing.class);

    /**
     * Trace.
     *
     * @param jp the jp
     * @param repo the repo
     */
    @Before("execution(* (@org.springframework.stereotype.Repository ie.cit..*).*(..)) && target(repo)")
    public void trace(JoinPoint jp, Object repo) {
    	String clazz = repo.getClass().getName();
    	String method = jp.getSignature().getName();
    	log.trace("method invoked:" + clazz + "#" + method);
    }
}
