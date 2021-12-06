import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client implements Runnable 
{
    static byte[] buffer = new byte[1024];
    public static DatagramSocket socket;
    
    public static boolean sendMessage(String m) throws IOException 
    {
        byte buff[] = m.getBytes(); 

        DatagramPacket packet = new DatagramPacket(buff, buff.length, Task3.address, Server.serverPort);

        socket.send(packet);
        
        return !m.equals("exit"); 
    }
    
    public String Recieve()
    {
        //Initalize packet
        try
        {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet);
            String m = new String(packet.getData(), 0, packet.getLength());
            return m;
        }
        catch (Exception e)
        {
            return null;
        }
        
    }
    
    private boolean HandleRecieve() throws IOException 
    {
        
            String recieve = Recieve();
            System.out.println("Server: " + recieve);
            if(recieve.equals("exit")) return false;
            else
            {
                if(recieve.equals("hello")) return true;
                else if(!recieve.isEmpty())
                {
                    try{
                        Task3.mainFrame.SetChanges(recieve.split(" "));
                    }catch(Exception e){}
                }
            }
        return true;
                
    }

    @Override
    public void run() 
    {
         boolean connected = false;
        
        //Wait for client to succesfully send packet
        while(!connected)
        {
            try 
            {
                sendMessage("Hi");
                connected = true;

            } catch (Exception e) {}
        }
        while (true) 
        {
            try {
                if(!HandleRecieve())break;
            }
            catch (IOException ex) {System.out.println(ex.getMessage());}
        }

    }

}
