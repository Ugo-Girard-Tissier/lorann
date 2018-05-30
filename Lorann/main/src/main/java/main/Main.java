package main;

import java.io.IOException;
import java.sql.SQLException;

import controller.ControllerFacade;
import model.IModel;
import model.ModelFacade;
import model.map;
import model.obstacle;
import showboard.BoardFrame;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Abdel, Arthur, Enzo, Sulyven and Ugo group
 * @version 1.0
 */
public abstract class Main 
{

	//test git git
	
	
    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws IOException 
     */
    public static void main(final String[] args) throws IOException 
    {
    	final IModel model = new ModelFacade();
    	final ViewFacade view = new ViewFacade();
        final ControllerFacade controller = new ControllerFacade(view, model);
        
        try 
        {
            controller.start();
        } 
        catch (final SQLException exception) 
        {
            exception.printStackTrace();
        }
    }

}
