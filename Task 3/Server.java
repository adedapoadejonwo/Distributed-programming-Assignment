
import java.io.IOException;
import java.net.*;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server implements Runnable
{
    static byte[] buffer = new byte[1024];
    public static int serverPort = 5000;
    public static DatagramSocket socket = null;
    
    
    static int client1Port = 4998;
    static int client2Port = 4999;
    static int lastClient;
    
    public static String ClientMessage() throws IOException, InterruptedException
    {
        //Return array in format [Client id, client message]
            Arrays.fill(buffer, (byte)0);
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        lastClient = packet.getPort();
        
        socket.receive(packet);
        return new String(buffer, buffer.length).trim();
    }
    
    public static void SentToClient(String message, int port) throws IOException, InterruptedException
    {
         if(message.isEmpty() || port == -1) return;
         byte[] data = (message).getBytes();
         var packet = new DatagramPacket(data, data.length, Task3.address, port);
         packet.setData(data);
         socket.send(packet);
    }

    @Override
    public void run() 
    {
        try {
            socket = new DatagramSocket(serverPort);
            System.out.println("Server is Up");
            while(true)
            {
                String str = Server.ClientMessage();
                System.out.println("Client: " + str);
                if(str.equals("Hi"))
                {
                    SentToClient("hello", lastClient);
                }
                else if(str.equals("exit"))
                {
                    SentToClient(str, client2Port);
                    SentToClient(str, client1Port);
                    break;
                }
                else if(!str.isEmpty())
                {
                    String[] arr = str.split(" ");
                    if(arr[0].equals("1"))
                    {
                        SentToClient(str, client2Port);
                    }
                    else if(arr[0].equals("2"))
                    {
                        SentToClient(str, client1Port);
                    }
                }
                
            }
        } catch (SocketException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException | InterruptedException ex) {
             System.out.println(ex.getMessage());
        }
    }
}