package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Room {

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
