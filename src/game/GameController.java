package game;

import java.awt.Image;
import java.awt.Polygon;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Random;
import java.util.Scanner;

import graphics.GameFrame;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import player.Player;
import controller.PolygonMap;
import controller.TerritoryMap;
import board.Territory;

public class GameController implements GameControllerInterface {

    private GameViewInterface view;
    private GameModelInterface model;
    private Scanner in;
    private List<Polygon> polygons;
    private List<Territory> territories;
    private Map<Polygon, Territory> ptmap;
    private Map<Territory, Polygon> tpmap;
    private Image image;
    private Player activePlayer;
    private Territory selectedTerritory;

    public GameController(GameModelInterface model) {
        polygons = new ArrayList<Polygon>();
        territories = new ArrayList<Territory>();
        ptmap = new TerritoryMap();
        tpmap = new PolygonMap();
        try {
            image = ImageIO.read(ClassLoader
                    .getSystemResourceAsStream("map.jpg"));
            in = new Scanner(ClassLoader.getSystemResourceAsStream("map.data"));
        } catch (IOException e) {
            //
        }

        while (in.hasNext()) {
            Polygon temp1 = null;
            Territory temp2 = null;
            int polys = in.nextInt();
            in.nextLine();
            for (int i = 0; i < polys; i++) {
                String name = in.nextLine();
                int points = in.nextInt();

                temp1 = new Polygon();
                temp2 = new Territory(name);

                for (int j = 0; j < points; j++) {
                    temp1.addPoint(in.nextInt(), in.nextInt());
                }
                in.nextLine();

                polygons.add(temp1);
                territories.add(temp2);
                ptmap.put(temp1, temp2);
                tpmap.put(temp2, temp1);
            }
            for (int i = 0; i < polys; i++) {
                int neighbors = in.nextInt();
                for (int j = 0; j < neighbors; j++) {
                    territories.get(i).addNeighbor(territories.get(in.nextInt()));
                }
                in.nextLine();
            }
        }

        view = new GameFrame(this, model);
        view.setMapBackground(image);
        view.setPolygons(polygons);
    }

    @Override
    public void selectPolygon(Polygon p) {
        Territory t = ptmap.get(p);
        selectedTerritory = t;
        view.updateTerritoryView(t);
    }

    @Override
    public void setActivePlayer(Player p) {
        this.activePlayer = p;
        view.updatePlayerView(p);
    }

    @Override
    public Player getActivePlayer() {
        return this.activePlayer;
    }

    @Override
    public void quitGame() {
        view.quitGame();
    }

    @Override
    public void addPlayerToMap(Player p) {
        if (p.getLocation() == null) {
            Random rnd = new Random();
            Integer r = rnd.nextInt(14);
            Territory t = territories.get(r);
            t.addPlayer(p);
            p.setLocation(t);
            selectPolygon(tpmap.get(t));
            togglePolygon(tpmap.get(t));
        }
        else
            throw new UnsupportedOperationException("Player already on map.");
    }

    @Override
    public void togglePolygon(Polygon p) {
        view.togglePolygon(p);
    }

    @Override
    public Territory getSelectedTerritory() {
        return selectedTerritory;
    }

    @Override
    public Iterator<Territory> getTerritoryNeighbors(Territory t) {
        return t.getNeighbors();
    }

    @Override
    public void movePlayer(Player p, Territory to) throws UnsupportedOperationException {
        for (Iterator<Territory> t = p.getLocation().getNeighbors(); t.hasNext(); ) {
            if (t.next() == to) {
                p.getLocation().removePlayer(p);
                p.setLocation(to);
                to.addPlayer(p);
                view.updatePlayerView(p);
                view.updateTerritoryView(to);
                break;
            }
        }
        if (p.getLocation() != to)
            throw new UnsupportedOperationException("Can only move to neighboring territories.");
    }

    @Override
    public Iterator<Territory> getTerritories() {
        return territories.iterator();
    }
}
