package model;

public class ReservationCreateDTO {
	private int roomId;
	private int guestId;
	
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
}

