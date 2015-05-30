package network;

import player.Player;

public class Message {
	
	private Player sender, receiver;
	private MessageContents message;
	
	public Message() {
		
	}
	
	public Message(Player from, Player to, MessageContents message) {
		this.sender = from;
		this.receiver = to;
		this.message = message;
	}
	
	public Player getSender() { return sender; }
	public Player getReceiver() { return receiver; }
	public MessageContents getMessage() { return message; }
	
}
