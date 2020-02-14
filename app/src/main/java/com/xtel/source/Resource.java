package com.xtel.source;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.xtel.model.User;

@Path("home")
public class Resource {
	Gson gson = new Gson();
	DaoResource dao = new DaoResource();

	@GET
	@Path("users")
	public Response selectAll() {
		return Response.ok().entity(gson.toJson(dao.selectAll())).build();
	}

	@POST
	@Path("add")
	public int addUser(String body) {
		User user = castToUser(body, User.class);
		int check = dao.addUser(user);
		System.out.println("--------");
		return check;
	}
	
	@DELETE
	@Path("user/{id}")
	public int delete(@PathParam("id")String id) {
		System.out.println("----------"+ id);
		return dao.delete(id);
	}
	
	private <T> T castToUser(String body , Class<T> t) {
		return gson.fromJson(body, t);
	}
}
