package Activities;

public class Car {
	
	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	Car(){
		tyres=4;
		doors=4;
	}
	
	public void displayCharacteristics() {
		System.out.println("Color of the Car: " + color);
		System.out.println("Make of the Car: " + make);
		System.out.println("Transmission of the Car: " + transmission);
		System.out.println("No. of doors in the Car: " + doors);
		System.out.println("No. of tyres in the Car: " + tyres);
		}
	
	public void accelerate() {
		System.out.println("Car is moving forward");
		}
	
	public void brake() {
		System.out.println("Car has stopped");
		}

}
