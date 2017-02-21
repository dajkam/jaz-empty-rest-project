package model;

import javax.persistence.Column;
import javax.persistence.Entity;

import java.sql.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import java.sql.Date;


@XmlRootElement 
@Entity  
@NamedQueries({
  @NamedQuery(name="reservation.all", query="SELECT r FROM Reservation r"),
  @NamedQuery(name="reservation.id",query="FROM Reservation r WHERE r.id=:rezerwacjaId")
})

public class Reservation {
	@Id 
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	//@OneToMany 
	@ManyToOne
	private Guest gosc; 
	@OneToOne 
    private Room pokoj;
    private int dni;
    private int cena_p; 
    private int naleznosc; 
    @Column
	//@Type(type="date")
    private DateTime start; 
    @Column
	//@Type(type="date")
    private DateTime end; 
    
    public int pobyt(DateTime start,DateTime end){
		return Days.daysBetween(new LocalDate(start),
		           new LocalDate(end)).getDays();
	}   
    
    public int zaplata (int dni,int cena_p){
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
	@XmlTransient
	public void setGosc(Guest gosc) {
		this.gosc = gosc;
	}
	@XmlTransient
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
	
	public void setStart(int year,int mounth, int day) {
		this.start  = new DateTime(year, mounth, day , 0, 0, 0);
		
	}
	
	public void setEnd(int year,int mounth, int day) {
		this.end = new DateTime(year, mounth, day,0,0,0);
	}
	

   
}
