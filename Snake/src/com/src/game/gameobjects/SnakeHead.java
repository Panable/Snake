package com.src.game.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import com.src.game.tiles.TileManager;
import com.src.game.tiles.Tiles;

public class SnakeHead {

	public static final Color FRUIT_COLOR = Color.CYAN;
	public static final Color SNAKEHEAD_COLOR = Color.WHITE;
	public static final Color BODY_COLOR = Color.BLUE;
	private Direction dir = Direction.UNDEFINED;
	
	public LinkedList<SnakeBody> body = new LinkedList<SnakeBody>();
	
	private int velX = 0, velY = 0;
	
	public static int currentTile = 5;
	public static int fruitTile = 0;
	
	TileManager tm;
	
	public SnakeHead(TileManager tm) {
		this.tm = tm;
		generateFruit();
	}
	
	public void move() {
		currentTile += velX;
		currentTile += TileManager.BOARD_WIDTH * velY;
		
	}
	
	public void collision() {
		if (tm.findTileNumber(currentTile).hitBox.intersects(tm.findTileNumber(fruitTile).hitBox)) {
			System.out.println("collision detected");
		}
	}
	
	
	
	int timer = 0;	
	public void update() {
		if ((timer % 20) == 0) {
			move();
		}
		collision();
		timer++;
	}
	
	public void render(Graphics g) {
		tm.clear();
		tm.findTileNumber(currentTile).setColor(SNAKEHEAD_COLOR);
		tm.findTileNumber(fruitTile).setColor(FRUIT_COLOR);
	}
	
	public Tiles getSnakeTile() {
		return tm.findTileNumber(currentTile);
	}
	
	public void setVelX(int num) {
		velX = num;
	}
	
	public void setVelY(int num) {
		velY = num;
	}
	
	public enum Direction {
		NORTH, SOUTH, EAST, WEST, UNDEFINED;
	}
	
	public void generateFruit() {
		Random random = new Random();
		fruitTile = random.nextInt(TileManager.BOARD_HEIGHT * TileManager.BOARD_HEIGHT);
		
		while (fruitTile == SnakeHead.currentTile) {
			fruitTile = random.nextInt(TileManager.BOARD_HEIGHT + TileManager.BOARD_HEIGHT);
		}
		
		tm.findTileNumber(fruitTile).setColor(FRUIT_COLOR);
		
	}

	public Direction getDir() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}
	
	
	
}