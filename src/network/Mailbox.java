package network;

import java.util.ArrayList;
import java.util.List;

import player.Player;

/**
 * Representation of a player's message inbox.
 * @author Chris Babstock
 *
 */
public class Mailbox {
	
	private Player owner;
	private List<Message> contents;
	
	public Mailbox(Player owner) {
		this.owner = owner;
		this.contents = new ArrayList<Message>();
	}
	
	public Player getOwner() { return owner; }
	
	public void addMessage(Message msg) {
		this.contents.add(msg);
	}
	
	public void deleteMessage(Message msg) {
		this.contents.remove(msg);
	}

}
