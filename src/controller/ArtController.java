package controller;

import view.ArtFrame;
import view.ArtPanel;

public class ArtController 
{
	private ArtFrame appFrame;
	private ArtPanel appPanel;
	
	public void start()
	{
		
	}
	
	public ArtController()
	{
		appFrame = new ArtFrame(this);
		appPanel = new ArtPanel(this);
	}
}
