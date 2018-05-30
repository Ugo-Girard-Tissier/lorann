package model;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Observable;



import showboard.*;

public class map extends Observable implements IMap
{
	private ISquare square; 
	private static int Hight = 12;
	private static int Width = 20;
	File f = new File("annex/MAP1.txt");
    FileReader fileReader;
    public char choice;
	public obstacle mapObstacle [][];
	
	public map () 
	{
		this.mapObstacle = new obstacle [Width] [Hight];
		
		for (int y = 0; y < Hight;y++) 
		{
			for (int x = 0; x < Width;x++) 
			{
				this.mapObstacle [x] [y] = null;
			}
		}
	}
	
	
	public void createMap () 
	{
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
            	if (x == (this.Width)) 
            	{
    
            		y++;
            		x = 0;
            	}	
                choice = (char)c;
                //System.out.println("je suis en x = " + x + " et en y = " + y + " et je suis : " + choice);
        		switch (choice) {
        		
	        		case 'B' :
	        			//this.mapObstacle [x] [y] = new obstacle ('B');
	        			break;
	        			
	        		case 'H' : 
	        			//this.mapObstacle [x] [y] = new obstacle ('H');
	        			break;
	        			
	        		case 'V' : 
	        			//this.mapObstacle [x] [y] = new obstacle ('V');
	        			break;
	        		
	        		case 'N' : 
	        			//this.mapObstacle [x] [y] = new obstacle ('N');
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
	//Observable
	public Observable getObservable() 
	{
        return this;
    }
	public void setMapHasChanged() 
	{
        this.setChanged();
        this.notifyObservers();
    }


	public int getHight() 
	{
		return Hight;
	}


	public void setHight(int hight) 
	{
		Hight = hight;
	}


	public int getWidth() 
	{
		return Width;
	}


	public void setWidth(int width) 
	{
		Width = width;
	}


	public ISquare getSquare() {
		return square;
	}


	public void setSquare(int x,int y) 
	{
		this.square =  mapObstacle[x][y];
	}
}
