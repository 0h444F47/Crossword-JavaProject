public class Word 
{
    private int x;
    private int y;
    private String direction;
    private String word;
    private String clue;
    private int num;

    public Word(int xPo, int yPo, String dir, String w, String c, int n)
    {
        x = xPo;
        y = yPo;
        direction = dir;
        word = w;
        clue = c;
        num = n;
    }

    public String getDirection()
    {
        return direction;
    }

    public String getWord()
    {
        return word;
    }

    public String getClue()
    {
        return clue;
    }

    public int getXpos()
    {
        return x;
    }

    public int getYpos()
    {
        return y;
    }

    public int getNumber()
    {
        return num;
    }

    public String toString()
    {
        return word;
    }

    public int length()
    {
        return word.length();
    }

}
