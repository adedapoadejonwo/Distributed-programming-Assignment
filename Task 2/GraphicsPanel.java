import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
class GraphicsPanel extends JPanel implements ActionListener, KeyListener
{
	Timer tickTimer; 
	ImageIcon[] car1Sprites;
        ImageIcon[] car2Sprites;  
	int car1SpriteIndex = 1, car2SpriteIndex = 1;
        Dimension car1Position, car2Position;
        int car1Speed = 0, car2Speed = 0;
	int timerSpinRate = 100; //In milliseconds
	
	public GraphicsPanel() 
	{
            
		tickTimer = new Timer(timerSpinRate, (ActionListener) this);
		car1Sprites = new ImageIcon[16];
                car2Sprites = new ImageIcon[16];
                
                car1Position = new Dimension(500, 450);
                car2Position = new Dimension(500, 500);
	     
	    //Put images in array 
		for(int i = 1; i <= car1Sprites.length; i++)
			 car1Sprites[i-1] =  new ImageIcon("Sprites 1\\" + String.valueOf(i) + ".png");
                for(int i = 1; i <= car1Sprites.length; i++)
			 car2Sprites[i-1] =  new ImageIcon("Sprites 2\\" + String.valueOf(i) + ".png");
		
                 this.setFocusable(true);
                addKeyListener(this);
		tickTimer.start();
            
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
            moveCar1();
            moveCar2();
            manageCar1Intersection();
            manageCar2Intersection();
            checkClash();
            repaint();
	}
        
        void checkClash()
        {
            Rectangle car1 = new Rectangle(car1Position.width,car1Position.height, 30, 30);
            Rectangle car2 = new Rectangle(car2Position.width,car2Position.height, 30, 30);
            //if cars crash
            if(car1.intersects(car2))
            {
                car1Position = new Dimension(500, 450);
                car2Position = new Dimension(500, 500);
                car1SpriteIndex = 1;
                car2SpriteIndex = 1;
                car1Speed = 0;
                car2Speed = 0;
                repaint();
                JOptionPane.showMessageDialog(this,"Game restarted. Close window if you wish to end the game");
            }
        }
        
        void manageCar1Intersection()
        {
            if(car1Position.width > 700)
            {
                car1Position.width = 700;
                car1Speed = 2;
                car1SpriteIndex = 5;
            }
            if(car1Position.width < 50)
            {
                car1Position.width = 50;
                car1Speed = 2;
                car1SpriteIndex = 13;
            }
            if(car1Position.height < 50)
            {
                car1Position.height = 50;
                car1Speed = 2;
                car1SpriteIndex = 9;
            }
            if(car1Position.height > 500)
            {
                car1Position.height = 500;
                car1Speed = 2;
            }
            
            int carX = car1Position.width;
            int carY = car1Position.height;
            //g.fillRect( 150, 150, 500, 300);  //Grass
            
            if(carY > 155 && carY < 440 && carX > 145 && carX < 645)
            {
                car1Speed = 2;
            }
           
        }
        
        void manageCar2Intersection()
        {
            if(car2Position.width > 700)
            {
                car2Position.width = 700;
                car2Speed = 2;
                car2SpriteIndex = 5;
            }
            if(car2Position.width < 50)
            {
                car2Position.width = 50;
                car2Speed = 2;
                car2SpriteIndex = 13;
            }
            if(car2Position.height < 50)
            {
                car2Position.height = 50;
                car2Speed = 2;
                car2SpriteIndex = 9;
            }
            if(car2Position.height > 500)
            {
                car2Position.height = 500;
                car2Speed = 2;
            }
            
            int carX = car2Position.width;
            int carY = car2Position.height;
            //g.fillRect( 150, 150, 500, 300);  //Grass
            
            if(carY > 155 && carY < 440 && carX > 145 && carX < 645)
            {
                car2Speed = 2;
            }
           
        }
        
        void moveCar1()
        {
            if(car1SpriteIndex == 1)
            {
                car1Position.width += car1Speed;
            }
            if(car1SpriteIndex >= 2 && car1SpriteIndex <= 4)
            {
                car1Position.width += car1Speed;
                car1Position.height -= car1Speed/2;
            }
            if(car1SpriteIndex == 5)
            {
                car1Position.height -= car1Speed;
            }
            if(car1SpriteIndex >= 6 && car1SpriteIndex <= 8)
            {
                car1Position.width -= car1Speed/2;
                car1Position.height -= car1Speed/2;
            }
            if(car1SpriteIndex == 9)
            {
                car1Position.width -= car1Speed;
            }
            if(car1SpriteIndex >= 10 && car1SpriteIndex <= 12)
            {
                car1Position.width -= car1Speed/2;
                car1Position.height += car1Speed/2;
            }
            if(car1SpriteIndex == 13)
            {
                car1Position.height += car1Speed;
            }
            if(car1SpriteIndex >= 14 && car1SpriteIndex <= 16)
            {
                car1Position.width += car1Speed/2;
                car1Position.height += car1Speed/2;
            }
        }
        
        void moveCar2()
        {
            if(car2SpriteIndex == 1)
            {
                car2Position.width += car2Speed;
            }
            if(car2SpriteIndex >= 2 && car2SpriteIndex <= 4)
            {
                car2Position.width += car2Speed;
                car2Position.height -= car2Speed/2;
            }
            if(car2SpriteIndex == 5)
            {
                car2Position.height -= car2Speed;
            }
            if(car2SpriteIndex >= 6 && car2SpriteIndex <= 8)
            {
                car2Position.width -= car2Speed/2;
                car2Position.height -= car2Speed/2;
            }
            if(car2SpriteIndex == 9)
            {
                car2Position.width -= car2Speed;
            }
            if(car2SpriteIndex >= 10 && car2SpriteIndex <= 12)
            {
                car2Position.width -= car2Speed/2;
                car2Position.height += car2Speed/2;
            }
            if(car2SpriteIndex == 13)
            {
                car2Position.height += car2Speed;
            }
            if(car2SpriteIndex >= 14 && car2SpriteIndex <= 16)
            {
                car2Position.width += car2Speed/2;
                car2Position.height += car2Speed/2;
            }
        }
        
        
	
	@Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.gray);  g.fillRect(0, 0, getWidth(), getHeight());     
        g.setColor(Color.black);  g.drawRect(50, 50, 700, 500);          
        g.setColor(Color.darkGray);  g.fillRect(50, 50, 700, 500);         
        g.setColor(Color.darkGray);  g.fillRect( 150, 100, 600, 400 );   
        g.setColor(Color.white);  g.drawRect( 100, 100, 600, 400 ); // mid-lane              
        g.setColor(Color.green);  g.fillRect( 150, 150, 500, 300);  //Grass
        g.drawLine( 425, 450, 425, 550 ); // start line 
        
        car1Sprites[car1SpriteIndex - 1].paintIcon(this, g, car1Position.width, car1Position.height);
        car2Sprites[car2SpriteIndex - 1].paintIcon(this, g, car2Position.width, car2Position.height);
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) 
    {
        //Key controls for car 1
        if(e.getKeyCode() == KeyEvent.VK_W && car1Speed < 10) car1Speed++;
        if(e.getKeyCode() == KeyEvent.VK_S && car1Speed > 0) car1Speed--;
        if(e.getKeyCode() == KeyEvent.VK_D)
        {
            car1SpriteIndex--;
            if(car1SpriteIndex == 0) car1SpriteIndex = 16;
        }
        if(e.getKeyCode() == KeyEvent.VK_A)
        {
            car1SpriteIndex++;
            if(car1SpriteIndex == 17) car1SpriteIndex = 1;
        }
        
        //Key controls for car 2
        if(e.getKeyCode() == KeyEvent.VK_UP && car2Speed < 10) car2Speed++;
        if(e.getKeyCode() == KeyEvent.VK_DOWN && car2Speed > 0) car2Speed--;
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            car2SpriteIndex--;
            if(car2SpriteIndex == 0) car2SpriteIndex = 16;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            car2SpriteIndex++;
            if(car2SpriteIndex == 17) car2SpriteIndex = 1;
        }
    }

    

}