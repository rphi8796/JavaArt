package view;

import java.awt.event.MouseListener;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.ArtController;

public class SubPanel extends JPanel
{
	private ArtController app;
	private Color currentColor;
	private BufferedImage currentCanvas;
	private int previousX;
	private int previousY;
	
	public SubPanel(ArtController app)
	{
		super();
		this.app = app;
		this.currentCanvas = new BufferedImage(700, 700, BufferedImage.TYPE_INT_ARGB);
		setupPanel();
		resetPoint();
	}
	
	public void setupPanel()
	{
		this.setPreferredSize(new Dimension(700, 700));
		this.setBackground(new Color(211, 211, 211));
		this.currentColor = Color.BLACK;
	}
	
	public void resetPoint()
	{
		previousX = Integer.MIN_VALUE;
		previousY = Integer.MAX_VALUE;
	}
	
	@Override
	protected void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		graphics.drawImage(currentCanvas, 0, 0, null);
	}
	
	private Color randomColor()
	{
		int red = (int)(Math.random() * 256);
		int green = (int)(Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		int alpha = (int) (Math.random() * 256);
		
		Color random = new Color(red, green, blue, alpha);
		return random;
	}
	
	public void setCurrentColor(String color)
	{
		if(color.equalsIgnoreCase("red"))
		{
			currentColor = ArtPanel.myRed;
		}
		else if(color.equalsIgnoreCase("orange"))
		{
			currentColor = ArtPanel.myOrange;
		}
		else if(color.equalsIgnoreCase("yellow"))
		{
			currentColor = ArtPanel.myYellow;
		}
		else if(color.equalsIgnoreCase("green"))
		{
			currentColor = ArtPanel.myGreen;
		}
		else if(color.equalsIgnoreCase("blue"))
		{
			currentColor = ArtPanel.myBlue;
		}
		else if(color.equalsIgnoreCase("violet"))
		{
			currentColor = ArtPanel.myViolet;
		}
		else
		{
			currentColor = randomColor();
		}
	}
	
	public void drawDot(int currentX, int currentY, int width)
	{
		Graphics2D current = currentCanvas.createGraphics();
		current.setColor(currentColor);
		current.setStroke(new BasicStroke(width));
		current.drawOval(currentX, currentY, width, width);
		repaint();
	}
	
	public void drawLine(int currentX, int currentY, int width)
	{
		Graphics2D current = currentCanvas.createGraphics();
		current.setColor(currentColor);
		current.setStroke(new BasicStroke(width));
		if (previousX == Integer.MIN_VALUE)
		{
			current.drawLine(currentX, currentY, currentX, currentY);
		}
		else
		{
			current.drawLine(previousX, previousY, currentX, currentY);
		}
		previousX = currentX;
		previousY = currentY;
		repaint();
	}
	
	public void loadImage()
	{
		try
		{
			JFileChooser imageChooser = new JFileChooser();
			imageChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			FileFilter imageFilter = new FileNameExtensionFilter("Image files only", ImageIO.getReaderFileSuffixes());
			imageChooser.setFileFilter(imageFilter);
			
			int result = imageChooser.showOpenDialog(this);
			if(result == JFileChooser.APPROVE_OPTION)
			{
				File resultingFile = imageChooser.getSelectedFile();
				BufferedImage newCanvas = ImageIO.read(resultingFile);
				currentCanvas = newCanvas;
				this.setPreferredSize(new Dimension(currentCanvas.getWidth(), currentCanvas.getHeight()));
			}
			repaint();
		}
		catch(IOException error)
		{
			app.handleErrors(error);
		}
	}
	
	public void saveImage()
	{
		try
		{
			JFileChooser saveDialog = new JFileChooser();
			saveDialog.showSaveDialog(this);
			String savePath = saveDialog.getSelectedFile().getPath();
			if (!savePath.endsWith(".png"))
			{
				savePath += ".png";
			}
			ImageIO.write(currentCanvas, "PNG", new File(savePath));
		}
		catch(IOException error)
		{
			app.handleErrors(error);
		}
		catch(NullPointerException badChoice)
		{
			app.handleErrors(badChoice);
		}
	}
	
	
	
	
	
	
	
	
	
	
}
