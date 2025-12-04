import java.util.HashSet;
import java.util.Set;

public class Activity10 {

	public static void main (String[] args) {
		
		Set<String> objects = new HashSet<>();
		
		objects.add("pen");
		objects.add("pencil");
		objects.add("bottle");
		objects.add("cap");
		objects.add("bag");
		objects.add("book");
		
		System.out.println("List of objects: " +objects);
		System.out.println("Size: "+objects.size());
		
		boolean removePen= objects.remove("pen");
		System.out.println("Able to remove object: "+removePen);
		System.out.println("List after removal: "+objects);
		
		boolean removeHat= objects.remove("hat");
		System.out.println("Able to remove object: "+removeHat);
		System.out.println("List after failed removal: "+objects);
		
		System.out.println("Does list contains object : "+objects.contains("bottle"));
		
		System.out.println("Final list: "+objects);
		
	}
}
