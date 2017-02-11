package rest;
import javax.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


import java.util.*; 
import model.*;

import javax.ws.rs.GET;
import javax.ws.rs.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import java.util.ArrayList;
import java.util.List;


import model.serices.RezervationServices;


@Path("/reservation")
@Stateless 
public class ReservationResources {
	
	private RezervationServices db = new RezervationServices();

	@PersistenceContext 
	EntityManager em;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reservation> getAll(){
		return db.getAll();
	} 
	
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addReservation(ReservationCreateDTO reservationCreateDTO){
		Reservation reservation = new Reservation();
		try{
			Guest guest = (Guest) em.createNamedQuery("guest.id", Guest.class)
				.setParameter("goscId", reservationCreateDTO.getGuestId())
				.getSingleResult();
			reservation.setGosc(guest);
			//TODO  ...
		
		}catch (NoResultException e) {
			return Response.status(Status.NOT_FOUND).build();
		}
		db.addReservation(reservation);
		return Response.ok(reservation.getId()).build();
		
	}
	@GET 
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReservation(@PathParam("id") int id ){
		Reservation result = db.getReservation(id);
		if(result==null){
			return Response.status(404).build();
		} 
		return Response.ok(result).build();
	}
	
	@DELETE 
	@Path("/{id}")
	public Response delete(@PathParam("id") int id){
		Reservation r = db.getReservation(id); 
		if(r==null)
			return Response.status(404).build();
		db.updateReservation(r);
		return Response.ok().build();
	}
	
	@GET 
	@Path("/{id}/guest")
	@Produces(MediaType.APPLICATION_JSON)
	public Guest getGuestRezervation(@PathParam("id")int rezervationId){
		Guest r = db.getReservation(rezervationId).getGosc();
		if(r==null)
			return null;
		return r;
	}
	
	
	
	/*@POST
	@Path("/{id}/room")
	@Produces(MediaType.APPLICATION_JSON)
	public  Response addRoom(@PathParam("id")int rezervationId, Room pokoj){
		Reservation r = db.getReservation(rezervationId); 
		if(r==null)
			return Response.status(404).build(); 
		r.setPokoj(pokoj);
		return Response.ok().build();
	}
	
	@POST
	@Path("/{id}/guest")
	@Produces(MediaType.APPLICATION_JSON)
	public  Response addGuest(@PathParam("id")int rezervationId, Guest gosc){
		Reservation r = db.getReservation(rezervationId); 
		if(r==null)
			return Response.status(404).build(); 
		r.setGosc(gosc);
		return Response.ok().build();
	}*/
	
	
	
	
	}

