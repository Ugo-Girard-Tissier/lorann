package model;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class obstacle {
	
	
	
	public Image img_ob; 
	int x, y;
	int Height = 32;
	int Widht = 32;
	public char img;
	
	
	public obstacle (char img_p) {
		
		this.img = img_p;
		
		switch (this.img) {
		
		case 'B' : 
		
			try {
				this.img_ob = ImageIO.read(getClass().getResourceAsStream("/bone.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			break;
			
		case 'H' : 
		
			try {
				this.img_ob = ImageIO.read(getClass().getResourceAsStream("/horizontal_bone.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			break;
		
			
		case 'V' : 
			
			try {
				this.img_ob = ImageIO.read(getClass().getResourceAsStream("/vertical_bone.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			break;
		
		}	
	}
	
	
}
