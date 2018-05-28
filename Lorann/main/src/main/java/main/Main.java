package main;

import java.sql.SQLException;

import controller.ControllerFacade;
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
public abstract class Main {

	//test git git
	
	
    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
 
    	
    	BoardFrame fr = new BoardFrame ("test", false);
    	
    	
        final ControllerFacade controller = new ControllerFacade(new ViewFacade(), new ModelFacade());
        
        try {
            controller.start();
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
    }

}
