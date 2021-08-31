package modle.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumner, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumner;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumner() {
		return roomNumber;
	}

	public void setRoomNumner(Integer roomNumner) {
		this.roomNumber = roomNumner;
	}	

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MICROSECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber	
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out"
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
		
	}
}