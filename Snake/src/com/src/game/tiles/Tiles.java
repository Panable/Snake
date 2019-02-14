package com.src.game.tiles;

import java.awt.Color;
import java.awt.Graphics;

import com.src.game.Game;
import com.src.game.Vector2f;


public class Tiles {

	private int x, y;
	private final int WIDTH = Game.WIDTH / TileManager.BOARD_WIDTH; 
	private	final int HEIGHT = Game.HEIGHT / TileManager.BOARD_HEIGHT;
	private int count;
	public Color color;
	private Vector2f Pos;
	
	public Tiles(int x, int y, Color color, int count) {
		this.x = x * WIDTH;
		this.y = y * HEIGHT;
		this.color = color;
		this.count = count;
		Pos = new Vector2f(this.x, this.y, WIDTH, HEIGHT);
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
	
	public Vector2f getPos() {
		return Pos;
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
	
}
