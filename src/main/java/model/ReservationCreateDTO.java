package model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.DateTime;
import org.joda.time.Days;
import java.sql.*;



public class ReservationCreateDTO { 
	
	private int id; 
	private DateTime start;
	private DateTime end; 
	//private Date start;
	//private Date end;
	private int roomId;
	private int guestId; 
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DateTime getStart() {
		return start;
	}

	public void setStart(DateTime start) {
		this.start = start;
	}

	public DateTime getEnd() {
		return end;
	}

	public void setEnd(DateTime end) {
		this.end = end;
	}

	
	public int getGuestId() {
		return guestId;
	}

	public int getRoomId() {
		return roomId;
	}
	
	public void setGuestId(int guestId) {
		this.guestId = guestId;
	}
	
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	} 
	
	 public int pobyt(){
			return Days.daysBetween(start, end).getDays();
		}   
	    
}

