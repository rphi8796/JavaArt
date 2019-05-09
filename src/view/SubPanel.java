package view;

import java.awt.event.MouseListener;

import controller.ArtController;
import javax.swing.*;

public class SubPanel extends JPanel
{
	ArtController app;
	
	public SubPanel(ArtController app)
	{
		this.app = app;
	}
}
