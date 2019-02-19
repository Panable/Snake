package com.src.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.src.game.tiles.TileManager;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 512;
	public static final int HEIGHT = 512;
	
	private boolean running = false;
	
	private JFrame frame;
	private Thread thread;
	
	private TileManager tm;
	private SnakeHead head;
	
	public void Window() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setTitle("");
		frame.setVisible(true);
	}
	
	public Game() {
		Dimension size = new Dimension (WIDTH, HEIGHT);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);
		Window();
		
		tm = new TileManager();
		head = new SnakeHead(tm);
		
		start();
	}
	
	public synchronized void start() {
		running = true;
		
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double updates = 10.0;
		double ns = 1000000000 / updates;
		double delta = 0;
		long timer = System.currentTimeMillis();

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				delta--;
			}

			if (running)
				render();

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
			}
		}

		stop();
	}
	
	private void update() {
		tm.update();
	}
	
	private void render() {
		BufferStrategy bs  = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		tm.render(g);
		head.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		new Game();
	}

	
	
}
