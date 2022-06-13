package ch11.lectures.portableexample;

import java.util.Iterator;
import java.util.List;

public class PortableUtils {

	public static boolean areLighterThan(List<? extends Portable> list, double maxWeight) {
	
		double accumulatedWeight = 0.0;
		
		for(Portable portable : list)
			accumulatedWeight += portable.getWeight();
		
		return accumulatedWeight < maxWeight;
	};
	
	public static <T extends Portable> T lightest(List<T> collection) {
		
		Iterator<T> iterator = collection.iterator();
		T lightest = iterator.next();
		
		while(iterator.hasNext()) {
			T next = iterator.next();
			
			if(next.getWeight() < lightest.getWeight())
				lightest = next;
		}
		
		return lightest;
	} 
	
	public static <T extends Portable> List<T> leftSublist(List<T> collection){
		return collection.subList(0, collection.size()/2);
	}
}
