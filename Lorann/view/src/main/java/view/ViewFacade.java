package view;

import java.awt.*;

import javax.swing.JOptionPane;

import showboard.BoardFrame;
import model.IMap;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Sulyven, Enzo, Abdel, Arthur and Ugo group
 * @version 1.0
 */
public class ViewFacade implements IView
{
	private Rectangle View;
	private IMap map;

    /**
     * Instantiates a new view facade.
     */
    public ViewFacade(IMap map) 
    {
        super();
        this.setMap(map);
        this.setView(new Rectangle(0, 0 , 400, 400));
    }
    public void run() 
    {
        final BoardFrame boardFrame = new BoardFrame("LORANN GAME");
        boardFrame.setDimension(new Dimension(this.getMap().getWidth(),this.getMap().getHight()));
        boardFrame.setDisplayFrame(View);
        boardFrame.setSize(this.View.width, this.View.height);
        boardFrame.setHeightLooped(true);
        //boardFrame.addKeyListener(this);
        //boardFrame.setFocusable(true);
        //boardFrame.setFocusTraversalKeysEnabled(false);
        //boardFrame.addPawn(this.getMyVehicle());
        this.getMap().getObservable().addObserver(boardFrame.getObserver());
        //this.followMyVehicle();
        boardFrame.setVisible(true);
    }
	public Rectangle getView()
	{
		return View;
	}
	public void setView(Rectangle view) 
	{
		View = view;
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
