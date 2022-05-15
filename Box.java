public class Box {
    private char letter;
    private int num;

    public Box(char c, int n)
    {
        letter = c;
        num = n;
    }

    public Box(Character c, int n)
    {
        letter = c;
        num = n;
    }

    public boolean isHead()
    {
        return num != 0;
    }

    public char getChar()
    {
        return letter;
    }

    public int getNum()
    {
        return num;
    }
    
}
