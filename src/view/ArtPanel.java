package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.*;

import java.awt.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Hashtable;

import controller.ArtController;


public class ArtPanel extends JPanel
{
	private final int MINIMUM_LINE = 1;
	private final int MAXIMUM_LINE = 25;
	
	private ArtController app;
	
	private SpringLayout appLayout;
	
	private SubPanel canvas;
	
	private JButton red;
	private JButton orange;
	private JButton yellow;
	private JButton green;
	private JButton blue;
	private JButton violet;
	private JButton random;
	private JButton saveButton;
	private JButton loadButton;
	private JButton clearButton;
	
	private JSlider widthSlider;
	
	private JScrollPane canvasPane;
	
	private ImageIcon duck;
	
	private JPanel colorPanel;
	private JPanel menuPanel;
	
	
	public ArtPanel(ArtController app)
	{
		super();
		this.app = app;
		this.canvas = new SubPanel(app);
		canvasPane = new JScrollPane();
		appLayout = new SpringLayout();
		
		appLayout = new SpringLayout();
		
		red = new JButton();
		orange = new JButton();
		yellow = new JButton();
		green = new JButton();
		blue = new JButton();
		violet = new JButton();
		random = new JButton();
		
		canvasPane = new JScrollPane();
		
		duck = new ImageIcon();
		
		saveButton = new JButton("Save panel");
		loadButton = new JButton("load new panel");
		clearButton = new JButton("Clear the panel");
		widthSlider = new JSlider(MINIMUM_LINE,MAXIMUM_LINE);
		colorPanel = new JPanel(new GridLayout(0, 1));
		menuPanel = new JPanel(new GridLayout(0, 1));
		
		setupButtons();
		setupPanel();
		setupSlider();
		setupMenuPanels();
		setupScrollPane();
		setupLayout();
		setupListeners();
	}
	
	public void setupButtons()
	{
		colorPanel.add(red);
		colorPanel.add(orange);
		colorPanel.add(yellow);
		colorPanel.add(green);
		colorPanel.add(blue);
		colorPanel.add(violet);
		colorPanel.add(random);
	}
	
	public void setupPanel()
	{
		this.setLayout(appLayout);
		
		this.add(colorPanel);
		this.add(canvasPane);
	}
	
	public void setupSlider()
	{
		Hashtable<Integer, JLabel> scaleLabels = new Hashtable<Integer, JLabel>();
		scaleLabels.put(MINIMUM_LINE, new JLabel("<HTML>Small<BR>Line</HTML>"));
		scaleLabels.put(MAXIMUM_LINE, new JLabel("<HTML>Large<BR>Line</HTML>"));
		widthSlider.setLabelTable(scaleLabels);
		widthSlider.setSnapToTicks(true);
		widthSlider.setMajorTickSpacing(5);
		widthSlider.setMinorTickSpacing(1);
		widthSlider.setPaintTicks(true);
		widthSlider.setPaintLabels(true);
		widthSlider.setValue((MAXIMUM_LINE + MINIMUM_LINE) / 2);
	}
	
	public void setupMenuPanels()
	{
		colorPanel.setPreferredSize(new Dimension(50, 700));
		menuPanel.setPreferredSize(new Dimension(50, 700));
		
		violet.setForeground(new Color(75, 0, 130));
		blue.setForeground(Color.BLUE);
		green.setForeground(Color.GREEN);
		orange.setForeground(Color.ORANGE);
		yellow.setForeground(Color.YELLOW);
		red.setForeground(Color.RED);
		
		colorPanel.add(red);
		colorPanel.add(orange);
		colorPanel.add(yellow);
		colorPanel.add(green);
		colorPanel.add(blue);
		colorPanel.add(violet);
		
		menuPanel.add(widthSlider);
		menuPanel.add(loadButton);
		menuPanel.add(saveButton);
		menuPanel.add(clearButton);
	}
	
	public void setupScrollPane()
	{
		canvasPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		canvasPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		canvasPane.setViewportView(canvas);
	}
	
	public void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, colorPanel,0,SpringLayout.NORTH, canvasPane);
		appLayout.putConstraint(SpringLayout.SOUTH, colorPanel,0,SpringLayout.SOUTH, canvasPane);
		appLayout.putConstraint(SpringLayout.WEST, colorPanel,50,SpringLayout.EAST, canvasPane);
		appLayout.putConstraint(SpringLayout.EAST, colorPanel,0,SpringLayout.WEST, menuPanel);
		
		appLayout.putConstraint(SpringLayout.WEST, colorPanel,200,SpringLayout.EAST, canvasPane);
		appLayout.putConstraint(SpringLayout.SOUTH, colorPanel,0,SpringLayout.SOUTH, canvasPane);
		appLayout.putConstraint(SpringLayout.EAST, colorPanel, -50,SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, colorPanel,0,SpringLayout.NORTH, canvasPane);
		
		appLayout.putConstraint(SpringLayout.NORTH, colorPanel,25,SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, colorPanel,50,SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, colorPanel,-50,SpringLayout.SOUTH, this);
	}
	
	public void setupListeners()
	{
		canvas.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e)
			{
				
			}
			
			public void mousePressed(MouseEvent e)
			{
				
			}
			
			public void mouseReleased(MouseEvent e)
			{
				
			}
			
			public void mouseEntered(MouseEvent e)
			{
				
			}
			
			public void mouseExited(MouseEvent e)
			{
				
			}
		});
		
		canvas.addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseDragged(MouseEvent e)
			{
				
			}
			
			public void mouseMoved(MouseEvent e)
			{
				
			}
		});
	}
}
