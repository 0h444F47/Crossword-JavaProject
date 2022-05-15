import java.net.*;
import java.util.*;
import java.io.*;
import javax.swing.*;

public class TestClient 
{
    public static void main(String[] args)
    {
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try
        {
            socket = new Socket("172.18.230.121", 1234);

            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            Scanner scanner = new Scanner(System.in);

            while (true)
            {
                String msgToSend = scanner.nextLine();

                bufferedWriter.write(msgToSend);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                String msgFromServer = bufferedReader.readLine();

                System.out.println("Server: " + msgFromServer);

                if (msgFromServer.equalsIgnoreCase("open"))
                {
                    CrossWindow window = new CrossWindow();
                    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    window.setVisible(true);
                    window.setBounds(0, 0, 800, 400);            
                }
                
                if (msgToSend.equalsIgnoreCase("BYE"))
                {
                    break;
                }
            }
        }
        catch (UnknownHostException u)
        {
            u.printStackTrace();
        }
        catch (IOException i)
        {
            i.printStackTrace();
        }
        finally
        {
            try 
            {
                if (socket != null)
                {
                    socket.close();
                }
                if (inputStreamReader != null)
                {
                    inputStreamReader.close();
                }
                if (outputStreamWriter != null)
                {
                    outputStreamWriter.close();
                }
                if (bufferedReader != null)
                {
                    bufferedReader.close();
                }
                if (bufferedWriter != null)
                {
                    bufferedWriter.close();
                }
            }
            catch ( IOException i)
            {
                i.printStackTrace();
            }
        }
    }
}
