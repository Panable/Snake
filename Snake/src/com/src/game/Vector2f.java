package com.src.game;
import java.awt.Rectangle;

public class Vector2f {

	public int x, y, width, height;

	public Vector2f(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public static boolean isIntercept(Vector2f obj1, Vector2f obj2) {
		Rectangle box1, box2;
		box1 = new Rectangle(obj1.getX(), obj1.getY(), obj1.getWidth(), obj1.getHeight());
		box2 = new Rectangle(obj2.getX(), obj2.getY(), obj2.getWidth(), obj2.getHeight());

		if (box1.intersects(box2))
			return true;
		else
			return false;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
