package model.serices;

import model.Guest;
import model.Room;
import model.Reservation;


import java.util.*;

public class RezervationServices {
	
private List<Reservation>lista = new ArrayList<Reservation>();
	
	
	public List<Reservation> getAll(){return lista;}
	
	public Reservation getReservation (int id){
		for(Reservation rezerwacja : lista){
			if(rezerwacja.getId()==id)
				return rezerwacja;
			
		}
		
		
		return null;
		
	}
	
	public void addReservation(Reservation rezerwacja){
		
		lista.add(rezerwacja);
	}
	public void updateReservation(Reservation rezerwacja_szukany){
		for(Reservation rezerwacja_element_listy : lista){
			if(rezerwacja_szukany.getId()==rezerwacja_element_listy.getId()){
				rezerwacja_element_listy.setStart(rezerwacja_szukany.getStart());
				rezerwacja_element_listy.setEnd(rezerwacja_szukany.getEnd());
				rezerwacja_element_listy.setGosc(rezerwacja_szukany.getGosc());
				rezerwacja_element_listy.setPokoj(rezerwacja_szukany.getPokoj());
				
				rezerwacja_element_listy.setDni(rezerwacja_element_listy.pobyt())  ;
				rezerwacja_element_listy.setCena_p(rezerwacja_szukany.getPokoj().getCena());
				rezerwacja_element_listy.setNaleznosc(rezerwacja_szukany.zaplata());  
				
			}
		}
	}
	
	public void delRezervation(Reservation rezerwacja){lista.remove(rezerwacja);}

}
