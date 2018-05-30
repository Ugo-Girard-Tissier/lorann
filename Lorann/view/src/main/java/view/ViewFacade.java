package view;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import showboard.BoardFrame;
import model.*;



/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Sulyven, Enzo, Abdel, Arthur and Ugo group
 * @version 1.0
 */
public class ViewFacade implements IView, Runnable
{
	private static final int width = 20;
	
	private static final int height = 12;
	
	private static final int timeLoop = 300;
	
	private static final int sizeFrameWidth = 448;
	
	private static final int sizeFrameHeight = 384;
	
	
	private static final Rectangle lorannGame = new Rectangle(0 ,0 ,width ,height);
	
	 //Obstacles
	private final obstacle Bone = new obstacle("/bone.png");
	
	private final obstacle H_Bone = new obstacle("/horizontal_bone.png");
	
	private final obstacle V_Bone = new obstacle("/vertical_bone.png");
	
	
	private IMap map;
	
	private int Hight_txt = 12;
	private int Width_txt = 20;
	
	File f = new File("annex/MAP1.txt");
    FileReader fileReader;
    public char choice;

    /**
     * Instantiates a new view facade.
     */
    public ViewFacade(IMap map) throws IOException
    {
        super();
        this.Bone.loadImage();
        this.H_Bone.loadImage();
        this.V_Bone.loadImage();
        SwingUtilities.invokeLater(this);
        this.setMap(map);
    }
    public void run() 
    {
        final BoardFrame boardFrame = new BoardFrame("LORANN GAME");
        boardFrame.setDimension(new Dimension(width, height));
        boardFrame.setDisplayFrame(lorannGame);
        boardFrame.setSize(sizeFrameWidth, sizeFrameHeight);
        
        //Frame Configure
        this.frameConfigure(boardFrame);
        
        /*this.getMap().getObservable().addObserver(boardFrame.getObserver());
        boardFrame.setVisible(true);
        for (int y = 0; y < map.getHight();y++) 
		{
			for (int x = 0; x < map.getWidth();x++) 
			{
				map.setSquare(x,y);
				if (map.getSquare() == null)
		        {
		        	System.out.println("null");
		        }
				boardFrame.addSquare(map.getSquare(), x, y);
			}
		}
        boardFrame.getDisplayFrame();*/
    }
    public final void frameConfigure(final BoardFrame frame) 
    {
		/*try
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
	        			frame.addSquare(this.Bone, x, y);
	        			break;
	        			
	        		case 'H' : 
	        			frame.addSquare(this.H_Bone, x, y);
	        			break;
	        			
	        		case 'V' : 
	        			frame.addSquare(this.V_Bone, x, y);
	        			break;
	        		
	        		case 'N' : 
	        			
	        			break;
                	}
                }
            }
        }
        catch (IOException exception)
        {
            System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
        }*/
    	for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if ((x == 0) || (x == (width - 1)) || (y == 0) || (y == (height - 1))){
                    frame.addSquare(this.Bone, x, y);
                } else if (((x + y) % 4) == 0) {
                    frame.addSquare(this.H_Bone, x, y);
                } else {
                    frame.addSquare(this.V_Bone, x, y);
                }
            }
        }
        frame.setVisible(true);
    }
	
	public IMap getMap() 
	{
		return map;
	}
	public void setMap(IMap map) 
	{
		this.map = map;
	}
	

}
