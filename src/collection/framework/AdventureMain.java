package collection.framework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdventureMain {
	private static Map<Integer, AdventureGameLocation> locations = new HashMap<Integer, AdventureGameLocation>();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		locations.put(0, new AdventureGameLocation(0, "You are infront of a computer"));
		locations.put(1, new AdventureGameLocation(1, "You are standing at the end of a small brick building"));
		locations.put(2, new AdventureGameLocation(2, "You are at the top of a hill"));
		locations.put(3, new AdventureGameLocation(3, "YOu are inside abuilding, a well house for a small spring"));
		locations.put(4, new AdventureGameLocation(4, "You are in a valley beside a stream"));
		locations.put(5, new AdventureGameLocation(5, "You are in the forest"));
		
		locations.get(1).addExit("W", 2);
		locations.get(1).addExit("E", 3);
		locations.get(1).addExit("S", 4);
		locations.get(1).addExit("N", 5);
		
		locations.get(2).addExit("N", 5);
		
		locations.get(3).addExit("W", 1);
		
		locations.get(4).addExit("N", 1);
		locations.get(4).addExit("W", 2);
		
		locations.get(5).addExit("S", 1);
		locations.get(5).addExit("W", 2);
		
		Map<String, String> vocabulary = new HashMap<String, String>();
		vocabulary.put("QUIT", "Q");
		vocabulary.put("EAST", "E");
		vocabulary.put("WEST", "W");
		vocabulary.put("NORTH", "N");
		vocabulary.put("SOUTH", "S");
		
		int loc = 1;
		while(true) {
			System.out.println(locations.get(loc).getDescription());
			if(loc==0) {
				break;
			}
			
			Map<String, Integer> exits = locations.get(loc).getExits(); 
			System.out.print("Available exits are ");
			for(String exit: exits.keySet()) {
				System.out.print(exit + ", ");
			}
			System.out.println();
			
			String direction = sc.nextLine().toUpperCase();
			
			if(direction.length() >1) {
				String[] words = direction.split(" ");
				for(String str: words) {
					if(vocabulary.containsKey(str)) {
						direction = vocabulary.get(str);
						break;
					}
				}
			}
			
			if(exits.containsKey(direction)) {
				loc = exits.get(direction);
			}else {
				System.out.println("You cannot go in that direction");
			}
			
		}

	}

}
