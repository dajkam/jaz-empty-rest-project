package rest;
import javax.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

import java.util.*; 
import model.*;

import javax.ws.rs.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;




import model.serices.RoomServices;


@Path("room")
@Stateless 
public class RoomResources {
	
	private RoomServices db = new RoomServices();

	@PersistenceContext 
	EntityManager em;
	
	@GET
	@Path("/show")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Room> getAll(){
		return db.getAll();
	} 
	
	@POST 
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response AddRoom(Room pokoj){
		db.addRoom(pokoj);
		em.persist(pokoj);
		return Response.ok(pokoj.getId()).build();
		
	}
	@GET 
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRoom(@PathParam("id") int id){
		try{
			Room result = (Room) em.createNamedQuery("room.id", Room.class)
				.setParameter("roomId", id)
				.getSingleResult();
			return Response.ok(result).build();
		}catch (NoResultException e) {
			return Response.status(NOT_FOUND).build();
		}
	}
	
	@DELETE 
	@Path("/{id}")
	public Response delete(@PathParam("id") int id){
		try{
			Room result = (Room) em.createNamedQuery("room.id", Room.class)
				.setParameter("pokojId", id)
				.getSingleResult();
			em.remove(result);
			return Response.ok(result).build();
		}catch (NoResultException e) {
			return Response.status(NOT_FOUND).build();
		}
	}
	
	
	}

