package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

@Entity  
@NamedQueries({
  @NamedQuery(name="room.all", query="SELECT r FROM Room r "),
  @NamedQuery(name="room.id",query="FROM Room r WHERE r.id=:roomId")
})


public class Room { 
	@Id 
	@GeneratedValue( strategy = GenerationType.IDENTITY)

    private int id;
    private int cena;
    private int capasity;

    public int getCapasity() {
        return capasity;
    }

    public int getCena() {
        return cena;
    }

    public long getId() {
        return id;
    }

    public void setCapasity(int capasity) {
        this.capasity = capasity;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public void setId(int id) {
        this.id = id;
    }
}
