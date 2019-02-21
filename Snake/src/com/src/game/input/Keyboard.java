package com.src.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.src.game.gameobjects.SnakeHead;
import com.src.game.gameobjects.SnakeHead.Direction;

public class Keyboard implements KeyListener{

	SnakeHead head;
	
	public Keyboard(SnakeHead head) {
		this.head = head;
	}
	
	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_UP) {
			if (head.getDir() != Direction.SOUTH ) {
			head.setVelY(-1);
			head.setVelX(0);
			head.setDir(Direction.NORTH);
			}
		}
		if (key == KeyEvent.VK_DOWN) {
			if (head.getDir() != Direction.NORTH) {
			head.setVelY(1);
			head.setVelX(0);
			head.setDir(Direction.SOUTH);
			}
		}
		if (key == KeyEvent.VK_LEFT) {
			if (head.getDir() != Direction.EAST) {
			head.setVelX(-1);
			head.setVelY(0);
			head.setDir(Direction.WEST);
			}
		}
		if (key == KeyEvent.VK_RIGHT) {
			if (head.getDir() != Direction.WEST) {
			head.setVelX(1);
			head.setVelY(0);
			head.setDir(Direction.EAST);
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		
	}

}
