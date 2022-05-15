import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CrossWordPuzzle
{
    private ArrayList<Word> arr;
    private String path;

    public CrossWordPuzzle() throws FileNotFoundException
    {
        arr = new ArrayList<Word>();
        path = "puzzle1.txt";
        place();
    }

    public CrossWordPuzzle(String path) throws FileNotFoundException
    {
        arr = new ArrayList<Word>();
        this.path = path;
        place();
    }



    public void place()
        throws FileNotFoundException
    {
        Scanner s = new Scanner(new File(path));
        while (s.hasNextLine())
        {
            String[] t = s.nextLine().split("-");

            int x = -1;
            int y = -1;
            String dir = null;
            String word = null;
            String clue = null;
            int num = -1;

            for (String str : t)
            {
                if (!str.equals(""))
                {
                    if (x == -1)
                    {
                        x = Integer.parseInt(str);
                    }
                    else if (y == -1)
                    {
                        y = Integer.parseInt(str);
                    }
                    else if (dir == null)
                    {
                        dir = str;
                    }
                    else if (word == null)
                    {
                        word = str;
                    }
                    else if (clue == null)
                    {
                        clue = str;
                    }
                    else if (num == -1)
                    {
                        num = Integer.parseInt(str);
                    }
                }
            }

            arr.add(new Word(x, y, dir, word, clue, num));
        }
        s.close();
    }


    public ArrayList<Word> getArrayList()
    {
        return arr;
    }
}
