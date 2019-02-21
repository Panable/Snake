package com.src.game.gameobjects;

import java.awt.Color;
import java.util.Random;

import com.src.game.tiles.TileManager;

public class SnakeFruit {

	public static final Color FRUIT_COLOR = Color.CYAN;
	
	public void generateFruit(TileManager tm) {
		Random random = new Random();
		int randomTile = random.nextInt(TileManager.BOARD_HEIGHT * TileManager.BOARD_HEIGHT);
		
		while (randomTile == SnakeHead.currentTile) {
			randomTile = random.nextInt(TileManager.BOARD_HEIGHT * TileManager.BOARD_HEIGHT);
		}
		
		tm.findTileNumber(randomTile).setColor(FRUIT_COLOR);
		
	}
	
	
	
}
