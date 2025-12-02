
public class Activity1 {
	
	 public static void main(String[] args) {
	        Car carname = new Car();
	        carname.make = 2014;
	        carname.color = "Red";
	        carname.transmission = "Manual";
	    
	        //Using Car class method
	        carname.displayCharacterstics();
	        carname.accelerate();
	        carname.brake();
	    }

}
