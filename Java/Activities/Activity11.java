import java.util.HashMap;
import java.util.Map;

public class Activity11 {
	
	public static void main(String[] args) {
		
		Map<Integer,String> colors = new HashMap<>();
		
		colors.put(1, "Pink");
		colors.put(2, "green");
		colors.put(3, "black");
		colors.put(4, "blue");
		colors.put(5, "black");
		
		System.out.println("Initital Map: "+colors);
		
		System.out.println("Removed color: "+colors.remove(3));
		
		System.out.println("After removal: "+colors);
		
		System.out.println("Does the green color exist: "+colors.containsValue("green"));
		
		System.out.println("Size of the Map: "+colors.size());
		
		
	}

}
