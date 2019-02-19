package com.src.game;

import java.awt.Color;
import java.awt.Graphics;

import com.src.game.tiles.TileManager;
import com.src.game.tiles.Tiles;

public class SnakeHead {

	public static int currentTile = 5;
	
	TileManager tm;
	
	public SnakeHead(TileManager tm) {
		this.tm = tm;
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g) {
		tm.findTileNumber(currentTile).setColor(Color.WHITE);
	}
	
	public Tiles getSnakeTile() {
		return tm.findTileNumber(currentTile);
	}
	
	
}
