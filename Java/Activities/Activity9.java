import java.util.ArrayList;
import java.util.List;

public class Activity9 {
	
	public static void main(String[] args) {
		//created an arraylist
		ArrayList<String> myList = new ArrayList<>();
		
		//add 5 names to the array list using add() method
		myList.add("Charishma");
		myList.add("Cherry");
		myList.add("Nani");
		myList.add("Sai");
		myList.add("Chandu");
		
		//print all the names 
		for (String name: myList) {
			System.out.println("List of names: " +name);
		}
		
		//get() method to retrieve the 3rd name in the list
		String third = myList.get(2);
		System.out.println(" 3rd name in the list: " +third);
		
		//contains() method to check if a name exists in the ArrayList
		boolean contain = myList.contains("Cherr");
		System.out.println(" Does List contains name: " +contain);
		
		//size() method to print the number of names in the ArrayList
		int length = myList.size();
		System.out.println(" Number of names in the ArrayList: " +length);
		
		//remove() method to remove a name from the list and print the size() of the list again
		myList.remove(3);
		//myList.remove(2);
		
		int newlength = myList.size();
		System.out.println(" Size of the list after removal: " +newlength);
		
	}
	

}
