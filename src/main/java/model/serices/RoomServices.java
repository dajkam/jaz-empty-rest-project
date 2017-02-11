package model.serices;


import model.Room;

import java.util.*;

public class RoomServices {
	
	
private List<Room>lista = new ArrayList<Room>();
	
	
	public List<Room> getAll(){return lista;}
	
	public Room getRoom (long id){
		for(Room pokoj : lista){
			if(pokoj.getId()==id)
				return pokoj;
			
		}
		
		
		return null;
		
	}
	
	public void addRoom(Room pokoj){
		
		lista.add(pokoj);
	}
	public void updateRoom(Room pokoj_szukany){
		for(Room pokoj_element_listy : lista){
			if(pokoj_szukany.getId()==pokoj_element_listy.getId()){
				pokoj_element_listy.setCena(pokoj_szukany.getCena());
				pokoj_element_listy.setCapasity(pokoj_szukany.getCapasity());
				
			}
		}
	}
	
	public void delRoom(Room pokoj){lista.remove(pokoj);}

}
