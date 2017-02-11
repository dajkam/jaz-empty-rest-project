package rest;
import javax.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


import java.util.*; 
import model.*;

import javax.ws.rs.GET;
import javax.ws.rs.*;

import javax.ejb.Stateless;


import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;




import model.serices.RoomServices;


@Path("Room")
public class RoomResources {
	
	private RoomServices db = new RoomServices();

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Room> getAll(){
		return db.getAll();
	} 
	
	@POST 
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AddRoom(Room gosc){
		db.addRoom(gosc);
		return Response.ok(gosc.getId()).build();
		
	}
	@GET 
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRoom(@PathParam("id")int id ){
		Room result = db.getRoom(id);
		if(result==null){
			return Response.status(404).build();
		} 
		return Response.ok(result).build();
	}
	
	@DELETE 
	@Path("/{id}")
	public Response delete(@PathParam("id") int id){
		Room r = db.getRoom(id); 
		if(r==null)
			return Response.status(404).build();
		db.updateRoom(r);
		return Response.ok().build();
	}
	
	}

