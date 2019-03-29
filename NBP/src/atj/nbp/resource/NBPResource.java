package atj.nbp.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import atj.nbp.service.NBPService;

//@Produces(MediaType.APPLICATION_XML)
@Path("{table}/{code}/{topCount}")
public class NBPResource {
	private NBPService nbpService = new NBPService();	

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String displayEverageExchangeRateTEXT(
		@PathParam("table") String table,
		@PathParam("code") String code,
		@PathParam("topCount") String topCount) {
    	return nbpService.getEverageExchangeRateTEXT(table, code, topCount);			
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String displayEverageExchangeRateHTML(
		@PathParam("table") String table,
		@PathParam("code") String code,
		@PathParam("topCount") String topCount) {
    	return nbpService.getEverageExchangeRateHTML(table, code, topCount);			
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String displayEverageExchangeRateXML(
		@PathParam("table") String table,
		@PathParam("code") String code,
		@PathParam("topCount") String topCount) {
    	return nbpService.getEverageExchangeRateXML(table, code, topCount);			
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String displayEverageExchangeRateJSON(
		@PathParam("table") String table,
		@PathParam("code") String code,
		@PathParam("topCount") String topCount) {
    	return nbpService.getEverageExchangeRateJSON(table, code, topCount);			
	}
}
