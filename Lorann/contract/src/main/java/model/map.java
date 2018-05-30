package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class map 
{
	//Sprite
	private final obstacle Bone = new obstacle("/bone.png");
		
	private final obstacle H_Bone = new obstacle("/horizontal_bone.png");
		
	private final obstacle V_Bone = new obstacle("/vertical_bone.png");

	private final obstacle Nothing = new obstacle("/void.png");
		
	private final obstacle closeGate = new obstacle("/gate_closed.png");
	
	File f = new File("annex/MAP2.txt");
    FileReader fileReader;
    public char choice;
    public char mapRead[][] = new char[width][height];
    private final static int height = 12;
	private final static int width = 20;
    
    
	public void readMap()
	{
		try
	    {
	        fileReader = new FileReader(f);
	    }
	    catch (FileNotFoundException exception)
	    {
	        System.out.println("File not found");
	    }
	    //Lecture
	    try
	    {
	        int c = 0;
	        for (int y = 0; y < height ; y++) 
	        {
	            for (int x = 0; x < width; x++) 
	            {
	            	c = fileReader.read();
	            	choice = (char)c;
	            	switch (choice) 
	            	{
	        		case 'B' :
	        			mapRead[x][y] = 'B';
	        			break;
	        			
	        		case 'H' : 
	        			mapRead[x][y] = 'H';
	        			break;
	        			
	        		case 'V' : 
	        			mapRead[x][y] = 'V';
	        			break;
	        		
	        		case 'N' : 
	        			mapRead[x][y] = 'N';
	        			break;
	        			
	        		case 'C' :
	        			mapRead[x][y] = 'C';
	        			break;
	            	}
	            }
	        }
	    }
	    catch (IOException exception)
	    {
	        System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
	    }
	}
	 public static int getHeight() {
			return height;
		}


		public static int getWidth() {
			return width;
		}
		public obstacle getBone() {
			return Bone;
		}
		public obstacle getH_Bone() {
			return H_Bone;
		}
		public obstacle getV_Bone() {
			return V_Bone;
		}
		public obstacle getNothing() {
			return Nothing;
		}
		public obstacle getCloseGate() {
			return closeGate;
		}
}
