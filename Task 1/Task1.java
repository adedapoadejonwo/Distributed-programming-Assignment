import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


@SuppressWarnings("serial")
class GraphicsPanel extends JPanel implements ActionListener
{
	Timer tickTimer; 
	ImageIcon[] car1Sprites; 
	int car1SpriteIndex = 1;
	int timerSpinRate = 100; //In milliseconds
	
	public GraphicsPanel() 
	{
		tickTimer = new Timer(timerSpinRate, (ActionListener) this);
		car1Sprites = new ImageIcon[16];
		String path = "Sprites 1\\"; //Sprite Path
	     
	    //Put images in array 
		for(int i = 1; i <= car1Sprites.length; i++)
			 car1Sprites[i-1] =  new ImageIcon(path + String.valueOf(i) + ".png");
		
		tickTimer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//Event Handler for tickTimer
		car1SpriteIndex++;
		if(car1SpriteIndex == 17) car1SpriteIndex = 1;
		
		repaint();
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        car1Sprites[car1SpriteIndex - 1].paintIcon(this, g, (getWidth() - 50)/2, (getHeight() - 50)/2);
    }

}

class MainJFrame  extends JFrame
{
		private GraphicsPanel graphicsPanel; //Graphic engine of the program
		
		public MainJFrame() 
		{
			//Setup graphicsPanel
			graphicsPanel = new GraphicsPanel();
			graphicsPanel.setSize(200, 200);
			this.add(graphicsPanel);
			
			//Setup properties
			this.setSize(200, 200);
			this.setResizable(false);
			this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			this.setVisible(true);
		}
}


public class Task1 {

	public static void main(String[] args) 
	{ 
		new MainJFrame();
	}
}
