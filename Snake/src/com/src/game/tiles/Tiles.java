package com.src.game.tiles;

import java.awt.Color;
import java.awt.Graphics;

import com.src.game.Game;
import com.src.game.Vector2f;


public class Tiles {

	private int x, y;
	private Color color;
	private final int WIDTH = Game.WIDTH / TileManager.BOARD_WIDTH; 
	private	final int HEIGHT = Game.HEIGHT / TileManager.BOARD_HEIGHT;


	private Vector2f Pos;
	
	public Tiles(int x, int y, Color color) {
		this.x = x * Game.WIDTH / WIDTH;
		this.y = y * Game.HEIGHT / HEIGHT;
		Pos = new Vector2f(this.x, this.y, WIDTH, HEIGHT);
	}
	
	public void lol() {}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}

	public Color getColor() {
		return color;
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
	
}
