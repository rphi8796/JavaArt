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
	private SpringLayout appLayout_1;
	
	private SubPanel canvas;
	
	public static Color myRed = new Color(240, 128, 128);
	public static Color myOrange = new Color(255, 140, 0);
	public static Color myYellow = new Color(240, 230, 140);
	public static Color myGreen = new Color(46, 139, 87);
	public static Color myBlue = new Color(0, 191, 255);
	public static Color myViolet = new Color(147, 112, 219);
	
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
	
	private JScrollPane canvasPane_1;
	
	private ImageIcon duck;
	
	private JPanel colorPanel;
	private JPanel menuPanel;
	
	
	public ArtPanel(ArtController app)
	{
		super();
		this.app = app;
		this.canvas = new SubPanel(app);
		appLayout = new SpringLayout();
		
		appLayout_1 = new SpringLayout();
		
		red = new JButton();
		orange = new JButton();
		yellow = new JButton();
		green = new JButton();
		blue = new JButton();
		violet = new JButton();
		random = new JButton();
		
		canvasPane_1 = new JScrollPane();

		
		
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
		this.setPreferredSize(new Dimension(1200, 1000));
		this.setLayout(appLayout_1);
		this.add(menuPanel);
		this.add(colorPanel);
		this.add(canvasPane_1);
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
		
		violet.setOpaque(true);
		blue.setOpaque(true);
		green.setOpaque(true);
		orange.setOpaque(true);
		yellow.setOpaque(true);
		red.setOpaque(true);
		violet.setBorderPainted(false);
		blue.setBorderPainted(false);
		green.setBorderPainted(false);
		yellow.setBorderPainted(false);
		orange.setBorderPainted(false);
		red.setBorderPainted(false);
		
		
		
		violet.setBackground(myViolet);
		blue.setBackground(myBlue);
		green.setBackground(myGreen);
		orange.setBackground(myOrange);
		yellow.setBackground(myYellow);
		red.setBackground(myRed);
		
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
		canvasPane_1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		canvasPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		canvasPane_1.setViewportView(canvas);
	}
	
	public void setupLayout()
	{
		appLayout_1.putConstraint(SpringLayout.NORTH, canvasPane_1, 80, SpringLayout.NORTH, this);
		appLayout_1.putConstraint(SpringLayout.WEST, canvasPane_1, 30, SpringLayout.WEST, this);
		appLayout_1.putConstraint(SpringLayout.SOUTH, canvasPane_1, -80, SpringLayout.SOUTH, this);
		appLayout_1.putConstraint(SpringLayout.EAST, canvasPane_1, -450, SpringLayout.EAST, this);
		
		appLayout_1.putConstraint(SpringLayout.NORTH, colorPanel, 30, SpringLayout.NORTH, this);
		appLayout_1.putConstraint(SpringLayout.WEST, colorPanel, 30, SpringLayout.EAST, canvasPane_1);
		appLayout_1.putConstraint(SpringLayout.SOUTH, colorPanel, -30, SpringLayout.SOUTH, this);
		appLayout_1.putConstraint(SpringLayout.EAST, colorPanel, -300, SpringLayout.EAST, this);
		
		appLayout_1.putConstraint(SpringLayout.NORTH, menuPanel, 30, SpringLayout.NORTH, this);
		appLayout_1.putConstraint(SpringLayout.WEST, menuPanel, 30, SpringLayout.EAST, colorPanel);
		appLayout_1.putConstraint(SpringLayout.SOUTH, menuPanel, -30, SpringLayout.SOUTH, this);
		appLayout_1.putConstraint(SpringLayout.EAST, menuPanel, -30, SpringLayout.EAST, this);
	}
	
	public void setupListeners()
	{
		canvas.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				canvas.drawDot(e.getX(), e.getY(), widthSlider.getValue());
			}
			
			public void mousePressed(MouseEvent e)
			{
				
			}
			
			public void mouseReleased(MouseEvent e)
			{
				canvas.resetPoint();
			}
			
			public void mouseEntered(MouseEvent e)
			{
				canvas.resetPoint();
			}
			
			public void mouseExited(MouseEvent e)
			{
				canvas.resetPoint();
			}
		});
		
		canvas.addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseDragged(MouseEvent e)
			{
				canvas.drawLine(e.getX(), e.getY(), widthSlider.getValue());
			}
			
			public void mouseMoved(MouseEvent e)
			{
				
			}
		});
		
		red.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				canvas.setCurrentColor("red");
			}
		});
		
		orange.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				canvas.setCurrentColor("orange");
			}
		});
		
		yellow.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				canvas.setCurrentColor("yellow");
			}
		});
		
		green.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				canvas.setCurrentColor("green");
			}
		});
		
		blue.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				canvas.setCurrentColor("blue");
			}
		});
		
		violet.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				canvas.setCurrentColor("violet");
			}
		});
		
		random.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				canvas.setCurrentColor("random");
			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				canvas.saveImage();
			}
		});
		
		loadButton.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent click)
			{
				canvas.loadImage();
			}
		});
	}
	

}
