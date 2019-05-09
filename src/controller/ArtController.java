package controller;

import javax.swing.JOptionPane;

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
	
	public void handleErrors(Exception error)
	{
		JOptionPane.showMessageDialog(appFrame, error.getMessage());
	}
}
