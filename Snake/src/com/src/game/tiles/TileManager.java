package com.src.game.tiles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

public class TileManager {

	public static final int BOARD_WIDTH = 32;
	public static final int BOARD_HEIGHT = 32;
	
	LinkedList<Tiles> tile = new LinkedList<Tiles>();
	
	public TileManager() {
		int count = 1;
		for (int y = 0; y < BOARD_HEIGHT; y++) {
			for (int x = 0; x < BOARD_WIDTH; x++) {
				tile.add(new Tiles(x, y, Color.BLACK, count));
				count++;
				System.out.println(count);
			}
		}
	}
	
	public void update() {
		Random r = new Random();
		int red = r.nextInt(255);
		int green = r.nextInt(255);
		int blue = r.nextInt(255);
		
		for (int i = 0; i < tile.size(); i++) {
			Tiles tempTile = tile.get(i);
			if (tempTile.getCount() == 5) {
				tempTile.setColor(new Color(red, green, blue));
			}
		}
		
	}
	
	
	public void render(Graphics g) {
		for (int i = 0; i < tile.size(); i++) {
			Tiles tempTile = tile.get(i);
			tempTile.render(g);
		}
	}
	
	

}
