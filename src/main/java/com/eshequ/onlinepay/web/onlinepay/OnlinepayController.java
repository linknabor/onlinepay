/**
 * 
 */
package com.eshequ.onlinepay.web.onlinepay;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eshequ.onlinepay.web.BaseController;

/**
 * @author huym
 *
 */
@Path("/onlinepay")
public class OnlinepayController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(OnlinepayController.class);
	
	@GET
	@Path("/{param}")
	@Produces("text/plain;charset=UTF-8") 
	public String getToken(@PathParam("param") String platChannel) {
		
		logger.info("getToken, platChannel is : " + platChannel);
        return "";
        
    }
	
	
}
