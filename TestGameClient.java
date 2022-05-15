import java.net.*;
import java.io.*;
import java.util.*;

public class TestGameClient
{
    private Socket socket;
    private InputStreamReader inputStreamReader;
    private OutputStreamWriter outputStreamWriter;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private Scanner scanner;

    public TestGameClient()
    {
        try
        {
            socket = new Socket("localhost", 4747);

            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            Scanner scanner = new Scanner(System.in);

            while (true)
            {
                String roll = bufferedReader.readLine();
                System.out.println("Guess the roll");

                System.out.println("The roll is " + roll);

                System.out.println("quit prompt");
                String e = scanner.nextLine();
                
                if (e.equalsIgnoreCase("q"))
                {
                    break;
                }
            }
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

    public void game()
    {
        try
        {   
            while (true)
            {
                String roll = bufferedReader.readLine();
                System.out.println("Guess the roll");

                System.out.println("The roll is " + roll);

                System.out.println("quit prompt");
                String e = scanner.nextLine();
                
                if (e.equalsIgnoreCase("q"))
                {
                    break;
                }
            }
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

    public static void main(String[] args)
    {
        TestGameClient testGameClient = new TestGameClient();
    }
}