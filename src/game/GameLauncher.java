package game;

import java.util.Iterator;

import graphics.*;

import javax.swing.JFrame;

import board.Territory;

public class GameLauncher {
	public static void main(String[] args) {
        GameModelInterface model = new Game();
        GameControllerInterface controller = new GameController(model);
        
        for (Iterator<Territory> t = controller.getTerritories(); t.hasNext(); ) {
            Territory temp = t.next();
            System.out.println(temp.getName());
            System.out.println("Neighbors:");
            for (Iterator<Territory> k = temp.getNeighbors(); k.hasNext(); ) {
                Territory temp2 = k.next();
                System.out.println(temp2.getName());
            }
            System.out.println("-------------");
        }
    }
}
