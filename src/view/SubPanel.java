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
	Graphics2D myGraphics;
	
	public SubPanel(ArtController app)
	{
		super();
		this.app = app;
		this.currentCanvas = new BufferedImage(1200, 1000, BufferedImage.TYPE_INT_ARGB);
		setupPanel();
		resetPoint();
	}
	
	public void setupPanel()
	{
		this.setPreferredSize(new Dimension(1200, 1000));
		this.setBackground(new Color(255, 255, 255));
		this.currentColor = (new Color(255, 182, 193));
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
		myGraphics = (Graphics2D) (graphics);
		createPattern();
	}
	
	public void createPattern()
	{
		myGraphics.setColor(currentColor);
		myGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		myGraphics.drawImage(currentCanvas, 0, 0, null);
		myGraphics.drawRect(450, 350, 300, 300);
		myGraphics.drawRect(300, 150, 600, 600);
		
		myGraphics.drawLine(300, 150, 450, 350);
		myGraphics.drawLine(300, 750, 450, 650);
		myGraphics.drawLine(900, 150, 750, 350);
		myGraphics.drawLine(900, 750, 750, 650);
		

		
		//Grid in the middle
		for(int x = 450; x < 750; x += 10)
		{
			myGraphics.drawLine(x, 350, x, 650);
			myGraphics.drawLine(450, x - 100, 750, x - 100);
		}
		
		//Vertical lines for top trapezoid
		for(int i = 460, x = -140; i < 750; i += 10, x += 10)
		{
			myGraphics.drawLine(i, 350, i + x, 150);
		}
		
		//Vertical lines for bottom trapezoid
		for(int i = 460, x = -140; i < 750; i += 10, x += 10)
		{
			myGraphics.drawLine(i, 650, i + x, 750);
		}
		
		//Vertical line for left trap
		for(double i = 350, y = -200; i < 501; i += 10, y += 13.333333)
		{
			int intI = (int) i;
			int intY = (int) y;
			myGraphics.drawLine(300, intI + intY, 450, intI);
		}
		for(double i = 500, y = 0; i < 650; i += 10, y += 6.666666)
		{
			int intI = (int) i;
			int intY = (int) y;
			myGraphics.drawLine(300, intI + intY, 450, intI);
		}
		//end
		
		//Vertical line for right trap
		for(double i = 350, y = -200; i < 501; i += 10, y += 13.333333)
		{
			int intI = (int) i;
			int intY = (int) y;
			myGraphics.drawLine(900, intI + intY, 750, intI);
		}
		for(double i = 500, y = 0; i < 650; i += 10, y += 6.666666)
		{
			int intI = (int) i;
			int intY = (int) y;
			myGraphics.drawLine(900, intI + intY, 750, intI);
		}
		//end
		myGraphics.setColor(Color.CYAN);
		//Makes the first layer of horizontal lines
		for(int x = 1; x < 30; x += 1)
		{
			int y = (int ) ((.225 * x * x) + (-.255 * x) + 1);
			int xOne = (int) ((-0.168751 * x * x) + (0.168784 * x) + 449.25);
			int length = (int) ((0.3375 * x * x) + (-0.3375 * x) + 301.5);
			length -= 1;
			xOne += 1;
			myGraphics.drawRect(xOne, 350 - y, length, length);
//			myGraphics.drawLine(xOne, 350 - y , xTwo, 350 - y);
//			myGraphics.drawLine(xOne, 150, xOne, 750);
		}
		
		
		myGraphics.setColor(Color.WHITE);
		myGraphics.drawLine(0, 0, 300, 150);
		myGraphics.drawLine(0, 1000, 300, 750);
		myGraphics.drawLine(1200, 1000, 900, 750);
		myGraphics.drawLine(1200, 0, 900, 150);
		//Vertical lines for top top trapezoid
		for(int i = 320, x = -280; i < 900; i += 20, x += 20)
		{
			myGraphics.drawLine(i, 150, i + x, 0);
		}
		
		//Vertical lines for bottom bottom trapezoid
		for(int i = 320, x = -280; i < 900; i += 20, x += 20)
		{
			myGraphics.drawLine(i, 750, i + x, 1000);
		}
		
		//Vertical line for side trap bottoms
		for(double i = 350, y = -200, shift = -150; i < 501; i += 10, y += 13.333333, shift += 10)
		{
			int intI = (int) i;
			int intY = (int) y;
			int intShift = (int) shift;
			myGraphics.drawLine(0, intI + intY + intShift, 300, intI+ intY);
		}
		for(double i = 500, y = 0, shift = 0; i < 650; i += 10, y += 6.666666, shift += 15)
		{
			int intI = (int) i;
			int intY = (int) y;
			int intShift = (int) shift;
			myGraphics.drawLine(0, intI + intY + intShift, 300, intI + intY);
			
		}
		//end
		
		//Vertical line for side trap bottoms
		for(double i = 350, y = -200, shift = -150; i < 501; i += 10, y += 13.333333, shift += 10)
		{
			int intI = (int) i;
			int intY = (int) y;
			int intShift = (int) shift;
			myGraphics.drawLine(1200, intI + intY + intShift, 900, intI+ intY);
		}
		for(double i = 500, y = 0, shift = 0; i < 650; i += 10, y += 6.666666, shift += 15)
		{
			int intI = (int) i;
			int intY = (int) y;
			int intShift = (int) shift;
			myGraphics.drawLine(1200, intI + intY + intShift, 900, intI + intY);
			
		}
		
		
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
