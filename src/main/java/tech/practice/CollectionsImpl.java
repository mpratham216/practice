package tech.practice;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("mycollections")
public class CollectionsImpl {
	@GET
	@Path("commonlist")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getCommonFromList(@QueryParam("list1") List<Integer> l1, @QueryParam("list2") List<Integer> l2) {
		List<Integer> commonList = l1.stream().filter(l2::contains).collect(Collectors.toList());
		return Response.ok(commonList).build();
	}
}
 