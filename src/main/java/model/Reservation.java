package model;

import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 * Created by Sopot Roza on 2017-01-28.
 */
public class Reservation {
	  
	private int id;
	private Guest gosc; 
    private Room pokoj;
    private int dni;
    private int cena_p; 
    private int naleznosc;  
    private DateTime start; 
    private DateTime end; 
    
    public int pobyt(){
		return Days.daysBetween(start, end).getDays();
	}   
    
    public int zaplata (){
		return dni*cena_p;
	} 
	
    public Reservation() {
    	
    }
    
    public Reservation(int id, Guest gosc, Room pokoj, int dni, int cena_p, int naleznosc, DateTime start,
			DateTime end) {
		super();
		this.id = id;
		this.gosc = gosc;
		this.pokoj = pokoj;
		this.dni = dni;
		this.cena_p = cena_p;
		this.naleznosc = naleznosc;
		this.start = start;
		this.end = end;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Guest getGosc() {
		return gosc;
	}

	public void setGosc(Guest gosc) {
		this.gosc = gosc;
	}

	public Room getPokoj() {
		return pokoj;
	}

	public void setPokoj(Room pokoj) {
		this.pokoj = pokoj;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getCena_p() {
		return cena_p;
	}

	public void setCena_p(int cena_p) {
		this.cena_p = cena_p;
	}

	public int getNaleznosc() {
		return naleznosc;
	}

	public void setNaleznosc(int naleznosc) {
		this.naleznosc = naleznosc;
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
	

   
}
