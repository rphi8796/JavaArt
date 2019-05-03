package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ArtController;


public class ArtPanel extends JPanel
{
	private ArtController app;
	
	private SpringLayout appLayout;
	private JButton redButton;
	private JScrollPane scrolly;
	private ImageIcon duck;
	private JPanel buttonPanel;
	
	
	public ArtPanel(ArtController app)
	{
		super();
		this.app = app;
		
		appLayout = new SpringLayout();
		
		redButton = new JButton();
		
		scrolly = new JScrollPane();
		
		duck = new ImageIcon();
		
		buttonPanel = new JPanel(new GridLayout(1, 0));
	}
	
	public void setupPanel()
	{
		
	}
	
	public void setupScrollPane()
	{
		
	}
	
	public void setupLayout()
	{
		
	}
	
	public void setupListeners()
	{
		
	}
}
