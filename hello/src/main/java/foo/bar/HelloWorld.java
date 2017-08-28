package foo.bar;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

/*
The "Path" annotation indicates the URI this class will be available at relative to your base URL.  For
example, if this web-app is launched at localhost using a context of "hello" and no URL pattern is defined
in the web.xml servlet mapping section, then the web service will be available at:

http://localhost:8080/hello/world
 */
@Path("/world")
public class HelloWorld {

	 static List<Book> li = new ArrayList<Book>();

	/*
	 * The "GET" annotation indicates this method will respond to HTTP Get
	 * requests. The "Produces" annotation indicates the MIME response the
	 * method will return.
	 */
/*	@GET
	@Path("/word")
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		li.add(new Book("one", 1));
		li.add(new Book("Two", 2));
		li.add(new Book("Three", 3));

		return new Gson().toJson(li);
	}*/

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello1() {
		/*li.add(new Book("one", 1));
		li.add(new Book("Two", 2));
		li.add(new Book("Three", 3));*/

		return new Gson().toJson(li);
	}
	
	@Path("{t}/{i}")
	  @GET
	  @Produces("application/json")
	  public Response addBook(@PathParam("t") String t, @PathParam("i") int i) throws JSONException {

		li.add(new Book(t, i));

		String result =  new Gson().toJson(li);
		return Response.status(200).entity(result).build();
	  }

	@Path("{t}")
	  @GET
	  @Produces("application/json")
	  public Response removeBook( @PathParam("i") int i) throws JSONException {

		li.remove(i);

		String result =  new Gson().toJson(li);
		return Response.status(200).entity(result).build();
	  }

	
	
	 	/*@POST
	   @Path("/{Title}/{id})")
	   @Consumes("text/plain")
	   @Produces("text/html")
	   public String addBook(
	      @PathParam("Title") final String name,
	      @PathParam("id") final Integer id)
	   {
	 		li.add(new Book(name,id));
	      return new Gson().toJson(li);
	   }*/

}
