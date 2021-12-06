import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class MainJFrame  extends JFrame
{
		private GraphicsPanel graphicsPanel; //Graphic engine of the program
		
		public MainJFrame() 
		{
			//Setup graphicsPanel
			graphicsPanel = new GraphicsPanel();
			graphicsPanel.setSize(850, 650);
			this.add(graphicsPanel);
			
			//Setup properties
			this.setSize(850, 650);
			this.setResizable(false);
			this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			this.setVisible(true);
		}
}


public class Task2 {

	public static void main(String[] args) 
	{ 
		new MainJFrame();
	}
}
