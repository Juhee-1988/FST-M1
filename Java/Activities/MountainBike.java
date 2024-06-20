package Activities;

public class MountainBike extends Bicycle {
	
	public int seatHeight;
	
	public MountainBike(int gears,int currentSpeed,int seatHeight) {
		super(gears,currentSpeed);
		this.seatHeight=seatHeight;
	}
	
	public void setHeight(int height) {
		seatHeight=height;
	}
	
	public String bicycleDesc() {
		return(super.bicycleDesc()+"\nSeat Height: "+seatHeight);
	}

}
