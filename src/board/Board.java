/**
 * COMP 3716 Final Project: Board.java
 * 
 * Group 8:
 *  - Chris Babstock (200152353)
 *  - Stephen Brinson (200838720)
 *  - Jarret Kolanko (200858181)
 *  - Christopher Healey (201034766)
 */
package board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Group 8
 * 
 */
public class Board {

	private List<Territory> territories;
	//private List<List<Tile>> rows;

	public Board(List<Territory> territories) {
		this.territories = territories;
	}

	/**
	 * @return number of rows of Tile objects on this Board
	 */

	public Iterator<Territory> getTerritories() {
		return territories.iterator();
	}
}
