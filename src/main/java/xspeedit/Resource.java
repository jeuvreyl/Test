package xspeedit;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("xspeedit")
public class Resource {
    
    @GET
    @Path("articles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response paramMethod(@NotNull @Size(min=1) @QueryParam("articles") List<Integer> articles) {
      return Response.ok(App.arrangeCrates(articles)).build();
    }

}
