package model;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import showboard.IPawn;

public class Lorann extends Mobile implements IPawn
{
	private Point Positon;
	private int startX;
	private int startY;
	private map map;
	private Image imageLorann[];
	private int numberImage = 0;

	public Lorann(String nameFile, map Map) throws IOException 
	{
		super(nameFile);
		this.map = Map;
		this.RandomStartPosition();
		this.imageLorann = new Image[8];
		int y = 0;
		for (int i = 1; i <= 8;i++)
		{
			this.imageLorann[y] = ImageIO.read(new File("annex/lorann_" + i + ".png"));
			y++;
		}
		
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return this.getPosition().x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.getPosition().y;
	}

	@Override
	public Point getPosition() 
	{
		// TODO Auto-generated method stub
		return this.Positon;
	}

	
	public final void setPosition(Point position)
	{
		this.Positon = position;
	}
	
	public final void setPosition(final int x, final int y)
	{
		this.Positon = new Point(x,y);
	}
	
	public int getStartX() {
		return startX;
	}

	public int getStartY() {
		return startY;
	}
	
	public final void RandomStartPosition()
	{
	int valuesX = 0;
	int valuesY = 0;
	while (map.mapRead[valuesX][valuesY] != 'N')
	{
		Random rX = new Random();
		Random rY = new Random();
		valuesX = 0 + rX.nextInt(19 - 0);
		valuesY = 0 + rY.nextInt(11 - 0);
	}
	this.startX = valuesX;
	this.startY = valuesY;
	}
	
	public final void moveLorann()
	{
		if (numberImage == 8)
		{
			numberImage = 0;
		}
		this.setImage(imageLorann[numberImage]);
		numberImage++;
	}
}
