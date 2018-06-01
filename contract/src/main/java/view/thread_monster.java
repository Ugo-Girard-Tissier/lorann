package view;

import controller.IController;

public class thread_monster extends Thread
{
	IController controller;
	
	
	private final int loop = 300;
	
	
	public thread_monster (String name, IController controller_p)
	{
		super(name);
		this.controller = controller_p;
	}
	
	
	public void run()
	{
		  
		while (controller.getView().getStop() == 0) 
		{
		
				 controller.getModel().getMap().getMonster1().RamdomMovingMonster();
				 controller.getView().updateMap();
				 
				 try {
					Thread.sleep(loop);
				} catch (InterruptedException e) {
					e.printStackTrace();
			}			
		}
	  } 
}
