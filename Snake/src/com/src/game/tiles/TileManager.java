package com.src.game.tiles;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import com.src.game.gameobjects.SnakeHead;

public class TileManager {

	public static final int BOARD_WIDTH = 32;
	public static final int BOARD_HEIGHT = 32;
	
	public static final Color DEFUALT_COLOR = Color.BLACK;
	
	public LinkedList<Tiles> tile = new LinkedList<Tiles>();
	
	int count = 0;
	public TileManager() {
		for (int y = 0; y < BOARD_HEIGHT; y++) {
			for (int x = 0; x < BOARD_WIDTH; x++) {
				tile.add(new Tiles(x, y, DEFUALT_COLOR, count));
				count++;
			}
		}
	}
	
	public void update() {
		for (int i = 0; i < tile.size(); i++) {
			Tiles tempTile = tile.get(i);
			tempTile.update();
		}
		
	}
	
	
	public void render(Graphics g) {
		for (int i = 0; i < tile.size(); i++) {
			Tiles tempTile = tile.get(i);
			tempTile.render(g);
		}
	}
	
	public void clear() {
		for (int i = 0; i < tile.size(); i++) {
			Tiles tempTile = tile.get(i);
			tempTile.setColor(DEFUALT_COLOR);
		}
	}
	
	public Tiles findTileNumber(int count) {
		for (int i = 0; i < tile.size(); i++) {
			Tiles tempTile = tile.get(i);
			if (tempTile.getCount() == count) {
				return tempTile;
			}
			}
		return null;
	}
	
	
	public boolean isSnake(Tiles tile) {
		if (tile == findTileNumber(SnakeHead.currentTile))
			return true;
		else
			return false;
	}
	

}
