package com.DeadKeymon449.rain.graphics;

import java.util.Random;

public class Screen {

	private int width, height;
	public int[] pixels;
	
	public final int mapSize = 64;
	public final int mapSizeMask = mapSize - 1;
	
	public int[] tiles = new int[mapSize * mapSize];
	private Random random = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;

		pixels = new int[width * height];

		for (int i = 0; i < mapSize * mapSize; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void render(int offsetX, int offsetY) {
		for (int y = 0; y < height; y++) {
			int yPos = y + offsetY;

//			if (yPos < 0 || yPos >= height) break;

			for (int x = 0; x < width; x++) {
				int xPos = x + offsetX;

//				if (xPos < 0 || xPos >= width) break;
				
				int tileIndex = ((xPos >> 4) & mapSizeMask) + ((yPos >> 4) & mapSizeMask) * mapSize;

				pixels[x + y * width] = tiles[tileIndex];
			}
		}
	}
}
