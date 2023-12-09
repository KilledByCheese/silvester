package de.killedbycheese.wichtelLosung;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

@Service
public class YeetService {
	
	private static final ArrayList<String> yeetList = new ArrayList<String>(); 
	private static final ArrayList<String> yootList = new ArrayList<String>(); 
	private static final ArrayList<String> yikesList = new ArrayList<String>(); 
	
	public YeetService() {
		yootList.add("lukas");
		yootList.add("gordon");
		yootList.add("dani");
		yootList.add("marcel");

		yeetList.add("lukas");
		yeetList.add("gordon");
		yeetList.add("dani");
		yeetList.add("marcel");
	}

	public String yoot(String name) {
		if(!yootList.contains(name)) {
			return "Name not in List, try with 'Gordon','Lukas','Dani', or 'Marcel'! ";
		}
		if(yikesList.contains(name)) {
			return "No rerolls allowed!";
		}
		yikesList.add(name);
		int index = getValidIndex(name);
		String yeetValue = yeetList.get(index);
		yeetList.remove(index);
		
		return "Your Wichtel-Gift is for: " + yeetValue;
	}
	
	
	private int getRandomIndex() {
		return ThreadLocalRandom.current().nextInt(0, yeetList.size());
	}
	
	private int getValidIndex(String name) {
		int index = -1;
		boolean indexFound = false;
		do {
			index = getRandomIndex();
			if(!yeetList.get(index).equals(name)) {
				indexFound = true;
			}
		} while(!indexFound);
		
		return index;
	}

}
