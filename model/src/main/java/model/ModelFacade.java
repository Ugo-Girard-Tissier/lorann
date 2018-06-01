package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Sulyven, Enzo, Abdel, Arthur and Ugo group
 * @version 1.0
 */
public final class ModelFacade implements IModel
{
	private map Map;
	LorannDAO DAO;
	
	/**
     * Instantiates a new model facade.
	 * @throws IOException 
     */
	public ModelFacade() throws IOException, SQLException 
    {
        super();
        this.DAO = new LorannDAO();
        this.DAO.open();
        this.Map = new map(this.DAO.getMAp(5));
        this.DAO.close();
    }
	
    public map getMap() 
    {
		return Map;
	}
	public void setMap(map map)
	{
		Map = map;
	}
}
