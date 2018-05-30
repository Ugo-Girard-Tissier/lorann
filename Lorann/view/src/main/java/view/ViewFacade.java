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
public class ViewFacade implements IView
{
	private static final int width = 20;
	
	private static final int height = 12;
	
	private static final int timeLoop = 300;
	
	private static final int sizeFrameWidth = 1280;
	
	private static final int sizeFrameHeight = 768;
	
	
	private static final Rectangle lorannGame = new Rectangle(0 ,0 ,width ,height);
	
	 //Obstacles
	private final obstacle Bone = new obstacle("/bone.png");
	
	private final obstacle H_Bone = new obstacle("/horizontal_bone.png");
	
	private final obstacle V_Bone = new obstacle("/vertical_bone.png");
	
	private final obstacle Nothing = new obstacle("void.png");
	
	File f = new File("annex/MAP1.txt");
    FileReader fileReader;
    public char choice;
    public char mapRead[][] = new char[20][12];

    /**
     * Instantiates a new view facade.
     */
    public ViewFacade() throws IOException
    {
        super();
        this.Bone.loadImage();
        this.H_Bone.loadImage();
        this.V_Bone.loadImage();
        ReadMap();
    }
    public void run() 
    {
        final BoardFrame boardFrame = new BoardFrame("LORANN GAME");
        boardFrame.setDimension(new Dimension(width, height));
        boardFrame.setDisplayFrame(lorannGame);
        boardFrame.setSize(sizeFrameWidth, sizeFrameHeight);
        boardFrame.setLocationRelativeTo(null);
        
        //Frame Configure
        this.frameConfigure(boardFrame);
    }
    public final void ReadMap()
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
                	}
                }
            }
        }
        catch (IOException exception)
        {
            System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
        }
    }
    public final void frameConfigure(final BoardFrame frame) 
    {
		
    	for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++)
            {
            	switch(mapRead[x][y])
            	{
            		case 'B':
            			frame.addSquare(Bone, x, y);
            			break;
            		case 'H':
            			frame.addSquare(H_Bone, x, y);
            			break;
            		case 'V':
            			frame.addSquare(V_Bone, x, y);
            			break;
            		case 'N':
            			frame.addSquare(Nothing, x, y);
        				break;
            	}
            }
        }
        frame.setVisible(true);
    }
	

}
