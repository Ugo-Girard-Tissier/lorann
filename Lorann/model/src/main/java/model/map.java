package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class map {

	
	int Hight;
	int Width;
	
	File f = new File("/MAP1.txt");
    FileReader fileReader;
    public char choice;
	
	public obstacle mapObstacle [][];
	
	
	
	
	public map () {
		this.mapObstacle = new obstacle [Width] [Hight];
		
		for (int y = 0; y < Hight; y++) {
			
			for (int x = 0; x < Width; x++) {
				
				this.mapObstacle [x] [y] = null;
			}
		}
	}
	
	
	public void createMap () {
		
    	int x = 0;
    	int y = 0;
		
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
            while  ((c = fileReader.read()) != -1)
            {
            	
            	if (x == this.Width) {
            		y++;
            		x=0;
            	}	
            	
                //Message += (char)c;
                choice = (char)c;
               
        		switch (choice) {
        		
	        		case 'B' :
	        			this.mapObstacle [x] [y] = new obstacle ('B');
	        			break;
	        			
	        		case 'H' : 
	        			this.mapObstacle [x] [y] = new obstacle ('H');
	        			break;
	        			
	        		case 'V' : 
	        			this.mapObstacle [x] [y] = new obstacle ('V');
	        			break;
	        		
	        		case 'N' : 
	        			this.mapObstacle [x] [y] = new obstacle ('N');
	        			break;
        		}
                x++;
            }
        }
        catch (IOException exception)
        {
            System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
        }
		
		
		
		
		
		
		
	}
	
	
	
}
