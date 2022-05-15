import java.net.*;
import java.io.*;
import java.util.*;

public class TestGameServer
{
    private ServerSocket serverSocket;
    private Socket socket;
    private InputStreamReader inputStreamReader;
    private OutputStreamWriter outputStreamWriter;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private Scanner scanner;

    public TestGameServer()
    {
        try
        {
            serverSocket = new ServerSocket(4747);
            socket = serverSocket.accept();

            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);    
            
            scanner = new Scanner(System.in);

            game();
        }   
        catch ( IOException i)
        {
            i.printStackTrace();
        }
    }


    public void game()
    {
        try
        {
            while (true)
            {
                int roll = (int) (Math.random() * 6 + 1);
                System.out.println("Guess the roll");

                System.out.println("The roll is " + roll);

                bufferedWriter.write(roll);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                System.out.println("quit prompt");
                String e = scanner.nextLine();
                
                if (e.equalsIgnoreCase("q"))
                {
                    break;
                }
            }
        }
        catch ( IOException i)
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

    public static void main(String[] args)
    {
        TestGameServer testGameServer = new TestGameServer();
    }
}
