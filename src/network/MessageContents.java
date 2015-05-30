package network;

import java.util.List;

import player.InventoryMap;

public class MessageContents {
	private List<InventoryMap.Entry> items;
	private String text;

	public MessageContents(String text, List<InventoryMap.Entry> items) {
		this.text = text;
		this.items = items;
	}
}
