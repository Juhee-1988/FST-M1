package Activities;

public class Bicycle implements BicycleParts, BicycleOperations{
	
	public int gears;
	public int currentSpeed;
	
	public Bicycle(int gears, int currentSpeed) {
		this.gears=gears;
		this.currentSpeed=currentSpeed;
	}
	
	public void applyBrake(int decrement) {
		currentSpeed -= decrement;
		System.out.println("Current Speed: "+currentSpeed);
	}
	
	public void speedUp(int increment) {
		currentSpeed += increment;
		System.out.println("Current Speed: "+currentSpeed);
	}
	
	public String bicycleDesc() {
		return("No.ōf gears: "+gears+"\nSpeed of bicycle: "+currentSpeed);
	}
}
