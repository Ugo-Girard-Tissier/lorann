package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.List;

import model.IModel;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Sulyven, Enzo, Abdel, Arthur and Ugo group
 * @version 1.0
 */
public class ControllerFacade implements IController, KeyListener
{

    /** The view. */
    private final IView  view;
    /** The model. */
    private final IModel model;

    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
    }

    /**
     * Start.
     *
     * @throws SQLException
     *             the SQL exception
     * @throws InterruptedException 
     */
    public void start() throws SQLException, InterruptedException 
    {
    	this.getView().run();
    	//this.getView().move();
    	this.getView().getBoardFrame().addKeyListener(this);
    	this.getView().getBoardFrame().requestFocus();
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }

	@Override
	public void keyTyped(KeyEvent e) 
	{
			
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		int keyCode = e.getKeyCode();
		
		System.out.println(keyCode);

		
			//this.getModel().getMap().getLorann().animationLorann();
			//this.getView().updateMap();
		
		switch(keyCode)
		{
			case KeyEvent.VK_NUMPAD1:
				System.out.println(keyCode);
				this.getModel().getMap().getLorann().leftMouvementLorann();
				this.getView().updateMap();
				break;
			case KeyEvent.VK_NUMPAD2:
				System.out.println(keyCode);
				this.getModel().getMap().getLorann().backwardMouvementLorann();
				this.getView().updateMap();
				break;
			case KeyEvent.VK_NUMPAD3:
				System.out.println(keyCode);
				this.getModel().getMap().getLorann().rightMouvementLorann();
				this.getView().updateMap();
				break;
			case KeyEvent.VK_NUMPAD5:
				System.out.println(keyCode);
				this.getModel().getMap().getLorann().forwardMouvementLorann();
				this.getView().updateMap();
				break;
			case KeyEvent.VK_NUMPAD6:
				System.out.println(keyCode);
				this.getModel().getMap().getLorann().diagonalRightForwardMouvementLorann();
				this.getView().updateMap();
				break;
			case KeyEvent.VK_NUMPAD4:
				System.out.println(keyCode);
				this.getModel().getMap().getLorann().diagonalLeftForwardMouvementLorann();
				this.getView().updateMap();
				break;
			case KeyEvent.VK_E:
				System.out.println(keyCode);
				this.getModel().getMap().getLorann().diagonalRightBackwardMouvementLorann();
				this.getView().updateMap();
				break;
			case KeyEvent.VK_Z:
				System.out.println(keyCode);
				this.getModel().getMap().getLorann().diagonalLeftBackwardMouvementLorann();
				this.getView().updateMap();
				break;
			}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		
	}
}
