import java.util.*;

public class FakePuzzle
{  
    String[][] crossword;
    Map<Integer, String> hints;

    public FakePuzzle()
    {
        crossword = new String[7][7];

        for (int r = 0; r < crossword.length; r++)
        {
            for (int c = 0; c < crossword[r].length; c++)
            {
                crossword[r][c] = "";
            }
        }

        crossword[0][2] = "X1";

        for (int i = 0; i < 4; i++)
        {
            crossword[1][i] = "X";
        }

        crossword[1][0] = "X2";

        crossword[2][2] = "X";

        for (int i = 2; i < 7; i++)
        {
            crossword[3][i] = "X";
        }

        crossword[3][2] = "X3";

        crossword[3][4] = "X4";

        crossword[4][4] = "X";

        for (int i = 1; i < 6; i++)
        {
            crossword[5][i] = "X";
        }

        crossword[5][1] = "X5";

        crossword[6][4] = "X";

        hints = new TreeMap<Integer, String>();
        
        hints.put(1, "DRUM");
        hints.put(2, "HARP");
        hints.put(3, "MUSIC");
        hints.put(4, "SONG");
        hints.put(5, "PIANO");
    }

    public String[][] getCrossword()
    {
        return crossword;
    }

    public String toString()
    {
        String str = "";

        for (String[] r : crossword)
        {
            for (String c : r)
            {
                if (c.equals(""))
                {
                    str += " ";
                }
                else if (c.indexOf("X") != -1)
                {
                    if (c.length() == 2)
                    {
                        str += c.substring(1);
                    }
                    else
                    {
                        str += "X";
                    }
                }
            }
            str += "\n";
        }

        str += "\n1. Drum";
        str += "\n2. Harp";
        str += "\n3. Music";
        str += "\n4. Song";
        str += "\n5. Piano";

        return str;
    }

    public void play()
    {
        Scanner input = new Scanner(System.in);
        System.out.println(toString());
        boolean q = false;
        int i = 0;

        while (q == false)
        {
            System.out.println("Enter Number");

            int num = input.nextInt();
            
            String word = hints.get(num);

            System.out.println("Enter Guess");
            
            String guess = input.next();
            
            if (guess.equalsIgnoreCase(word))
            {
                System.out.println("Yes");
                i++;
            }
            else
            {
                System.out.println("No");
            } 
            
            if (i == 5)
            {
                System.out.println("You win");
                break;
            }

            System.out.println("Quit? y or n");
            
            q = input.next().equals("y");

        }
    }

    public static void main(String[] args)
    {
        FakePuzzle p = new FakePuzzle();

        p.play();
    }
}
