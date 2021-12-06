import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.*;

class MainJFrame  extends JFrame
{
		private final GraphicsPanel graphicsPanel; //Graphic engine of the program
		
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


public class Task3
{
        public static Socket socket;
        public static int assignedCar;
        
	public static void main(String[] args) 
	{ 
		new MainJFrame();
                
                try
                {
                    //Start server on this client
                    new Thread(new Server()).start();
                    assignedCar = 1;
                }catch(Exception e)
                {
                    //Assign car 2
                    assignedCar = 2;
                }
	}
}
