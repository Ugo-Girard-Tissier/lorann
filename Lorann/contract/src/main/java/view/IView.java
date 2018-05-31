package view;

import showboard.BoardFrame;

/**
 * <h1>The Interface IView.</h1>
 *
 * @author Sulyven, Enzo, Abdel, Arthur and Ugo group
 * @version 1.0
 */
public interface IView 
{
	public void run();
	public void move() throws InterruptedException;
	public void updateMap();
	public BoardFrame getBoardFrame();
	public void setBoardFrame(BoardFrame boardFrame);
}
