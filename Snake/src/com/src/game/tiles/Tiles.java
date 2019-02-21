package com.src.game.tiles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.src.game.Game;


public class Tiles {

	private int x, y;
	private int velX = 0, velY = 0;
	
	private final int WIDTH = Game.WIDTH / TileManager.BOARD_WIDTH; 
	private	final int HEIGHT = Game.HEIGHT / TileManager.BOARD_HEIGHT;
	public Rectangle hitBox;
	
	
	private int count;
	public Color color;
	
	public Tiles(int x, int y, Color color, int count) {
		this.x = x * WIDTH;
		this.y = y * HEIGHT;
		this.color = color;
		this.count = count;
		hitBox = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
	}
	
	public void update() {
		x += velX;
		y += velY;
	}
	
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public int getWidth() {
		return WIDTH;
	}
	
	public int getHeight() {
		return HEIGHT;
	}
	
	public Rectangle getHitBox() {
		return hitBox;
	}
	
}
