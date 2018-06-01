package view;

import java.awt.*;
import java.io.IOException;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import showboard.BoardFrame;
import model.*;



/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Sulyven, Enzo, Abdel, Arthur and Ugo group
 * @version 1.0
 */
public class ViewFacade extends Observable implements IView, Runnable
{

	private static final int timeLoop = 100;
	
	private static final int sizeFrameWidth = 1280;
	
	private static final int sizeFrameHeight = 768;
	
	private static final Rectangle lorannGame = new Rectangle(0 ,0 ,map.getWidth(),map.getHeight());
	
	private IModel model;
	
	private BoardFrame boardFrame;
	
	private int stop = 0;
    
	/**
     * Instantiates a new view facade.
     */
    public ViewFacade(IModel model) throws IOException
    {
        super();
        this.model = model;
        this.model.getMap().getBone().loadImage();
        this.model.getMap().getH_Bone().loadImage();
        this.model.getMap().getV_Bone().loadImage();
        this.model.getMap().getNothing().loadImage();
        this.model.getMap().getCloseGate().loadImage();
        this.model.getMap().getLorann().loadImage();
        this.model.getMap().getMonster1().loadImage();
        this.model.getMap().getPurse().loadImage();
        this.model.getMap().getCrystallBall().loadImage();
        this.model.getMap().getOpenGate().loadImage();
    }
    public void run() 
    {
        this.boardFrame = new BoardFrame("LORANN GAME");
        boardFrame.setDimension(new Dimension(map.getWidth(), map.getHeight()));
        boardFrame.setDisplayFrame(lorannGame);
        boardFrame.setSize(sizeFrameWidth, sizeFrameHeight);
        boardFrame.setLocationRelativeTo(null);
        //Frame Configure
        this.frameConfigure(boardFrame);
    }
       
  
    public final void frameConfigure(final BoardFrame frame) 
    {
		
    	for (int y = 0; y < map.getHeight(); y++) {
            for (int x = 0; x < map.getWidth(); x++)
            {
            	switch(model.getMap().mapRead[x][y])
            	{
            		case 'B':
            			frame.addSquare(model.getMap().getBone(), x, y);
            			break;
            		case 'H':
            			frame.addSquare(model.getMap().getH_Bone(), x, y);
            			break;
            		case 'V':
            			frame.addSquare(model.getMap().getV_Bone(), x, y);
            			break;
            		case 'N':
            			frame.addSquare(model.getMap().getNothing(), x, y);
        				break;
            		case 'G':
            			frame.addSquare(model.getMap().getCloseGate(), x, y);
        				break;
            		case 'P':
            			frame.addSquare(model.getMap().getPurse(), x, y);
    					break;
            		case 'C':
            			frame.addSquare(model.getMap().getCrystallBall(), x, y);
            			break;
            	}
            }
            frame.addPawn(this.model.getMap().getLorann());
            frame.addPawn(this.model.getMap().getMonster1());
        }
    	
    	this.addObserver(frame.getObserver());
        frame.setVisible(true);
    }
    
    public BoardFrame getBoardFrame() {
		return boardFrame;
	}
	public void setBoardFrame(BoardFrame boardFrame) {
		this.boardFrame = boardFrame;
	}
	
	public int getStop() {
		return stop;
	}
	public void setStop(int stop) {
		this.stop = stop;
	}
    
	public void updateMap()
	{
		this.setChanged();
        this.notifyObservers();
	}
	
	public void OpenGate(int x, int y)
	{
		int numberOfCrystallBall = this.model.getMap().getNumberOfCrystallBall();
		if (this.model.getMap().mapRead[x][y] == 'C')
		{
			getBoardFrame().addSquare(model.getMap().getNothing(), x, y);
			this.model.getMap().updateElementsOnMap(x,y);
			numberOfCrystallBall = numberOfCrystallBall - 1;
			this.model.getMap().setNumberOfCrystallBall(numberOfCrystallBall);
			if (numberOfCrystallBall == 0)
			{
				this.updateMapElements("gateopen", x, y);
			}
		}
	}
	
	public void getPurse(int x, int y)
	{
		if (this.model.getMap().mapRead[x][y] == 'P')
		{
			this.updateMapElements("purse", x, y);
			this.model.getMap().updateElementsOnMap(x,y);
			int scoreLorann = this.model.getMap().getScoreLorann();
			scoreLorann = scoreLorann + 650;
			this.model.getMap().setScoreLorann(scoreLorann);
		}
	}
	
	public void reachingOpenGate(int x,int y)
	{
		ImageIcon winIcon = new ImageIcon("annex/reward.png");
		if (this.model.getMap().mapRead[x][y] == 'O')
		{
			getBoardFrame().dispose();
			JOptionPane.showMessageDialog(null, "You Win !!!\nYour score : " + this.model.getMap().getScoreLorann(),"Congratulation !!!", JOptionPane.INFORMATION_MESSAGE, winIcon);
			this.setStop(1);
		}
	}
	
	public void reachingThreat(int x, int y)
	{
		ImageIcon loseIcon = new ImageIcon("annex/game_over.png");
		if (this.model.getMap().mapRead[x][y] == 'G' && (this.model.getMap().getLorann().getX() == this.model.getMap().getMonster1().getStartX()))
		{
			getBoardFrame().dispose();
			JOptionPane.showMessageDialog(null, "Unfortunately... You Lose..\nYour score : "+ this.model.getMap().getScoreLorann(), "Too Bad...", JOptionPane.INFORMATION_MESSAGE, loseIcon);
			this.setStop(1);
		}
	}
	
	public void updateMapElements(String Elements,int x,int y)
	{
		switch(Elements)
		{
			case "gateopen":
				for (int yMap = 0; yMap < map.getHeight(); yMap++) 
				{
		            for (int xMap = 0; xMap < map.getWidth(); xMap++)
		            {
		            	if(model.getMap().mapRead[xMap][yMap] == 'G')
		            	{
		            		x = xMap;
		            		y = yMap;
		            		this.model.getMap().updateGateOnMap(xMap, yMap);
		            		getBoardFrame().addSquare(model.getMap().getOpenGate(), x, y);
		            	}
		            }
				}
				break;
			case "purse":
				getBoardFrame().addSquare(model.getMap().getNothing(), x, y);
				break;
		}
	}
	
}
