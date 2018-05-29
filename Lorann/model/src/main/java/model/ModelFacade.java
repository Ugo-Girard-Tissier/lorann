package model;

import java.sql.SQLException;
import java.util.List;
import model.IMap;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Sulyven, Enzo, Abdel, Arthur and Ugo group
 * @version 1.0
 */
public final class ModelFacade implements IModel
{
	private IMap map;
    /**
     * Instantiates a new model facade.
     */
    public ModelFacade() 
    {
       this.setMap(new map());
       this.getMap().createMap();
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
