/**
 * COMP 3716 Final Project: Happiness.java
 * 
 * Group 8:
 *  - Chris Babstock (200152353)
 *  - Stephen Brinson (200838720)
 *  - Jarret Kolanko (200858181)
 *  - Christopher Healey (201034766)
 */
package player;

import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author Group 8
 * 
 */
public class Happiness {

	HappinessMap meters;

	public Happiness(List<Integer> v) {
		meters = new HappinessMap();
		for (int i = 0; i < HappinessType.values().length; i++) {
			meters.put(HappinessType.values()[i],
					Arrays.asList(new Integer[] { v.get(i), 0 }));
		}
	}

	public Set<Entry<HappinessType, List<Integer>>> getMeters() {
		return meters.entrySet();
	}

	/**
	 * A list of valid happiness types
	 */
	public enum HappinessType {
		WEALTH, POWER, SOLITUDE;
		/**
		 * @return list of all valid happiness types
		 */
		public static List<HappinessType> getValues() {
			return Arrays.asList(HappinessType.values());
		}
	}
}
