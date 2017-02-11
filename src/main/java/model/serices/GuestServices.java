package model.serices;
import model.Guest;

 
import java.util.*;

public class GuestServices { 
	private List<Guest>lista = new ArrayList<Guest>();
	
	
	public List<Guest> getAll(){return lista;}
	
	public Guest getGuest (int id){
		for(Guest gosc : lista){
			if(gosc.getId()==id)
				return gosc;
			
		}
		
		
		return null;
		
	}
	
	public void addGuest(Guest gosc){
		
		lista.add(gosc);
	}
	public void updateGuest(Guest gosc_szukany){
		for(Guest gosc_element_listy : lista){
			if(gosc_szukany.getId()==gosc_element_listy.getId()){
				gosc_element_listy.setName(gosc_szukany.getName());
				gosc_element_listy.setSurname(gosc_szukany.getSurname());
				gosc_element_listy.setAdres(gosc_szukany.getAdres());
				gosc_element_listy.setCard(gosc_szukany.getCard());
				gosc_element_listy.setEmail(gosc_szukany.getEmail());
				gosc_element_listy.setPhone(gosc_szukany.getPhone());
			}
		}
	}
	
	public void delGuest(Guest gosc){lista.remove(gosc);}
	
}
