package brickBracker;

import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.BasicStroke;




public class MapGenerator {
	
	private BufferedImage img;
	
	
	public int map[][];
	public int brickWidth;
	public int brickHeight;
	public MapGenerator(int row, int col) {
		importImag();
		map = new int [row][col];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j< map[0].length; j++) {
				map [i][j] = 1;
			}
		}
		
		
		brickWidth = 540/col;
		brickHeight = 150/row;
	}
	public void draw(Graphics2D g) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j< map[0].length; j++) {
				if(map[i][j] > 0) {
					g.setColor(Color.white);
					g.drawImage(img , j * brickWidth + 80, i * brickHeight + 50, null);
					
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.black);
					g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
				}
			}
		}
	}
	public void setBrickValue(int value, int row, int col) {
		map[row][col] = value;
	}
	private void importImag() {
		InputStream is = getClass().getResourceAsStream("bricks.png");
		try {
		this.img = ImageIO.read(is);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
