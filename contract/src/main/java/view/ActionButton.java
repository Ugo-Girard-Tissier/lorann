package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class ActionButton extends JButton implements MouseListener {

	
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int choice = 0;
	

	public ActionButton (String str, int i, int y) {
		
		super (str);
		this.setFont(new Font("Serif", Font.PLAIN, 40));
		this.setBounds(i, y, 250, 100);
		this.setBackground(Color.orange);
		this.addMouseListener(this);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		this.setBackground(Color.red);
		this.setChoice(1);
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		this.setBackground(Color.green);
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		this.setBackground(Color.orange);
		
	}
	
	
	public int getChoice() {
		return choice;
	}



	public void setChoice(int choice) {
		this.choice = choice;
	}
		
}
