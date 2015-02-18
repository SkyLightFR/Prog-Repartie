

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/calc")
public class CalcREST {
	@GET
	@Path("/addp/{a}/{b}")
	@Produces(MediaType.TEXT_PLAIN)
	public String addPlainText(@PathParam("a") double a, @PathParam("b") double b) {
		return (a + b) + "";
	}

	@GET
	@Path("/subp/{a}/{b}")
	@Produces(MediaType.TEXT_PLAIN)
	public String subPlainText(@PathParam("a") double a, @PathParam("b") double b) {
		return (a - b) + "";
	}

	@GET
	@Path("/addx/{a}/{b}")
	@Produces(MediaType.TEXT_XML)
	public String addXML(@PathParam("a") double a, @PathParam("b") double b) {
		return "<?xml version=\"1.0\"?>" + "<result>" + (a + b) + "</result>";
	}

	@GET
	@Path("/subx/{a}/{b}")
	@Produces(MediaType.TEXT_XML)
	public String subXML(@PathParam("a") double a, @PathParam("b") double b) {
		return "<?xml version=\"1.0\"?>" + "<result>" + (a - b) + "</result>";
	}
}
