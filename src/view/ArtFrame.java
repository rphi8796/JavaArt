package view;

import controller.ArtController;

import java.awt.Dimension;

import javax.swing.JFrame;

public class ArtFrame extends JFrame
{
	private ArtController app;
	private ArtPanel appPanel;
	
	public ArtFrame(ArtController app)
	{
		super();
		this.app = app;
		this.appPanel = new ArtPanel(app);
		
		setupFrame();
	}
	
	public void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setSize(1000, 800);
		this.setResizable(true);
		this.setTitle("... Garfunkel");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
