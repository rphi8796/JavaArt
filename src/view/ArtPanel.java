package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ArtController;


public class ArtPanel extends JPanel
{
	private ArtController app;
	
	private SpringLayout appLayout;
	
	private JButton red;
	private JButton orange;
	private JButton yellow;
	private JButton green;
	private JButton blue;
	private JButton violet;
	private JButton random;
	
	
	private JScrollPane scrolly;
	
	private ImageIcon duck;
	
	private JPanel buttonPanel;
	
	
	public ArtPanel(ArtController app)
	{
		super();
		this.app = app;
		
		appLayout = new SpringLayout();
		
		red = new JButton();
		orange = new JButton();
		yellow = new JButton();
		green = new JButton();
		blue = new JButton();
		violet = new JButton();
		random = new JButton();
		
		scrolly = new JScrollPane();
		
		duck = new ImageIcon();
		
		buttonPanel = new JPanel(new GridLayout(1, 0));
	}
	
	public void setupButtons()
	{
		buttonPanel.add(red);
		buttonPanel.add(orange);
		buttonPanel.add(yellow);
		buttonPanel.add(green);
		buttonPanel.add(blue);
		buttonPanel.add(violet);
		buttonPanel.add(random);
	}
	
	public void setupPanel()
	{
		this.setLayout(appLayout);
		
		buttonPanel.setPreferredSize(new Dimension(100, 600));
		this.add(buttonPanel);
		this.add(scrolly);
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
