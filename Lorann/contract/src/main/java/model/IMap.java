package model;

import java.util.Observable;

import showboard.ISquare;

public interface IMap 
{
	public void createMap ();
	public Observable getObservable();
	public void setMapHasChanged();
	public int getHight();
	public void setHight(int hight);
	public int getWidth();
	public void setWidth(int width);
	public ISquare getSquare();
	public void setSquare(int x,int y);
}