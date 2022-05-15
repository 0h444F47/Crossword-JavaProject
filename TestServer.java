import java.net.*;
import java.io.*;
import javax.swing.*;

public class TestServer 
{
    public static void main(String[] args) throws IOException
    {
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        ServerSocket serverSocket = null;

        serverSocket = new ServerSocket(1234);

        System.out.println("Server started");

        while (true)
        {
            try
            {
                socket = serverSocket.accept();
                System.out.println("Client connected");

                inputStreamReader = new InputStreamReader(socket.getInputStream());
                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
    
                bufferedReader = new BufferedReader(inputStreamReader);
                bufferedWriter = new BufferedWriter(outputStreamWriter);    

                while (true)
                {
                    String msgFromClient = bufferedReader.readLine();
                    System.out.println("Client: " + msgFromClient); 

                    if (msgFromClient.equalsIgnoreCase("open"))
                    {
                        CrossWindow window = new CrossWindow();
                        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        window.setVisible(true);
                        window.setBounds(0, 0, 800, 400);                
                        bufferedWriter.write("open");
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    }

                    bufferedWriter.write("MSG received.");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                    if (msgFromClient.equalsIgnoreCase("BYE"))
                    {
                        break;
                    }
                }

                
                inputStreamReader.close();
                outputStreamWriter.close();
                bufferedReader.close();
                bufferedWriter.close();
            }
            catch (IOException i)
            {   
                i.printStackTrace();
            }
        }
    }
}
